package metier;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Visite {

	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_patient")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name="id_medecin")
	private Medecin medecin;
	
	private double prix=20;
	
	@Column(name="date_visite")
	private LocalDate date;
	
	private int salle;
	
	
	public Visite(int id, Patient patient, Medecin medecin, double prix, String date, int salle) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.prix = prix;
		this.date = LocalDate.parse(date);
		this.salle = salle;
	}
	
	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.date = LocalDate.now();
		this.salle = medecin.getSalle();
	}
	
	public Visite() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", prix=" + prix + ", date=" + date + ", salle=" + salle + "]";
	}

	
	
	
}
