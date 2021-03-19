package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import metier.Compte;
import metier.De;
import metier.User;
import metier.Utilisateur;
import util.Context;

public class Methode {

	// ================================================================

	static Compte connected = null;
	static Utilisateur ut = new Utilisateur();

	public static List<Object> seConnecter() {

		/*
		 * Lors de la connexion, on récupère les infos du compte/utilisateur. *
		 * 
		 */
		
		List<Object> listeObjetTemp = new ArrayList<Object>();
		listeObjetTemp.add(connected);
		
		return listeObjetTemp;

		// String login = saisieString("Saisir votre login");

		// String password = saisieString("Saisir votre password");

		// connected = Context.getInstance().getDaoCompte().checkConnect(login,
		// password);

//		if (connected instanceof Compte) {
//			System.out.println("Bienvenu " + connected.getLogin() + " (niv. " + ") !");
//
//			connected = Context.getInstance().getDaoCompte().checkConnect(login, password);
//
//			if (connected instanceof Compte) {
//				System.out.println("Bienvenu " + connected.getLogin() + " / " + connected.getPassword() + " !");
//
//				choixDifficulte();
//			} else {
//				System.out.println("Identifiants invalides \n");
//				seConnecter();
//
//			}
//
//		}
		
	}

	private static int choixDifficulte(Compte compte, List<Object> infos) {

		int choix; // choix de l'utilisateur par l'intermédiaire d'un bouton
		/*
		 * en fonction du bouton cliquer, retourner la bonne valeur de i
		 */

//		switch (choix) {
//		case 1:
//			JeuIAFacile();
//			break;
//		case 2:
//			JeuIADifficile();
//			break;
//		default:
//		}
		
		return i;

	}
	
	private static int LancerPiece() {
		int rpiece = 0;
		rpiece = 1 + (int) (Math.random() * 2);
		return rpiece;
	}
	
	// ================================================================

	static List<String> facesDes = Arrays.asList("casque", "bouclier", "fleche", "hache", "main", "casque+sort",
			"bouclier+sort", "fleche+sort", "hache+sort", "main+sort");

	public static List<De> lancerDeUser(List<De> listeU) {

		List<Integer> de1 = Arrays.asList(0, 2, 3, 4, 5, 6);
		List<Integer> de2 = Arrays.asList(0, 1, 3, 4, 6, 7);
		List<Integer> de3 = Arrays.asList(1, 2, 0, 4, 7, 8);
		List<Integer> de4 = Arrays.asList(0, 1, 2, 3, 8, 9);
		List<Integer> de5 = Arrays.asList(5, 1, 2, 3, 4, 9);
		List<Integer> de6 = Arrays.asList(0, 2, 3, 4, 9, 6);

		List<De> listeDeTemp = new ArrayList<De>();

		for (De de : listeU) {
			if (de.getId() == 1 || de.getId() == 7) {
				de.setSymbole(lancerDe(de1));
				listeDeTemp.add(de);
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

	public static Integer lancerDe(List<Integer> tabD) {

		return tabD.get(genererInt());

	}

	public static int genererInt() {
		Random random = new Random();
		int nb;
		nb = random.nextInt(5);
		return nb;
	}

	// ================================================================

	public static List<De> choisirDeARelancer(List<De> listeU, List<De> listeTempDeGarder) {
		List<De> listeTemp = new ArrayList<De>(listeU);
		listeTemp.removeAll(listeTempDeGarder);

		List<De> listeTempDeARelancer = new ArrayList<De>();
		listeTempDeARelancer.addAll(listeTemp);

		return listeTempDeARelancer;
	}

	public static List<De> choisirDeUser(List<De> listeU) {

		List<De> listeTempDeGarder = new ArrayList<De>();

		/*
		 * Cette méthode doit être lancé quand la méthode lancerDe() est réalisée.
		 * modifier la méthode pour qu'à chaque clique sur un dé, un
		 * listeTempDeGarder.add(imageDe) soit réalisé.		 * 
		 * 
		 */

//		System.out.println("Les dï¿½s que vous garder sont:");
//
//		for (De de : listeU) {
//			System.out.println(de.getSymbole() + " : " + facesDes.get(de.getSymbole()));
//			String deChoisi = saisieString("Choisissez-vous ce dï¿½ ? (y/n)");
//			if (deChoisi.equalsIgnoreCase("y")) {
//				listeTempDeGarder.add(de);
//			}
//		}
		return listeTempDeGarder;
	}

	// ================================================================

	public static void gagnant(User u1, User ia) {

		if (((User) u1).getPointDeVie() > 0 && ia.getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, le joueur 1 a gagné la partie !");
			ajoutLevel(u1);

		} else if (ia.getPointDeVie() > 0 && ((User) u1).getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, le joueur 2 a gagné la partie !");

		} else if (ia.getPointDeVie() <= 0 && ((User) u1).getPointDeVie() <= 0) {

			System.out.println("Fin du jeu, égalité !");
		}

	}
	
	public static void ajoutLevel(Compte c) {

		ut.setLevel(Context.getInstance().getDaoUtilisateur().findById(c.getId()).getLevel() + 1);
		Context.getInstance().getDaoUtilisateur().save(ut);

	}

}
