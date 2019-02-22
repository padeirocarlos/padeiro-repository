package padeiro.exemplo.angular.model.address;

import javax.persistence.Embeddable;

@Embeddable
public class AddressEntity {

	private String logradouro;
	private String number;
	private String complemento;
	private String outcountry;
	private String cep;
	private String city;
	private String state;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getOutcountry() {
		return outcountry;
	}

	public void setOutcountry(String outcountry) {
		this.outcountry = outcountry;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
