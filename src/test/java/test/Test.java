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
import metier.Utilisateur;
import util.Context;

public class Test {

	static Compte connected = null;
	static Utilisateur ut = new Utilisateur();

	public static String saisieString(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}

	public static double saisieDouble(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}

	public static int saisieInt(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}

	private static void menuPrincipal() {

		System.out.println("Bienvenue dans orlog :");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Fermer l'appli");
		int choix = saisieInt("");

		switch (choix) {
		case 1:
			seConnecter();
			break;
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	private static Compte seConnecter() {

		String login=saisieString("Saisir votre pseudo");
		String password=saisieString("Saisir votre password");
		
		connected = Context.getInstance().getDaoCompte().checkConnect(login,password);

		if (connected instanceof Compte)
		{			
			System.out.println("Bienvenu " + connected.getLogin() + " (niv. " +  ") !");
			choixDifficulte();
		} else {
			System.out.println("Identifiants invalides \n");
			seConnecter();
		}
		return connected;

	}

	private static void choixDifficulte() {

		System.out.println("Choisir votre difficult�");
		System.out.println("1 - Facile");
		System.out.println("2 - Difficile (indisponible pour le moment)");
		int choix = saisieInt("");

		switch (choix) {
		case 1:
			JeuIAFacile();
			break;
		case 2:
			JeuIADifficile();
			break;
		default:
			System.out.println("Choix impossible !\n");
		}

		menuPrincipal();

	}

	private static void JeuIAFacile() {

		System.out.println("Pile ou Face (le gagnant commence)");
		System.out.println("1 - Pile");
		System.out.println("2 - Face");
		RandomPiece();
		int choix = saisieInt("");
		if (choix == RandomPiece()) {
			System.out.println("\n" + connected.getLogin() + " / " + connected.getPassword() + ", vous commencez\n");
			// System.out.println("Vous commencez");

			LancerdeUser2();
		}
		System.out.println("\nL'adversaire commence\n");

		LancerdeUser1();
	}

	private static int RandomPiece() {
		int rpiece = 0;
		rpiece = 1 + (int) (Math.random() * 2);
		return rpiece;
	}

	private static void JeuIADifficile() {
		System.out.println("Mode indisponible pour le moment veuillez revenir en arri�re (appuyez sur entrer)");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		choixDifficulte();
	}

	private static void rejouer() {

		System.out.println("\nVoulez-vous rejouer ?");
		System.out.println("1 - oui");
		System.out.println("2 - non");
		int choix = saisieInt("");

		switch (choix) {
		case 1:
			choixDifficulte();
			break;
		case 2:
			menuPrincipal();
			break;
		default:
			System.out.println("Choix impossible !\n");
		}

	}

	// ======================================================================================================
	// ======================================================================================================
	public static void LancerdeUser2() {
		// 1: Les joueurs
		int ptSortJ1Total = 0;
		int ptSortJ2Total = 0;
		Compte u1 = new User(false, 20, 0, null);
		u1.setId(connected.getId());
		// Compte u2 = new User(false, 20, 0, null);
		// u2.setId();
		User ia = new User(true, 20, 0, null);
		ia.setId(3);

		// cr�ation d'un liste des d� pour le joueur 1
		List<De> listeU1 = new ArrayList<De>();
		De d1 = new De(1, null, (User) u1);// => faire un random � partir de De1
		listeU1.add(d1);
		De d2 = new De(2, null, (User) u1);// => faire un random � partir de De2
		listeU1.add(d2);
		De d3 = new De(3, null, (User) u1);// => faire un random � partir de De3
		listeU1.add(d3);
		De d4 = new De(4, null, (User) u1);// => faire un random � partir de De4
		listeU1.add(d4);
		De d5 = new De(5, null, (User) u1);// => faire un random � partir de De5
		listeU1.add(d5);
		De d6 = new De(6, null, (User) u1);// => faire un random � partir de De6
		listeU1.add(d6);

		// user2 ou IA
		List<De> listeU2 = new ArrayList<De>();
		De d7 = new De(7, null, ia);// => faire un random � partir de De1
		listeU2.add(d7);
		De d8 = new De(8, null, ia);// => faire un random � partir de De2
		listeU2.add(d8);
		De d9 = new De(9, null, ia);// => faire un random � partir de De3
		listeU2.add(d9);
		De d10 = new De(10, null, ia);// => faire un random � partir de De4
		listeU2.add(d10);
		De d11 = new De(11, null, ia);// => faire un random � partir de De5
		listeU2.add(d11);
		De d12 = new De(12, null, ia);// => faire un random � partir de De6
		listeU2.add(d12);

		// ======================================================================================================
		// ======================================================================================================
		/**
		 * Test des m�thodes
		 */
		// =========================================== Initialisation des variables
		
		do {
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

			// ============================================================
			System.out.println("============================================\n");
			System.out.println("\t === Lancer1 ===\n");

			// on lance tous les d�s du joueur
			listeU1L1 = lancerDeUser(listeU1);
			((User) u1).setDes(listeU1L1);// on attribut la liste de d� au premier joueur
			System.out.println("Liste des D�s joueur 1:");// on affiche toutes les faces de d�s du premier lanc�
			for (De de : listeU1L1) {
				System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
			}

			System.out.println("\t === choix des d�s ===");

			// on demande au joueur si il veut choisir des d�s
			String choix = saisieString("Voulez-vous choisir des d�s et relancer le reste ? (y/n)");
			if (choix.equalsIgnoreCase("y")) {// le joueur fait le choix de garder seulement certains d�s

				listeU1L1C1 = choisirDeUser(listeU1L1);// on appelle la m�thode choisirDeUser() pour choisir les d�s �
				// garder
				System.out.println("Les d�s choisis sont (" + listeU1L1C1.size() + "):");
				for (int i = 0; i < listeU1L1C1.size(); i++) {// on affiche tous les d�s qui ont �t� choisis
					System.out.println(
							listeU1L1C1.get(i).getId() + " : " + facesDes.get(listeU1L1C1.get(i).getSymbole()));
				}
				listeDeTotalU1.addAll(listeU1L1C1);// on stocke les d�s gard�s

				listeU1L1Rel1 = choisirDeARelancer(listeU1L1, listeU1L1C1);// on appelle la m�thode choisirDeARelancer()
				// pour stocker les d�s � relancer
				System.out.println("Les d�s � relancer sont (" + listeU1L1Rel1.size() + "):");
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
				System.out.println("Liste des D�s � relancer joueur 1:");
				for (De de : listeU1L2) {
					System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
				}

				System.out.println("\t === Lancer2 - choix des d�s ===");

				// on demande au joueur si il veut choisir des d�s
				String choix1 = saisieString("Voulez-vous choisir des d�s et relancer le reste ? (y/n)");
				if (choix1.equalsIgnoreCase("y")) {

					listeU1L2C2 = choisirDeUser(listeU1L2);
					System.out.println("Les d�s choisis sont (" + listeU1L2C2.size() + "):");
					for (int i = 0; i < listeU1L2C2.size(); i++) {
						System.out.println(
								listeU1L2C2.get(i).getId() + " : " + facesDes.get(listeU1L2C2.get(i).getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L2C2);

					listeU1L2Rel2 = choisirDeARelancer(listeU1L2, listeU1L2C2);
					System.out.println("Les d�s � relancer sont (" + listeU1L2Rel2.size() + "):");
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
					System.out.println("Liste des D�s � relancer joueur 1:");
					for (De de : listeU1L3) {
						System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L3);

				}

			}
			System.out.println("============================================\n");
			System.out.println("\t === Infos global joueur ===\n");
			System.out.println("Le joueur1 a " + ((User) u1).getPointDeVie() + " point de vie");
			System.out.println("Le joueur1 a choisi ces faces de d� :");
			for (int i = 0; i < listeDeTotalU1.size(); i++) {
				System.out.println(
						listeDeTotalU1.get(i).getId() + " : " + facesDes.get(listeDeTotalU1.get(i).getSymbole()));

			}

			Roll r1 = new Roll();
			r1.user = (User) u1;
			for (De de : listeDeTotalU1) {
				int val = de.getSymbole();
				switch (val) {

				case 5:
					r1.upSort();
				case 0:
					r1.upCasque();
					break;
				case 6:
					r1.upSort();
				case 1:
					r1.upBouclier();
					break;
				case 7:
					r1.upSort();
				case 2:
					r1.upFleche();
					break;
				case 8:
					r1.upSort();
				case 3:
					r1.upHache();
					break;
				case 9:
					r1.upSort();
				case 4:
					r1.upMain();
					break;

				}
			}

			System.out.println();

			List<De> listeUs = lancerDeUser(listeU2);
			Roll r2 = new Roll();
			r2.user = ia;
			for (De de : listeUs) {
				int val = de.getSymbole();
				switch (val) {

				case 5:
					r2.upSort();
				case 0:
					r2.upCasque();
					break;
				case 6:
					r2.upSort();
				case 1:
					r2.upBouclier();
					break;
				case 7:
					r2.upSort();
				case 2:
					r2.upFleche();
					break;
				case 8:
					r2.upSort();
				case 3:
					r2.upHache();
					break;
				case 9:
					r2.upSort();
				case 4:
					r2.upMain();
					break;

				}
			}
			System.out.println("PV j1 " + ((User) u1).getPointDeVie());
			System.out.println("PV j2 " + ia.getPointDeVie());
			System.out.println("============================================");
			System.out.println("Point de sorts J1 " + ptSortJ1Total);
			System.out.println("Point de sorts J2 " + ptSortJ2Total);
			System.out.println("============================================");
			System.out.println(r1);
			System.out.println(r2);
			ptSortJ1Total += r1.getSort();
			ptSortJ2Total += r2.getSort();
			
			int diff = r1.getMain() - r2.getMain();
			if (diff > 0) {
				if (ptSortJ2Total > diff) {
					ptSortJ1Total = ptSortJ1Total + diff;
					ptSortJ2Total -= diff;

				} else if (ptSortJ2Total <= diff) {
					ptSortJ1Total = ptSortJ1Total + ptSortJ2Total;

				}
				if (ptSortJ2Total - diff <= 0) {
					ptSortJ2Total = 0;

				} else {
					ptSortJ2Total = ptSortJ2Total - diff;
				}

			} else if (diff < 0) {
				diff = Math.abs(diff);
				if (ptSortJ1Total > diff) {
					ptSortJ2Total = ptSortJ2Total + diff;
					ptSortJ1Total -= diff;

				} else if (ptSortJ1Total <= diff) {
					ptSortJ2Total = ptSortJ2Total + ptSortJ1Total;

					if (ptSortJ1Total - diff <= 0) {
						ptSortJ1Total = 0;

					} else {
						ptSortJ2Total = ptSortJ2Total - diff;

					}

				} else if (diff == 0) {
				}
				
			}
//			coucou
			System.out.println("============================================");
			System.out.println("Point de sorts J1 " + ptSortJ1Total);
			System.out.println("Point de sorts J2 " + ptSortJ2Total);
			System.out.println("============================================");
			r1.combat(r2);
			System.out.println("============================================");
			System.out.println("PV j1 " + ((User) u1).getPointDeVie());
			System.out.println("PV j2 " + ia.getPointDeVie());
			System.out.println("============================================");

		} while (((User) u1).getPointDeVie() > 0 && ia.getPointDeVie() > 0);

		// =======================================================================
		// ======== Qui a gagn� ?

		if (((User) u1).getPointDeVie() > 0 && ia.getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, le joueur 1 a gagn� la partie !");
			ajoutLevel(u1);

		} else if (ia.getPointDeVie() > 0 && ((User) u1).getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, le joueur 2 a gagn� la partie !");

		} else if (ia.getPointDeVie() <= 0 && ((User) u1).getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, �galit� !");
			rejouer();
		}
	}

	// ======================================================================================================
	public static void LancerdeUser1() {
		// 1: Les joueurs
		Compte u1 = new User(false, 20, 0, null);
		u1.setId(connected.getId());
		// Compte u2 = new User(false, 20, 0, null);
		// u2.setId();
		User ia = new User(true, 20, 0, null);
		ia.setId(3);

		// cr�ation d'un liste des d� pour le joueur 1
		List<De> listeU1 = new ArrayList<De>();
		De d1 = new De(1, null, (User) u1);// => faire un random � partir de De1
		listeU1.add(d1);
		De d2 = new De(2, null, (User) u1);// => faire un random � partir de De2
		listeU1.add(d2);
		De d3 = new De(3, null, (User) u1);// => faire un random � partir de De3
		listeU1.add(d3);
		De d4 = new De(4, null, (User) u1);// => faire un random � partir de De4
		listeU1.add(d4);
		De d5 = new De(5, null, (User) u1);// => faire un random � partir de De5
		listeU1.add(d5);
		De d6 = new De(6, null, (User) u1);// => faire un random � partir de De6
		listeU1.add(d6);

		// user2 ou IA
		List<De> listeU2 = new ArrayList<De>();
		De d7 = new De(7, null, null);// => faire un random � partir de De1
		listeU2.add(d7);
		De d8 = new De(8, null, null);// => faire un random � partir de De2
		listeU2.add(d8);
		De d9 = new De(9, null, null);// => faire un random � partir de De3
		listeU2.add(d9);
		De d10 = new De(10, null, null);// => faire un random � partir de De4
		listeU2.add(d10);
		De d11 = new De(11, null, null);// => faire un random � partir de De5
		listeU2.add(d11);
		De d12 = new De(12, null, null);// => faire un random � partir de De6
		listeU2.add(d12);

		// ======================================================================================================
		// ======================================================================================================
		/**
		 * Test des m�thodes
		 */
		// =========================================== Initialisation des variables
		
		do {
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

			// ============================================================
			System.out.println("\t === Lancer1 ===\n");

			// on lance tous les d�s du joueur
			List<De> listeUs = lancerDeUser(listeU2);
			Roll r2 = new Roll();
			r2.user = ia;
			for (De de : listeUs) {
				int val = de.getSymbole();
				switch (val) {

				case 5:
					r2.upSort();
				case 0:
					r2.upCasque();
					break;
				case 6:
					r2.upSort();
				case 1:
					r2.upBouclier();
					break;
				case 7:
					r2.upSort();
				case 2:
					r2.upFleche();
					break;
				case 8:
					r2.upSort();
				case 3:
					r2.upHache();
					break;
				case 9:
					r2.upSort();
				case 4:
					r2.upMain();
					break;

				}
			}
			System.out.println("Le joueur 2 a choisit \n\n" + r2 + "\n\n");

			listeU1L1 = lancerDeUser(listeU1);
			((User) u1).setDes(listeU1L1);// on attribut la liste de d� au premier joueur
			System.out.println("Liste des D�s joueur 1:");// on affiche toutes les faces de d�s du premier lanc�
			for (De de : listeU1L1) {
				System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
			}

			System.out.println("\t === choix des d�s ===");

			// on demande au joueur si il veut choisir des d�s
			String choix = saisieString("Voulez-vous choisir des d�s et relancer le reste ? (y/n)");
			if (choix.equalsIgnoreCase("y")) {// le joueur fait le choix de garder seulement certains d�s

				listeU1L1C1 = choisirDeUser(listeU1L1);// on appelle la m�thode choisirDeUser() pour choisir les d�s �
				// garder
				System.out.println("Les d�s choisis sont (" + listeU1L1C1.size() + "):");
				for (int i = 0; i < listeU1L1C1.size(); i++) {// on affiche tous les d�s qui ont �t� choisis
					System.out.println(
							listeU1L1C1.get(i).getId() + " : " + facesDes.get(listeU1L1C1.get(i).getSymbole()));
				}
				listeDeTotalU1.addAll(listeU1L1C1);// on stocke les d�s gard�s

				listeU1L1Rel1 = choisirDeARelancer(listeU1L1, listeU1L1C1);// on appelle la m�thode choisirDeARelancer()
				// pour stocker les d�s � relancer
				System.out.println("Les d�s � relancer sont (" + listeU1L1Rel1.size() + "):");
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

				System.out.println("\n============================================\n");
				System.out.println("\t === Lancer2 ===\n");

				listeU1L2 = lancerDeUser(listeU1L1Rel1);
				System.out.println("Liste des D�s � relancer joueur 1:");
				for (De de : listeU1L2) {
					System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
				}

				System.out.println("\t === Lancer2 - choix des d�s ===");

				// on demande au joueur si il veut choisir des d�s
				String choix1 = saisieString("Voulez-vous choisir des d�s et relancer le reste ? (y/n)");
				if (choix1.equalsIgnoreCase("y")) {

					listeU1L2C2 = choisirDeUser(listeU1L2);
					System.out.println("Les d�s choisis sont (" + listeU1L2C2.size() + "):");
					for (int i = 0; i < listeU1L2C2.size(); i++) {
						System.out.println(
								listeU1L2C2.get(i).getId() + " : " + facesDes.get(listeU1L2C2.get(i).getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L2C2);

					listeU1L2Rel2 = choisirDeARelancer(listeU1L2, listeU1L2C2);
					System.out.println("Les d�s � relancer sont (" + listeU1L2Rel2.size() + "):");
					for (int i = 0; i < listeU1L2Rel2.size(); i++) {
						System.out.println(
								listeU1L2Rel2.get(i).getId() + " : " + facesDes.get(listeU1L2Rel2.get(i).getSymbole()));
					}
				} else {// le joueur fait le choix de tout garder
					System.out.println("Vous avez choisi de tout garder !");
					listeDeTotalU1 = listeU1L1;
				}

				if (listeDeTotalU1.size() < 5) {

					System.out.println("\n============================================\n");
					System.out.println("\t === Lancer3 ===\n");

					listeU1L3 = lancerDeUser(listeU1L2Rel2);
					System.out.println("Liste des D�s � relancer joueur 1:");
					for (De de : listeU1L3) {
						System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
					}
					listeDeTotalU1.addAll(listeU1L3);

				}

			}
			System.out.println("\n============================================\n");
			System.out.println("\t === Infos global joueur ===\n");
			System.out.println("Le joueur1 a choisi ces faces de d� :");
			for (int i = 0; i < listeDeTotalU1.size(); i++) {
				System.out.println(
						listeDeTotalU1.get(i).getId() + " : " + facesDes.get(listeDeTotalU1.get(i).getSymbole()));

			}

			Roll r1 = new Roll();
			r1.user = (User) u1;
			for (De de : listeDeTotalU1) {
				int val = de.getSymbole();
				switch (val) {

				case 5:
					r1.upSort();
				case 0:
					r1.upCasque();
					break;
				case 6:
					r1.upSort();
				case 1:
					r1.upBouclier();
					break;
				case 7:
					r1.upSort();
				case 2:
					r1.upFleche();
					break;
				case 8:
					r1.upSort();
				case 3:
					r1.upHache();
					break;
				case 9:
					r1.upSort();
				case 4:
					r1.upMain();
					break;

				}
			}

			// List<De> listeUs = lancerDeUser(listeU2);
			// Roll r2 = new Roll();
			// r2.user = u2;
			// for (De de : listeUs) {
			// int val = de.getSymbole();
			// switch (val) {
			//
			// case 5 : r2.upSort();
			// case 0 : r2.upCasque();break;
			// case 6 : r2.upSort();
			// case 1 : r2.upBouclier();break;
			// case 7 : r2.upSort();
			// case 2 : r2.upFleche();break;
			// case 8 : r2.upSort();
			// case 3 : r2.upHache();break;
			// case 9 : r2.upSort();
			// case 4 : r2.upMain();break;
			//
			// }
			// }
			// System.out.println(r2);

			System.out.println("PV j1 " + ((User) u1).getPointDeVie());
			System.out.println("PV j2 " + ia.getPointDeVie());
			System.out.println("Point de sorts J1 " + r1.getSort());
			System.out.println("Point de sorts J2 " + r2.getSort());
			System.out.println(r1);
			System.out.println(r2);
			int psr1 = r1.getSort() - r2.getMain();
			int psr2 = r2.getSort() - r1.getMain();
			if (psr1 < 0 && psr2 < 0) {
				psr1 = 0;
				psr2 = 0;
			}
			int psr3 = psr1 + r1.getSort();
			int psr4 = psr2 + r2.getSort();
			System.out.println("Point de sorts restants J1 " + psr3);
			System.out.println("Point de sorts restants J2 " + psr4);
			r1.combat(r2);

			System.out.println("PV j1 " + ((User) u1).getPointDeVie());
			System.out.println("PV j2 " + ia.getPointDeVie());

		} while (((User) u1).getPointDeVie() > 0 && ia.getPointDeVie() > 0);

		// =======================================================================
		// ======== Qui a gagn� ?

		if (((User) u1).getPointDeVie() > 0 && ia.getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, le joueur 1 a gagn� la partie !");
			ajoutLevel(u1);
			
		} else if (ia.getPointDeVie() > 0 && ((User) u1).getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, le joueur 2 a gagn� la partie !");
			
		} else if (ia.getPointDeVie() <= 0 && ((User) u1).getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, �galit� !");
			rejouer();
		}

	}

	// ============================================================================================================
	// ============================================================================================================
	// ====== m�thode de coix et lanc� des d�s

	static List<String> facesDes = Arrays.asList("casque", "bouclier", "fleche", "hache", "main", "casque+sort",
			"bouclier+sort", "fleche+sort", "hache+sort", "main+sort");

	// compare la liste des d�s choisi et celle initiale pour cr�er une liste de d�s
	// � relancer
	public static List<De> choisirDeARelancer(List<De> listeU, List<De> listeTempDeGarder) {
		List<De> listeTemp = new ArrayList<De>(listeU);
		listeTemp.removeAll(listeTempDeGarder);

		List<De> listeTempDeARelancer = new ArrayList<De>();
		listeTempDeARelancer.addAll(listeTemp);

		return listeTempDeARelancer;
	}

	// m�thode qui permet de choisir les D�s que le joueur veut garder
	public static List<De> choisirDeUser(List<De> listeU) {

		List<De> listeTempDeGarder = new ArrayList<De>();
		System.out.println("Les d�s que vous garder sont:");

		for (De de : listeU) {
			System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
			String deChoisi = saisieString("Choisissez-vous ce d� ? (y/n)");
			if (deChoisi.equalsIgnoreCase("y")) {
				listeTempDeGarder.add(de);
			}
		}
		return listeTempDeGarder;
	}

	// m�thode permettant de lancer les d�s d'un user
	public static List<De> lancerDeUser(List<De> listeU) {

		// liste des faces possible pour chaque d�
		List<Integer> de1 = Arrays.asList(0, 2, 3, 4, 5, 6);
		List<Integer> de2 = Arrays.asList(0, 1, 3, 4, 6, 7);
		List<Integer> de3 = Arrays.asList(1, 2, 0, 4, 7, 8);
		List<Integer> de4 = Arrays.asList(0, 1, 2, 3, 8, 9);
		List<Integer> de5 = Arrays.asList(5, 1, 2, 3, 4, 9);
		List<Integer> de6 = Arrays.asList(0, 2, 3, 4, 9, 6);

		// cr�ation d'une liste temporaire qui stockera les d�s de l'utilisateur une
		// fois le symbole choisie
		List<De> listeDeTemp = new ArrayList<De>();

		// on r�cup�re les d�s de la liste de l'utilisateur et on fait un random �
		// partir de la m�thode lancerDe() pour choirir le symbole
		for (De de : listeU) {
			if (de.getId() == 1 || de.getId() == 7) {// indiquer l'identifiant du d� pour pouvoir le s�lectionner dans
				// la liste
				de.setSymbole(lancerDe(de1));// m�j dela valeur symbole du d�
				listeDeTemp.add(de);// ajout du d� dans la liste temporaire (signature m�thode)
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

	// m�thode qui permet de lancer un d�
	public static Integer lancerDe(List<Integer> tabD) {

		return tabD.get(genererInt());

	}

	// m�thode qui permet de g�n�rer des entiers; ici de 0 � 5
	public static int genererInt() {
		Random random = new Random();
		int nb;
		nb = random.nextInt(5);
		return nb;
	}

	// ============================================================================================================

	public static void ajoutLevel(Compte c) {

		ut.setLevel(Context.getInstance().getDaoUtilisateur().findById(c.getId()).getLevel() + 1);
		Context.getInstance().getDaoUtilisateur().save(ut);

	}

	// private static void pause() {
	//
	//
	// try {
	// System.in.read();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }

	// ============================================================================================================
	// ============================================================================================================
	public static void main(String[] args) {

		menuPrincipal();

	}

	// ============================================================================================================
	// ============================================================================================================

}
