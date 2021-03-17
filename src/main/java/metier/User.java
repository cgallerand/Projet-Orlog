package metier;

import java.util.List;

public class User extends Compte {

	private int id;
	private boolean ia;
	private int pointDeVie;
	private int pointDeSort;

	private List<De> des;

	public User(int id, String login, String password, int level) {
		super(id, login, password, level);
	}

	public User(String login, String password, int level) {
		super(login, password, level);
	}

	public User(boolean ia, int pointDeVie, int pointDeSort, List<De> des) {
		super();
		this.ia = ia;
		this.pointDeVie = pointDeVie;
		this.pointDeSort = pointDeSort;
		this.des = des;
	}

	public User(int id, boolean ia, int pointDeVie, int pointDeSort, List<De> des) {
		super();
		this.id = id;
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
		return "User [id=" + id + ", ia=" + ia + ", pointDeVie=" + pointDeVie + ", pointDeSort=" + pointDeSort
				+ ", des=" + des + "]";
	}

}
