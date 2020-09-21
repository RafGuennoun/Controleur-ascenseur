
public class Usager {
	
	// etage: l’étage courant de l’usager
	private int etage;
	
	// direction: la direction que l’usager veut emprunter ( UP ou DOWN ) 
	private String direction;
	
	// destination: la destination de l’usager ( etage ) 
	private int destination;
	
	// entrer : l'utilisateur est entrer dans l'ascenseur 
	private boolean enter;
		
		
	// Constructeur :
	public Usager(int etage, String direction, int destination)
	{
		this.etage = etage;
		this.direction = direction;
		this.destination = destination;
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

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}
	
	

		// **** Methodes ****  
	
	// Methode pour appler l'ascenseur
	public void appelAscenseur(int etage, String direction )
	{
		this.etage = etage;
		this.direction = direction;
	}
	
	// Methode pour signler la destination 
	public void signalerDestination(int destination)
	{
		this.destination = destination;
	}
	
	
	

}
