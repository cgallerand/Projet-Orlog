package metier;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable{

	
	private int numero;
	private String voie;
	private String cp;
	private String ville;
	
	
	public Adresse(int numero, String voie, String cp, String ville) {
		this.numero = numero;
		this.voie = voie;
		this.cp = cp;
		this.ville = ville;
	}
	
	public Adresse() {
		
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", cp=" + cp + ", ville=" + ville + "]";
	}
	
	
}
