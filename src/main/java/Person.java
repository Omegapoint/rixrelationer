import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	private Integer födelseÅr;
	private String kön;
	private String efternamn;
	private String tilltalsnamn;
	private String parti;
	private String valkrets;
	private String status;

	public String namn() {
		return tilltalsnamn + " " + efternamn;
	}


	@JsonProperty("fodd_ar")
	public Integer getFödelseÅr() {
		return födelseÅr;
	}

	public void setFödelseÅr(Integer födelseÅr) {
		this.födelseÅr = födelseÅr;
	}

	@JsonProperty("kon")
	public String getKön() {
		return kön;
	}

	public void setKön(String kön) {
		this.kön = kön;
	}

	@JsonProperty("efternamn")
	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	@JsonProperty("tilltalsnamn")
	public String getTilltalsnamn() {
		return tilltalsnamn;
	}

	public void setTilltalsnamn(String tilltalsnamn) {
		this.tilltalsnamn = tilltalsnamn;
	}

	@JsonProperty("parti")
	public String getParti() {
		return parti;
	}

	public void setParti(String parti) {
		this.parti = parti;
	}

	@JsonProperty("valkrets")
	public String getValkrets() {
		return valkrets;
	}

	public void setValkrets(String valkrets) {
		this.valkrets = valkrets;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
