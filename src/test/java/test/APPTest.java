package test;

import java.util.Scanner;

import metier.Compte;
import metier.Utilisateur;
import util.Context;

public class APPTest {
	
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
	
	public static void connect() {
		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");

		Compte connected=Context.getInstance().getDaoCompte().checkConnect(login, password);
		
		Context.getInstance().setConnected(connected);
		
		if(connected==null) {System.out.println("Identifiants invalides");}
		else {
			if(connected instanceof Utilisateur) {
				System.out.println("Identifiant valide");
			}
			
			else {System.out.println("Error type de compte");}
		}
	}
	
	public static void main(String[] args) {
		connect();
	}

}
