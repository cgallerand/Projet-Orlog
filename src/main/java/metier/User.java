package metier;

import java.util.List;

public class User extends Compte {

	private boolean ia;
	private int pointDeVie;
	private int pointDeSort;

	private List<De> des;

	public User() {
		super();
	}

	public User(int id) {
		super(id);
	}

	public User(String login, String password) {
		super(login, password);
	}

	public User(int id, boolean ia, int pointDeVie, int pointDeSort, List<De> des) {
		super(id);
		this.ia = ia;
		this.pointDeVie = pointDeVie;
		this.pointDeSort = pointDeSort;
		this.des = des;
	}

	public User(String login, String password, boolean ia, int pointDeVie, int pointDeSort, List<De> des) {
		super(login, password);
		this.ia = ia;
		this.pointDeVie = pointDeVie;
		this.pointDeSort = pointDeSort;
		this.des = des;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIa() {
		return ia;
	}

	public void setIa(boolean ia) {
		this.ia = ia;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public int getPointDeSort() {
		return pointDeSort;
	}

	public void setPointDeSort(int pointDeSort) {
		this.pointDeSort = pointDeSort;
	}

	public List<De> getDes() {
		return des;
	}

	public void setDes(List<De> des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "User [ia=" + ia + ", pointDeVie=" + pointDeVie + ", pointDeSort=" + pointDeSort + ", des=" + des
				+ ", id=" + id + ", login=" + login + ", password=" + password + "]";
	}

}
