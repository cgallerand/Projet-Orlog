package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("utilisateur")
public class Utilisateur extends Compte {
	
	private Integer level;

	public Utilisateur() {
	}

	public Utilisateur(int id, String login, String password, int level) {
		super(id,login,password);
		this.level=level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	

}
