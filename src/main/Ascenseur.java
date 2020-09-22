package main;
import java.util.ArrayList;

public class Ascenseur {
	
	// etage: l’étage courant de l’ascenseur
	private int etage;
	
	// etageMax : le nombre d'etages maximum
	private int etageMax; 
		
	// direction: la direction courante de l’ascenseur ( UP ou DOWN ) 
	private String direction = "none"; // par defaut l'ascenseur n'a aucune direction
	
	// destinations: un vecteur des destinations entrées par les usagers
	private ArrayList<Integer> destinations = new ArrayList<Integer>();
	
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

	
	public int getEtageMax() {
		return etageMax;
	}

	
	public void setEtageMax(int etageMax) {
		this.etageMax = etageMax;
	}

	
	public boolean isEtageMax(){
		if(this.etage == this.etageMax)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isEtageMin(){
		if(this.etage == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public ArrayList<Integer> getDestinations() {
		return destinations;
	}


	public void setDestinations(ArrayList<Integer> destinations) {
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
	
	// Methode qui indique que l'scenseur est arriver a destination
	public boolean arriverADestination( int destination)
	{
		if( this.etage == destination)
		{
			// supprimer les destination du vecteur 
			return true;
		}
		else
		{
			return false;
		}
	}

	// Methode ajout nouvelle destination 
	public void ajoutDestination(int destination)
	{
		this.destinations.add(destination); 
	}
	
	// Methode pour renverser la direction si l’ascenseur atteint l’étage le plus haut (resp. le plus bas)
	public void renverserDirection()
	{
		if(this.isEtageMax())
		{
			this.setDirection("Down");
		}
		else 
		{
			if(this.isEtageMin())
			{
				this.setDirection("Up");
			}
		}
	}
	
	// Methode qui ajoute un appel a la liste des appels
	public void nouvelAppel(Usager us)
	{
		this.appels.add(us);
		
	}

	// Methode pour recuperer les usager
	public void allerVersAppel()
	{
		
	}

	

}
