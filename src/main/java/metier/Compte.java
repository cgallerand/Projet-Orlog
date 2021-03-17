package metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(nullable=false)
	protected String login;

	@Column(nullable=false)
	protected String password;
	protected int level;

	public Compte() {
	}

	public Compte(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public Compte(String login, String password, int level) {
		super();
		this.login = login;
		this.password = password;
		this.level = level;
	}

	public Compte(int id, String login, String password, int level) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}


}
