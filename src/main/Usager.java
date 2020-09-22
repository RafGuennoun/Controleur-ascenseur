package main;

public class Usager {
	
	// etage: l’étage courant de l’usager
	private int etage;
	
	// direction: la direction que l’usager veut emprunter ( UP ou DOWN ) 
	private String direction;
	
	// destination: la destination de l’usager ( etage ) 
	private int destination;
	
	// entrer : l'utilisateur est entré dans l'ascenseur 
	private boolean entre = false;
		
		
	// Constructeur :
	public Usager(int etage, String direction, int destination)
	{
		this.etage = etage;
		this.direction = direction;
		this.destination = destination;
	}
	
	public Usager(int etage) {
		this.etage = etage;
	}
	
	public Usager()
	{
		
	}
	
	// Getters and Setters : 
	
	public int getEtage() {
		return etage;
	}
	
	public void setEtage(int etage) {
		this.etage = etage;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public void setDestination(int destination) {
		this.destination = destination;
	}

	public boolean isEntre() {
		return entre;
	}

	public void setEntre(boolean entre) {
		this.entre = entre;
	}
	
	

		// **** Methodes ****  
	
	
	// Methode pour signler la destination 
	public void signalerDestination(int destination)
	{
		this.destination = destination;
	}
	
	// Methode pour entrer dans l'ascenseur
	public void entrer(Porte porte) {
		if(porte.isPorteOuverte()) {
			this.setEntre(true);
		}
	}
	
	// Methode pour sortir de l'ascenseur
	public void sortir(Porte porte) {
		if(porte.isPorteOuverte()) {
			this.setEntre(false);
		}
	}
	
	
	

}
