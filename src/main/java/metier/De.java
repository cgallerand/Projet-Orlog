package metier;

public class De {

	private int id;
	private Integer symbole;
	private User user;

	public De(int id, Integer symbole,User user) {
		this.id = id;
		this.symbole = symbole;
	}

	public De() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSymbole() {
		return symbole;
	}

	public void setSymbole(Integer symbole) {
		this.symbole = symbole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "De [id=" + id + ", symbole=" + symbole + ", user=" + user + "]";
	}


}