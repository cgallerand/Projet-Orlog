package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("utilisateur")
public class Utilisateur extends Compte {
	
	private Integer level;

	public Utilisateur() {
	}

	public Utilisateur(String login, String password, int level) {
		super(login,password);
		this.level=level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	

}
