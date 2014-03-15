package com.example.locateunivnantes.utils;

public class LoginCASUnivNantes {

	/** Constructeur priv� */
	private LoginCASUnivNantes() {
	}

	/** Instance unique pr�-initialis�e */
	private static LoginCASUnivNantes INSTANCE = new LoginCASUnivNantes();
	
	private String currentUserLoggedIn;
	
	/** Point d'acc�s pour l'instance unique du singleton */
	public static LoginCASUnivNantes getInstance() {
		return INSTANCE;
	}

	
	public boolean logIn(String userName, String passWord){
		if(userName.equals("alex")&&passWord.equals("coucou")){
			setCurrentUserLoggedIn(userName);
			return true;
		}
		else{
			return false;
		}
	}
	
	public void logOut(){
		setCurrentUserLoggedIn(null);
	}
	
	
	public String getCurrentUserLoggedIn() {
		return currentUserLoggedIn;
	}

	public void setCurrentUserLoggedIn(String currentUserLoggedIn) {
		this.currentUserLoggedIn = currentUserLoggedIn;
	}

}
