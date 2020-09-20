
public class Usager {
	
	// etage: l’étage courant de l’usager
	private int etage;
	
	// direction: la direction que l’usager veut emprunter ( UP ou DOWN ) 
	private String direction;
	
	// destination: la destination de l’usager ( etage ) 
	private int destination;
	
	// Constructeur :
	public Usager(int etage, String direction, int destination)
	{
		this.etage = etage;
		this.direction = direction;
		this.destination = destination;
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

	// **** Methodes ****  

}
