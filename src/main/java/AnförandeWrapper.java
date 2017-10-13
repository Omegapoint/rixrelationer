import com.fasterxml.jackson.annotation.JsonProperty;

public class AnförandeWrapper {
	private Anförande anförande;

	@JsonProperty("anforande")
	public Anförande getAnförande() {
		return anförande;
	}

	public void setAnförande(Anförande anförande) {
		this.anförande = anförande;
	}
}
