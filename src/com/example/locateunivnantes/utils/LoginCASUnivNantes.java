package com.example.locateunivnantes.utils;

public class LoginCASUnivNantes {

	/** Constructeur privé */
	private LoginCASUnivNantes() {
	}

	/** Instance unique pré-initialisée */
	private static LoginCASUnivNantes INSTANCE = new LoginCASUnivNantes();
	
	private String currentUserLoggedIn;
	
	/** Point d'accès pour l'instance unique du singleton */
	public static LoginCASUnivNantes getInstance() {
		return INSTANCE;
	}

	/**
	 * Permet l'authentification
	 * @param userName le nom d'utilisateur entré
	 * @param passWord le mdp entré
	 * @return si l'authentification est effectuée
	 */
	public boolean logIn(String userName, String passWord){
		if(userName.equals("test")&&passWord.equals("test")){
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
