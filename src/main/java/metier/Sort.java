package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sort")
public class Sort {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String sort;
	protected int niveau;

	public Sort() {
		super();
	}

	public Sort(String sort, int niveau) {
		super();
		this.sort = sort;
		this.niveau = niveau;
	}

	public Sort(int id, String sort, int niveau) {
		this.id = id;
		this.sort = sort;
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Sort [id=" + id + ", sort=" + sort + ", niveau=" + niveau + "]";
	}

}