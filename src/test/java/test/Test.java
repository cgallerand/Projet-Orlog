package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import metier.Compte;
import metier.De;
import metier.Roll;
import metier.User;
import util.Context;

public class Test {
<<<<<<< HEAD

//	static DAOCompteJPA daoCompte= new DAOCompteJPA();//a enlever
//	static Compte compteConnected;//a enlever
=======
	
	static Compte connected = null;
>>>>>>> develop

	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}

	public static double saisieDouble(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}

	public static int saisieInt(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}

	private static void menuPrincipal() {

		System.out.println("Bienvenue dans orlog :");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Fermer l'appli");
		int choix = saisieInt("");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		default : System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	private static void seConnecter() {

<<<<<<< HEAD

		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");
		
		Compte connected=Context.getInstance().getDaoCompte().checkConnect(login, password);
		
		Context.getInstance().setConnected(connected);
		
		if(connected==null) {System.out.println("Identifiants invalides");seConnecter();}
		else {
			if (connected instanceof Compte)
			{
				choixDifficulte();
			}
			else
			{
				System.out.println("Identifiants invalides \n");
				seConnecter();
			}

=======
		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");
		
		connected = Context.getInstance().getDaoCompte().checkConnect(login,password);

		if (connected instanceof Compte)
		{
			System.out.println("Bienvenu " + connected.getLogin() + " / " + connected.getPassword() + " !");
			choixDifficulte();
		}
		else
		{
			System.out.println("Identifiants invalides \n");
			seConnecter();
>>>>>>> develop
		}
	}

	private static void choixDifficulte() {

		System.out.println("Choisir votre difficulté");
		System.out.println("1 - Facile");
		System.out.println("2 - Difficile (indisponible pour le moment)");
		int choix = saisieInt("");

		switch(choix) 
		{
		case 1 : JeuIAFacile();break;
		case 2 : JeuIADifficile();break;
		default : System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	private static void JeuIAFacile() {


		System.out.println("Pile ou Face (le gagnant commence)");
		System.out.println("1 - Pile");
		System.out.println("2 - Face");
		RandomPiece();
		int choix = saisieInt("");
		if (choix==RandomPiece())
		{
			System.out.println(connected.getLogin() + " / " + connected.getPassword() + ", vous commencez");
			//System.out.println("Vous commencez");

			LancerdeUser2();
		}
		else {
			System.out.println("L'adversaire commence");

			LancerdeUser1();
		}
	}

	private static int RandomPiece() {
		int rpiece=0;
		rpiece=1+(int) (Math.random()*2);
		return rpiece;
	}

	private static void JeuIADifficile() {
		System.out.println("Mode indisponible pour le moment veuillez revenir en arrière (appuyez sur entrer)");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		choixDifficulte();
	}

	public static void LancerdeUser2() {
		// 1: Les joueurs
<<<<<<< HEAD
		User u1 = new User(1, "Jordan", "ajc", false, 20, 0, null);

		User u2 = new User(2, null, null, false, 20, 0, null);
		User ia = new User(3, null, null, false, 20, 0, null);
=======
		Compte u1 = new User(false, 20, 0, null);
		u1.setId(connected.getId());
		//Compte u2 = new User(false, 20, 0, null);
		//u2.setId();
		User ia = new User(true, 20, 0, null);
		ia.setId(3);;
>>>>>>> develop

		// création d'un liste des dé pour le joueur 1
		List<De> listeU1 = new ArrayList<De>();
		De d1 = new De(1, null, (User) u1);// => faire un random à partir de De1
		listeU1.add(d1);
		De d2 = new De(2, null, (User) u1);// => faire un random à partir de De2
		listeU1.add(d2);
		De d3 = new De(3, null, (User) u1);// => faire un random à partir de De3
		listeU1.add(d3);
		De d4 = new De(4, null, (User) u1);// => faire un random à partir de De4
		listeU1.add(d4);
		De d5 = new De(5, null, (User) u1);// => faire un random à partir de De5
		listeU1.add(d5);
		De d6 = new De(6, null, (User) u1);// => faire un random à partir de De6
		listeU1.add(d6);

		// user2 ou IA
		List<De> listeU2 = new ArrayList<De>();
		De d7 = new De(7, null, null);// => faire un random à partir de De1
		listeU2.add(d7);
		De d8 = new De(8, null, null);// => faire un random à partir de De2
		listeU2.add(d8);
		De d9 = new De(9, null, null);// => faire un random à partir de De3
		listeU2.add(d9);
		De d10 = new De(10, null, null);// => faire un random à partir de De4
		listeU2.add(d10);
		De d11 = new De(11, null, null);// => faire un random à partir de De5
		listeU2.add(d11);
		De d12 = new De(12, null, null);// => faire un random à partir de De6
		listeU2.add(d12);

		// ======================================================================================================
		// ======================================================================================================
		/**
		 * Test des méthodes
		 */
		// =========================================== Initialisation des variables
		List<De> listeU1L1 = new ArrayList<De>();
		List<De> listeU1L1C1 = new ArrayList<De>();
		List<De> listeU1L1Rel1 = new ArrayList<De>();

		List<De> listeU1L2 = new ArrayList<De>();
		List<De> listeU1L2C2 = new ArrayList<De>();
		List<De> listeU1L2Rel2 = new ArrayList<De>();

		List<De> listeU1L3 = new ArrayList<De>();
		List<De> listeU1L3C3 = new ArrayList<De>();
		List<De> listeU1L3Rel3 = new ArrayList<De>();

		List<De> listeDeTotalU1 = new ArrayList<De>();

		int cptTotalSort = 0;

		do

		{

			// ============================================================
			System.out.println("\t === Lancer1 ===\n");

			// on lance tous les dés du joueur
			listeU1L1 = lancerDeUser(listeU1);
			((User) u1).setDes(listeU1L1);// on attribut la liste de dé au premier joueur
			System.out.println("Liste des Dés joueur 1:");// on affiche toutes les faces de dés du premier lancé
			for (De de : listeU1L1) {
				System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
			}

			System.out.println("\t === Lancer1 - choix des dés ===");

			// on demande au joueur si il veut choisir des dés
			String choix = saisieString("Voulez-vous choisir des dés et relancer le reste ? (y/n)");
			if (choix.equalsIgnoreCase("y")) {// le joueur fait le choix de garder seulement certains dés

				listeU1L1C1 = choisirDeUser(listeU1L1);// on appelle la méthode choisirDeUser() pour choisir les dés à
				// garder
				System.out.println("Les dés choisis sont (" + listeU1L1C1.size() + "):");
				for (int i = 0; i < listeU1L1C1.size(); i++) {// on affiche tous les dés qui ont été choisis
					System.out.println(listeU1L1C1.get(i).getId() + " : " + facesDes.get(listeU1L1C1.get(i).getSymbole()));
				}
				listeDeTotalU1.addAll(listeU1L1C1);// on stocke les dés gardés

				listeU1L1Rel1 = choisirDeARelancer(listeU1L1, listeU1L1C1);// on appelle la méthode choisirDeARelancer()
				// pour stocker les dés à relancer
				System.out.println("Les dés à relancer sont (" + listeU1L1Rel1.size() + "):");
				System.out.println(listeU1L1Rel1.size());
				for (int i = 0; i < listeU1L1Rel1.size(); i++) {
					System.out.println(
							listeU1L1Rel1.get(i).getId() + " : " + facesDes.get(listeU1L1Rel1.get(i).getSymbole()));
				}

			} else {// le joueur fait le choix de tout garder
				System.out.println("Vous avez choisi de tout garder !");
				listeDeTotalU1 = listeU1L1;
			}

			if (listeDeTotalU1.size() < 5) {

				System.out.println("============================================\n");
				System.out.println("\t === Lancer2 ===\n");

				listeU1L2 = lancerDeUser(listeU1L1Rel1);
				System.out.println("Liste des Dés à relancer joueur 1:");
				for (De de : listeU1L2) {
					System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
				}

				System.out.println("\t === Lancer2 - choix des dés ===");

				// on demande au joueur si il veut choisir des dés
				String choix1 = saisieString("Voulez-vous choisir des dés et relancer le reste ? (y/n)");
				if (choix1.equalsIgnoreCase("y")) {

					listeU1L2C2 = choisirDeUser(listeU1L2);
					System.out.println("Les dés choisis sont (" + listeU1L2C2.size() + "):");
					for (int i = 0; i < listeU1L2C2.size(); i++) {
						System.out.println(
								listeU1L2C2.get(i).getId() + " : " + facesDes.get(listeU1L2C2.get(i).getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L2C2);

					listeU1L2Rel2 = choisirDeARelancer(listeU1L2, listeU1L2C2);
					System.out.println("Les dés à relancer sont (" + listeU1L2Rel2.size() + "):");
					for (int i = 0; i < listeU1L2Rel2.size(); i++) {
						System.out.println(
								listeU1L2Rel2.get(i).getId() + " : " + facesDes.get(listeU1L2Rel2.get(i).getSymbole()));
					}
				} else {// le joueur fait le choix de tout garder
					System.out.println("Vous avez choisi de tout garder !");
					listeDeTotalU1 = listeU1L1;
				}

				if (listeDeTotalU1.size() < 5) {

					System.out.println("============================================\n");
					System.out.println("\t === Lancer3 ===\n");

					listeU1L3 = lancerDeUser(listeU1L2Rel2);
					System.out.println("Liste des Dés à relancer joueur 1:");
					for (De de : listeU1L3) {
						System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L3);

				}

			}
			System.out.println("============================================\n");
			System.out.println("\t === Infos global joueur ===\n");
			System.out.println("Le joueur1 a " + ((User) u1).getPointDeVie() + " point de vie");
			System.out.println("Le joueur1 a choisi ces faces de dé :");
			for (int i = 0; i < listeDeTotalU1.size(); i++) {
				System.out
				.println(listeDeTotalU1.get(i).getId() + " : " + facesDes.get(listeDeTotalU1.get(i).getSymbole()));

			}


			Roll r1 = new Roll();
			r1.user = (User) u1;
			for (De de : listeDeTotalU1) {
				int val = de.getSymbole();
				switch (val) {

				case 5 : r1.upSort();
				case 0 : r1.upCasque();break;
				case 6 : r1.upSort();
				case 1 : r1.upBouclier();break;
				case 7 : r1.upSort();
				case 2 : r1.upFleche();break;
				case 8 : r1.upSort();
				case 3 : r1.upHache();break;
				case 9 : r1.upSort();
				case 4 : r1.upMain();break;

				}	
			}


			System.out.println();

			List<De> listeUs = lancerDeUser(listeU2);
			Roll r2 = new Roll();
			r2.user = ia;
			for (De de : listeUs) {
				int val = de.getSymbole();
				switch (val) {

				case 5 : r2.upSort();
				case 0 : r2.upCasque();break;
				case 6 : r2.upSort();
				case 1 : r2.upBouclier();break;
				case 7 : r2.upSort();
				case 2 : r2.upFleche();break;
				case 8 : r2.upSort();
				case 3 : r2.upHache();break;
				case 9 : r2.upSort();
				case 4 : r2.upMain();break;

				}	
			}
			System.out.println(r2);


			System.out.println("PV j1 "+((User) u1).getPointDeVie());
			System.out.println("PV j2 "+ia.getPointDeVie());

			r1.combat(r2);


			System.out.println("PV j1 "+((User) u1).getPointDeVie());
			System.out.println("PV j2 "+ia.getPointDeVie());

		}

		while (((User) u1).getPointDeVie()>0 && ia.getPointDeVie()>0);

		if (((User) u1).getPointDeVie()>ia.getPointDeVie() || ((User) u1).getPointDeVie()!=ia.getPointDeVie())
		{
			System.out.println("Fin du jeu, le joueur 1 a gagné la partie");
		}

		else 
		{
			if (ia.getPointDeVie()>((User) u1).getPointDeVie() || ((User) u1).getPointDeVie()!=ia.getPointDeVie())
			{
				System.out.println("Fin du jeu, le joueur 2 a gagné la partie");
			}
			else {
				if (ia.getPointDeVie()==((User) u1).getPointDeVie() )
				{
					System.out.println("Fin du jeu, égalité");
				}
			}
		}
	}

	public static void LancerdeUser1() {
		// 1: Les joueurs
<<<<<<< HEAD
		User u1 = new User(1, "Jordan", "ajc", false, 20, 0, null);
		User u2 = new User(2, null, null, false, 20, 0, null);
		User ia = new User(3, null, null, false, 20, 0, null);
=======
		Compte u1 = new User(false, 20, 0, null);
		u1.setId(connected.getId());
		//Compte u2 = new User(false, 20, 0, null);
		//u2.setId();
		User ia = new User(true, 20, 0, null);
		ia.setId(3);;
>>>>>>> develop

		// création d'un liste des dé pour le joueur 1
		List<De> listeU1 = new ArrayList<De>();
		De d1 = new De(1, null, (User) u1);// => faire un random à partir de De1
		listeU1.add(d1);
		De d2 = new De(2, null, (User) u1);// => faire un random à partir de De2
		listeU1.add(d2);
		De d3 = new De(3, null, (User) u1);// => faire un random à partir de De3
		listeU1.add(d3);
		De d4 = new De(4, null, (User) u1);// => faire un random à partir de De4
		listeU1.add(d4);
		De d5 = new De(5, null, (User) u1);// => faire un random à partir de De5
		listeU1.add(d5);
		De d6 = new De(6, null, (User) u1);// => faire un random à partir de De6
		listeU1.add(d6);

		// user2 ou IA
		List<De> listeU2 = new ArrayList<De>();
		De d7 = new De(7, null, null);// => faire un random à partir de De1
		listeU2.add(d7);
		De d8 = new De(8, null, null);// => faire un random à partir de De2
		listeU2.add(d8);
		De d9 = new De(9, null, null);// => faire un random à partir de De3
		listeU2.add(d9);
		De d10 = new De(10, null, null);// => faire un random à partir de De4
		listeU2.add(d10);
		De d11 = new De(11, null, null);// => faire un random à partir de De5
		listeU2.add(d11);
		De d12 = new De(12, null, null);// => faire un random à partir de De6
		listeU2.add(d12);

		// ======================================================================================================
		// ======================================================================================================
		/**
		 * Test des méthodes
		 */
		// =========================================== Initialisation des variables
		List<De> listeU1L1 = new ArrayList<De>();
		List<De> listeU1L1C1 = new ArrayList<De>();
		List<De> listeU1L1Rel1 = new ArrayList<De>();

		List<De> listeU1L2 = new ArrayList<De>();
		List<De> listeU1L2C2 = new ArrayList<De>();
		List<De> listeU1L2Rel2 = new ArrayList<De>();

		List<De> listeU1L3 = new ArrayList<De>();
		List<De> listeU1L3C3 = new ArrayList<De>();
		List<De> listeU1L3Rel3 = new ArrayList<De>();

		List<De> listeDeTotalU1 = new ArrayList<De>();

		int cptTotalSort = 0;

		do
		{

			// ============================================================
			System.out.println("\t === Lancer1 ===\n");

			// on lance tous les dés du joueur
			List<De> listeUs = lancerDeUser(listeU2);
			Roll r2 = new Roll();
			r2.user = ia;
			for (De de : listeUs) {
				int val = de.getSymbole();
				switch (val) {

				case 5 : r2.upSort();
				case 0 : r2.upCasque();break;
				case 6 : r2.upSort();
				case 1 : r2.upBouclier();break;
				case 7 : r2.upSort();
				case 2 : r2.upFleche();break;
				case 8 : r2.upSort();
				case 3 : r2.upHache();break;
				case 9 : r2.upSort();
				case 4 : r2.upMain();break;

				}	
			}
			System.out.println("Le joueur 2 a choisit \n\n"+r2+"\n\n");

			listeU1L1 = lancerDeUser(listeU1);
			((User) u1).setDes(listeU1L1);// on attribut la liste de dé au premier joueur
			System.out.println("Liste des Dés joueur 1:");// on affiche toutes les faces de dés du premier lancé
			for (De de : listeU1L1) {
				System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
			}

			System.out.println("\t === Lancer1 - choix des dés ===");

			// on demande au joueur si il veut choisir des dés
			String choix = saisieString("Voulez-vous choisir des dés et relancer le reste ? (y/n)");
			if (choix.equalsIgnoreCase("y")) {// le joueur fait le choix de garder seulement certains dés

				listeU1L1C1 = choisirDeUser(listeU1L1);// on appelle la méthode choisirDeUser() pour choisir les dés à
				// garder
				System.out.println("Les dés choisis sont (" + listeU1L1C1.size() + "):");
				for (int i = 0; i < listeU1L1C1.size(); i++) {// on affiche tous les dés qui ont été choisis
					System.out.println(listeU1L1C1.get(i).getId() + " : " + facesDes.get(listeU1L1C1.get(i).getSymbole()));
				}
				listeDeTotalU1.addAll(listeU1L1C1);// on stocke les dés gardés

				listeU1L1Rel1 = choisirDeARelancer(listeU1L1, listeU1L1C1);// on appelle la méthode choisirDeARelancer()
				// pour stocker les dés à relancer
				System.out.println("Les dés à relancer sont (" + listeU1L1Rel1.size() + "):");
				System.out.println(listeU1L1Rel1.size());
				for (int i = 0; i < listeU1L1Rel1.size(); i++) {
					System.out.println(
							listeU1L1Rel1.get(i).getId() + " : " + facesDes.get(listeU1L1Rel1.get(i).getSymbole()));
				}

			} else {// le joueur fait le choix de tout garder
				System.out.println("Vous avez choisi de tout garder !");
				listeDeTotalU1 = listeU1L1;
			}

			if (listeDeTotalU1.size() < 5) {

				System.out.println("============================================\n");
				System.out.println("\t === Lancer2 ===\n");

				listeU1L2 = lancerDeUser(listeU1L1Rel1);
				System.out.println("Liste des Dés à relancer joueur 1:");
				for (De de : listeU1L2) {
					System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
				}

				System.out.println("\t === Lancer2 - choix des dés ===");

				// on demande au joueur si il veut choisir des dés
				String choix1 = saisieString("Voulez-vous choisir des dés et relancer le reste ? (y/n)");
				if (choix1.equalsIgnoreCase("y")) {

					listeU1L2C2 = choisirDeUser(listeU1L2);
					System.out.println("Les dés choisis sont (" + listeU1L2C2.size() + "):");
					for (int i = 0; i < listeU1L2C2.size(); i++) {
						System.out.println(
								listeU1L2C2.get(i).getId() + " : " + facesDes.get(listeU1L2C2.get(i).getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L2C2);

					listeU1L2Rel2 = choisirDeARelancer(listeU1L2, listeU1L2C2);
					System.out.println("Les dés à relancer sont (" + listeU1L2Rel2.size() + "):");
					for (int i = 0; i < listeU1L2Rel2.size(); i++) {
						System.out.println(
								listeU1L2Rel2.get(i).getId() + " : " + facesDes.get(listeU1L2Rel2.get(i).getSymbole()));
					}
				} else {// le joueur fait le choix de tout garder
					System.out.println("Vous avez choisi de tout garder !");
					listeDeTotalU1 = listeU1L1;
				}

				if (listeDeTotalU1.size() < 5) {

					System.out.println("============================================\n");
					System.out.println("\t === Lancer3 ===\n");

					listeU1L3 = lancerDeUser(listeU1L2Rel2);
					System.out.println("Liste des Dés à relancer joueur 1:");
					for (De de : listeU1L3) {
						System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L3);

				}

			}
			System.out.println("============================================\n");
			System.out.println("\t === Infos global joueur ===\n");
			System.out.println("Le joueur1 a " + ((User) u1).getPointDeVie() + " point de vie");
			System.out.println("Le joueur1 a choisi ces faces de dé :");
			for (int i = 0; i < listeDeTotalU1.size(); i++) {
				System.out
				.println(listeDeTotalU1.get(i).getId() + " : " + facesDes.get(listeDeTotalU1.get(i).getSymbole()));

			}


			Roll r1 = new Roll();
			r1.user = (User) u1;
			for (De de : listeDeTotalU1) {
				int val = de.getSymbole();
				switch (val) {

				case 5 : r1.upSort();
				case 0 : r1.upCasque();break;
				case 6 : r1.upSort();
				case 1 : r1.upBouclier();break;
				case 7 : r1.upSort();
				case 2 : r1.upFleche();break;
				case 8 : r1.upSort();
				case 3 : r1.upHache();break;
				case 9 : r1.upSort();
				case 4 : r1.upMain();break;

				}	
			}


			System.out.println();

			//			List<De> listeUs = lancerDeUser(listeU2);
			//			Roll r2 = new Roll();
			//			r2.user = u2;
			//			for (De de : listeUs) {
			//				int val = de.getSymbole();
			//				switch (val) {
			//
			//				case 5 : r2.upSort();
			//				case 0 : r2.upCasque();break;
			//				case 6 : r2.upSort();
			//				case 1 : r2.upBouclier();break;
			//				case 7 : r2.upSort();
			//				case 2 : r2.upFleche();break;
			//				case 8 : r2.upSort();
			//				case 3 : r2.upHache();break;
			//				case 9 : r2.upSort();
			//				case 4 : r2.upMain();break;
			//
			//				}	
			//			}
			//			System.out.println(r2);


			System.out.println("PV j1 "+((User) u1).getPointDeVie());
			System.out.println("PV j2 "+ia.getPointDeVie());

			r1.combat(r2);


			System.out.println("PV j1 "+((User) u1).getPointDeVie());
			System.out.println("PV j2 "+ia.getPointDeVie());
		}

		while (((User) u1).getPointDeVie()>0 && ia.getPointDeVie()>0);

		if (((User) u1).getPointDeVie()>ia.getPointDeVie() || ((User) u1).getPointDeVie()!=ia.getPointDeVie())
		{
			System.out.println("Fin du jeu, le joueur 1 a gagné la partie");
		}

		else 
		{
			if (ia.getPointDeVie()>((User) u1).getPointDeVie() || ((User) u1).getPointDeVie()!=ia.getPointDeVie())
			{
				System.out.println("Fin du jeu, le joueur 2 a gagné la partie");
			}
			else {
				if (ia.getPointDeVie()==((User) u1).getPointDeVie() )
				{
					System.out.println("Fin du jeu, égalité");
				}
			}
		}

	}

	static List<String> facesDes = Arrays.asList("casque", "bouclier", "fleche", "hache", "main", "casque+sort",
			"bouclier+sort", "fleche+sort", "hache+sort", "main+sort");

	// compare la liste des dés choisi et celle initiale pour créer une liste de dés
	// à relancer
	public static List<De> choisirDeARelancer(List<De> listeU, List<De> listeTempDeGarder) {
		List<De> listeTemp = new ArrayList<De>(listeU);
		listeTemp.removeAll(listeTempDeGarder);

		List<De> listeTempDeARelancer = new ArrayList<De>();
		listeTempDeARelancer.addAll(listeTemp);

		return listeTempDeARelancer;
	}

	// méthode qui permet de choisir les Dés que le joueur veut garder
	public static List<De> choisirDeUser(List<De> listeU) {

		List<De> listeTempDeGarder = new ArrayList<De>();
		System.out.println("Les dés que vous garder sont:");

		for (De de : listeU) {
			System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
			String deChoisi = saisieString("Choisissez-vous ce dé ? (y/n)");
			if (deChoisi.equalsIgnoreCase("y")) {
				listeTempDeGarder.add(de);
			}
		}
		return listeTempDeGarder;
	}

	// méthode permettant de lancer les dés d'un user
	public static List<De> lancerDeUser(List<De> listeU) {

		// liste des faces possible pour chaque dé
		List<Integer> de1 = Arrays.asList(0, 2, 3, 4, 5, 6);
		List<Integer> de2 = Arrays.asList(0, 1, 3, 4, 6, 7);
		List<Integer> de3 = Arrays.asList(1, 2, 0, 4, 7, 8);
		List<Integer> de4 = Arrays.asList(0, 1, 2, 3, 8, 9);
		List<Integer> de5 = Arrays.asList(5, 1, 2, 3, 4, 9);
		List<Integer> de6 = Arrays.asList(0, 2, 3, 4, 9, 6);

		// création d'une liste temporaire qui stockera les dés de l'utilisateur une
		// fois le symbole choisie
		List<De> listeDeTemp = new ArrayList<De>();

		// on récupère les dés de la liste de l'utilisateur et on fait un random à
		// partir de la méthode lancerDe() pour choirir le symbole
		for (De de : listeU) {
			if (de.getId() == 1 || de.getId() == 7) {// indiquer l'identifiant du dé pour pouvoir le sélectionner dans
				// la liste
				de.setSymbole(lancerDe(de1));// màj dela valeur symbole du dé
				listeDeTemp.add(de);// ajout du dé dans la liste temporaire (signature méthode)
			} else if (de.getId() == 2 || de.getId() == 8) {
				de.setSymbole(lancerDe(de2));
				listeDeTemp.add(de);
			} else if (de.getId() == 3 || de.getId() == 9) {
				de.setSymbole(lancerDe(de3));
				listeDeTemp.add(de);
			} else if (de.getId() == 4 || de.getId() == 10) {
				de.setSymbole(lancerDe(de4));
				listeDeTemp.add(de);
			} else if (de.getId() == 5 || de.getId() == 11) {
				de.setSymbole(lancerDe(de5));
				listeDeTemp.add(de);
			} else if (de.getId() == 6 || de.getId() == 12) {
				de.setSymbole(lancerDe(de6));
				listeDeTemp.add(de);
			}
		}
		return listeDeTemp;
	}

	// méthode qui permet de lancer un dé
	public static Integer lancerDe(List<Integer> tabD) {

		return tabD.get(genererInt());

	}

	// méthode qui permet de générer des entiers; ici de 0 à 5
	public static int genererInt() {
		Random random = new Random();
		int nb;
		nb = random.nextInt(5);
		return nb;
	}

	//	private static void pause() {
	//
	//
	//		try {
	//			System.in.read();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//
	//	}

	public static void main(String[] args) {
		menuPrincipal();


	}
}

