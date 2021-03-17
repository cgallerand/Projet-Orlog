package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("secretaire")
public class Secretaire extends Compte{

	public Secretaire() {
		super();
	}

	public Secretaire(int id, String login, String password) {
		super(id, login, password);
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	

	
}
