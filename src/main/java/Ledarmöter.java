import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName("personlista")
public class Ledarmöter {
	private PersonLista personLista;

	@JsonProperty("personlista")
	public PersonLista getPersonLista() {
		return personLista;
	}

	public void setPersonLista(PersonLista person) {
		this.personLista = person;
	}
}
