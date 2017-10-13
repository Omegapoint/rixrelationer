import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RixrealationerApp {


	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Ledarmöter ledarmöter = mapper.readerFor(Ledarmöter.class)
					.readValue(new File("ledamoter.json"));

			System.out.println(ledarmöter.getPersonLista().getPerson().size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
