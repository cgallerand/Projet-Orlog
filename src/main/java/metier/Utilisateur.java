package metier;

import javax.persistence.Entity;

@Entity
public class Utilisateur extends Compte {

	public Utilisateur() {
	}

	public Utilisateur(int id, String login, String password,int level) {
		super(id,login,password,level);
	}

}
