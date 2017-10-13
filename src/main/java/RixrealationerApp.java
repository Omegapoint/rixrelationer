import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

			System.out.println(ledarmöter.getPersonLista().getPerson().size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Anförande tolkaAnforande(Path f){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readerFor(AnförandeWrapper.class).<AnförandeWrapper>readValue(f.toFile()).getAnförande();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
