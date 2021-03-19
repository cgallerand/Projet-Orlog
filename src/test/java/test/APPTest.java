package test;

import java.util.Scanner;

import metier.Compte;
import metier.User;
import metier.Utilisateur;
import util.Context;

public class APPTest {

	static Compte connected = null;
	static Utilisateur ut = new Utilisateur();
	
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
	
	public static Compte connect() {
		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");

		Compte connected=Context.getInstance().getDaoCompte().checkConnect(login, password);
		
		Context.getInstance().setConnected(connected);
		
		if(connected==null) {System.out.println("Identifiants invalides");}
		else {
			if(connected instanceof Compte) {
				System.out.println("Identifiant valide");
			}
			
			else {System.out.println("Error type de compte");}
		}
		return connected;
	}
	
	public static void main(String[] args) {
		
		//Context.getInstance().getEmf().createEntityManager();
		
		Compte c = connect();
//		
//		Compte u1 = new User(false, 20, 0, null);
//		Compte ut = new Utilisateur();
//		
//		u1.setId(c.getId());
//		System.out.println(u1);
//		
//		ut.setId(c.getId());
//		System.out.println(ut);
		
		ut = Context.getInstance().getDaoUtilisateur().findById(c.getId());
		System.out.println(ut);
		ut.setLevel(ut.getLevel()+1);
		
		Context.getInstance().getDaoUtilisateur().save(ut);
		System.out.println(Context.getInstance().getDaoUtilisateur().findById(c.getId()));
		
	}

}
