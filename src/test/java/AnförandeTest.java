import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AnförandeTest {


	@Test
	public void skaMappaEttAnförande() throws Exception {
		String json = "{" +
				"  \"anforande\": {" +
				"    \"dok_hangar_id\": \"4536109\"," +
				"    \"dok_id\": \"H4091\"," +
				"    \"dok_titel\": \"Protokoll 2016/17:1 Tisdagen den 13 september\"," +
				"    \"dok_rm\": \"2016/17\"," +
				"    \"dok_nummer\": \"1\"," +
				"    \"dok_datum\": \"2016-09-13 00:00:00\"," +
				"    \"avsnittsrubrik\": \"Inledning\"," +
				"    \"underrubrik\": null," +
				"    \"kammaraktivitet\": null," +
				"    \"anforande_id\": \"9c248750-c8a2-e711-945d-00262d0d0c40\"," +
				"    \"anforande_nummer\": \"1\"," +
				"    \"talare\": \"TALMANNEN\"," +
				"    \"parti\": \"TALMANNEN\"," +
				"    \"anforandetext\": \"<p>Inledning</p><p>Klockan är 11.00 och kammarens sammanträde har härmed inletts.</p><p>Hjärtligt välkomna tillbaka till riksdagen. Jag hoppas att ni mellan allt hårt arbete i valkretsen har lyckats unna er en del välförtjänt vila. Hjärtligt välkomna!</p>\"," +
				"    \"intressent_id\": null," +
				"    \"rel_dok_id\": null," +
				"    \"replik\": \"N\"," +
				"    \"systemdatum\": \"2017-09-26 16:38:44\"" +
				"  }" +
				"}";

		ObjectMapper  mapper = new ObjectMapper();
		AnförandeWrapper anförandeWrapper = mapper.readerFor(AnförandeWrapper.class).readValue(json);
		assertThat(anförandeWrapper.getAnförande().getDatum()).isEqualTo(LocalDateTime.of(2016, 9, 13, 0, 0 ,0));


	}
}