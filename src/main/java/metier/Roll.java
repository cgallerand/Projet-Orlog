package metier;

public class Roll {

	private int casque;
	private int bouclier;
	private int fleche;
	private int hache;
	private int main;
	private int sort;
	public User user;




	public Roll () {}



	public int getCasque() {
		return casque;
	}

	public void upCasque() {
		casque++;
	}



	public int getBouclier() {
		return bouclier;
	}

	public void upBouclier() {
		bouclier++;
	}




	public int getFleche() {
		return fleche;
	}

	public void upFleche() {
		fleche++;
	}




	public int getHache() {
		return hache;
	}

	public void upHache() {
		hache++;
	}

	public int getSort() {
		return sort;
	}

	public void upSort() {
		sort++;
	}

	public int getMain() {
		return main;
	}

	public void upMain() {
		main++;
	}

	public void combat(Roll r2) {

		int attFr1 = r2.getBouclier()-fleche;

		int attHr1 = r2.getCasque()-hache;

		int attFr2 = bouclier-r2.getFleche();

		int attHr2 = casque-r2.getHache();


		int degatU1=0;
		int degatU2=0;

		if (attFr1 < 0 ) {degatU1+=attFr1;}
		if (attHr1<0) {degatU1+=attHr1;}

		if (attFr2 < 0 ) {degatU2+=attFr2;}
		if (attHr2<0) {degatU2+=attHr2;}

		user.setPointDeVie(user.getPointDeVie()+degatU2);
		r2.user.setPointDeVie(r2.user.getPointDeVie()+degatU1);
		System.out.println(degatU1);
		System.out.println(degatU2);



	}

	@Override
	public String toString() {
		return "Roll [casque=" + casque + ", bouclier=" + bouclier + ", fleche=" + fleche + ", hache=" + hache
				+ ", main=" + main + ", sort=" + sort + "]";
	}

}
