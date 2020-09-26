package main;
import java.util.ArrayList;

public class Ascenseur {
	
	// etage: l’étage courant de l’ascenseur
	private int etageCourant;
	
	// etageMax : le nombre d'etages maximum
	private int etageMax; 
		
	// direction: la direction courante de l’ascenseur ( UP ou DOWN ) 
	private String direction = "none"; // par defaut l'ascenseur n'a aucune direction
	
	// destinations: un vecteur des destinations entrées par les usagers
	private ArrayList<Integer> destinations = new ArrayList<Integer>(); //FIFO
	
	// appels: un vecteur des appels effectués par les usagers
	private ArrayList<Integer> appels = new ArrayList<Integer>(); //FIFO
	
	// indique si l'ascenseur est en arret ou en déplacement 
	private boolean arret;
	
	
		// Constructeur :
	public Ascenseur(int etageMax)
	{
		this.etageCourant = 1;
		this.etageMax = etageMax;
		this.arret = true;
		
		this.appels = new ArrayList<Integer>();
		this.destinations = new ArrayList<Integer>();
		
		
	}


		// Getters and Setters : 
	
	public int getEtageCourant() {
		return etageCourant;
	}


	public void setEtageCourant(int etage) {
		this.etageCourant = etage;
	}

	
	public int getEtageMax() {
		return etageMax;
	}

	
	public void setEtageMax(int etageMax) {
		this.etageMax = etageMax;
	}

	
	public boolean isEtageMax(){
		if(this.etageCourant == this.etageMax)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isEtageMin(){
		if(this.etageCourant == 1)
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


	public ArrayList<Integer> getAppels() {
		return appels;
	}


	public void setAppels(ArrayList<Integer> appels) {
		this.appels = appels;
	}


	public boolean isArret() {
		return arret;
	}
	
	
	public void setArret(boolean arret) {
		this.arret = arret;
	}
	
	
		// **** Méthodes ****
	
	// Méthode pour mettre en marche l'ascenseur
	public void demarrer() {
		if(!destinations.isEmpty() || !appels.isEmpty())
		{
			this.arret = false;
		}
	}
	
	// Methode qui indique que l'scenseur est arriver a destination
	public boolean arriverADestination( int destination)
	{
		if( this.etageCourant == destination)
		{
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
	
	// Methode qui ajoute un appel a la liste des appels
	public void appeller(int appel)
	{
		if( (appel >= 1) && (appel <= this.etageMax) )
		{
			this.appels.add(appel);
		}
		
		
	}
	
	// methode changer direction selon la position de l'appel
	public void prendreDirection(int appel)
	{
		if(this.etageCourant < appel)
			this.direction = "Up";
		else if(this.etageCourant > appel)
			this.direction = "Down";
	}
	
	// Méthode qui déplace l'ascenseur d'un etage
	public void deplacer()
	{
		if(!this.isArret())
		{
			if(this.direction.equals("Down") && !this.isEtageMin())
			{
				this.etageCourant -= 1;
			}
				
				
			if(this.direction.equals("Up") && !this.isEtageMax())
			{
				this.etageCourant += 1;
			}
				
		}
	}
	
	// Methode qui signale l'arret de l'ascneseur
	public void signalerArret()
	{
		this.arret = true;
	}
	
	// Méthode qui efface le dernier appel 
	public void effacerAppel()
	{
		if(this.appels.size() != 0)
		{
			this.appels.remove(0);
		}
		
	}
	
	// Méthode qui efface la derinère destination
	public void effacerDestination()
	{
		if(this.destinations.size() != 0)
		{
			this.destinations.remove(0);
		}
		
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
	
	// Methode pour recuperer les usager
	public boolean allerVersAppel()
	{
		if((this.appels.get(0) >= 1)&&(this.appels.get(0) <= this.etageMax))
		{
			//demarrer l'ascneseur
			this.demarrer();
			
			//mettre a jour la direction vers la direction de l'appel
			this.prendreDirection(this.appels.get(0));
			
			//deplacer d'un etage jusqu'à arriver à l'usager
			while(!arriverADestination(this.appels.get(0)))
			{
				this.deplacer();
			}
			
			//arreter l'ascenseur
			this.signalerArret();
			
			// Effacer l'appel de la liste d'attente
			this.effacerAppel();
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Methode se deplacer vers destination
	public boolean allerVersDestination()
	{
		if((this.destinations.get(0) >= 1)&&(this.destinations.get(0) <= this.etageMax))
		{
			//demarrer l'ascneseur
			this.demarrer();
			
			//mettre a jour la direction vers la direction de l'appel
			this.prendreDirection(this.destinations.get(0));
			
			//deplacer d'un etage jusqu'à arriver à l'usager
			while(!arriverADestination(this.destinations.get(0)))
			{
				this.deplacer();
			}
			
			//arreter l'ascenseur
			this.signalerArret();
			
			// Effacer l'appel de la liste d'attente
			this.effacerDestination();
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	

}
