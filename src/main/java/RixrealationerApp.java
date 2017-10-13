import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RixrealationerApp {


	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Ledarmöter ledarmöter = mapper.readerFor(Ledarmöter.class)
					.readValue(new File("ledamoter.json"));

			List<Anförande> anföranden = Files.walk(Paths.get("anforanden"))
					.filter(f -> Files.isRegularFile(f))
					.map(f -> tolkaAnforande(f))
					.collect(Collectors.toList());

			Map<String, Long> collect = anföranden.stream().map(anförande -> skapaRelationer(anförande, ledarmöter))
					.filter(s -> !s.isEmpty())
					.collect(Collectors.groupingBy(key -> key.get(0), Collectors.counting()));

			List<List<String>> relationLista = collect.entrySet().stream()
					.filter(e -> e.getValue()>10 && !e.getKey().contains("null"))
					.map(e -> {
						String[] split = e.getKey().split(",");
						return new ArrayList<>(Arrays.asList(split[0], split[1], e.getValue().toString()));
					})
					.collect(Collectors.toList());

			List<String> keys = collect.entrySet().stream()
					.filter(e -> e.getValue()>10 && !e.getKey().contains("null"))
					.map(k -> k.getKey().split(",")[0])
					.distinct()
					.sorted()
					.collect(Collectors.toList());

			ObjectMapper relMapper = new ObjectMapper();
			relMapper.writerFor(ArrayList.class).writeValue(new File("graf.json"), relationLista);
			relMapper.writerFor(ArrayList.class).writeValue(new File("keys.json"), keys);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> skapaRelationer(Anförande anförande, Ledarmöter ledarmöter) {
		List<Person> träffar = ledarmöter.getPersonLista().getPerson().stream()
				.filter(ledamot -> anförande.getText().contains(ledamot.namn()))
				.collect(Collectors.toList());
		if (!träffar.isEmpty()) {
			return träffar.stream().map(t-> anförande.talare() + ","+ t.namn() + " (" + t.getParti() + ")")
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	private static Anförande tolkaAnforande(Path f){
		ObjectMapper mapper = new ObjectMapper();
		try {
			Anförande anförande = mapper.readerFor(AnförandeWrapper.class).<AnförandeWrapper>readValue(f.toFile()).getAnförande();
			anförande.setFilnamn(f.getFileName());
			return anförande;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
