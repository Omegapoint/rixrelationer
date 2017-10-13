import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anförande {
	private String talare;
	private String text;
	private String parti;
	private LocalDateTime datum;


	public String getTalare() {
		return talare;
	}

	public void setTalare(String talare) {
		this.talare = talare;
	}

	@JsonProperty("anforandetext")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParti() {
		return parti;
	}

	public void setParti(String parti) {
		this.parti = parti;
	}

	@JsonProperty("dok_datum")
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = ParseDeserializer.class)
	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}
}
