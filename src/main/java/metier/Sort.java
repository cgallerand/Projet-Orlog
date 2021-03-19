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
	protected int degat;
	protected int cout;

	public Sort() {
		super();
	}

	public Sort(String sort, int niveau, int degat, int cout) {
		super();
		this.sort = sort;
		this.niveau = niveau;
		this.degat=degat;
		this.cout=cout;
	}

	public Sort(int id, String sort, int niveau, int degat, int cout) {
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

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	@Override
	public String toString() {
		return "Sort [id=" + id + ", sort=" + sort + ", niveau=" + niveau + ", degat=" + degat + ", cout=" + cout + "]";
	}
	
	


}