import java.util.ArrayList;

public class Ascenseur {
	
	// etage: l’étage courant de l’ascenseur
	private int etage;
	
	// direction: la direction courante de l’ascenseur ( UP ou DOWN ) 
	private String direction;
	
	// destinations: un vecteur des destinations entrées par les usagers
	private ArrayList<String> destinations = new ArrayList<String>();
	
	// appels: un vecteur des appels effectués par les usagers
	private ArrayList<Usager> appels = new ArrayList<Usager>();
	
	// demarrer : indique si l'ascenseur peut demarrer ou pas apres la fermeture des portes 
	private boolean demarrer;
	
	// arret : si les listes des appels et destinations sont vides veut dire que l'ascenseur est en arret 
	private boolean arret;
	
	
		// Constructeur :
	public Ascenseur()
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


	public ArrayList<String> getDestinations() {
		return destinations;
	}


	public void setDestinations(ArrayList<String> destinations) {
		this.destinations = destinations;
	}


	public ArrayList<Usager> getAppels() {
		return appels;
	}


	public void setAppels(ArrayList<Usager> appels) {
		this.appels = appels;
	}



	
	
	public boolean peutDemarrer() {
		return demarrer;
	}
	
	



	public void setDemarrer(boolean demarrer) {
		this.demarrer = demarrer;
	}



	
	
	public boolean isArret() {
		return arret;
	}
	
	



	public void setArret() {
		if(destinations.isEmpty() && appels.isEmpty())
		{
			this.arret = true;
		}
		else
		{
			this.arret = false;
		}
	}
	
	
	
	
		// **** Methodes **** 

}
