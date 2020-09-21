import java.util.concurrent.TimeUnit;

public class Porte {
	
	// etage: l’étage de la porte [de 1 à nombre d’étages]
	private int etage; 
	
	// Indique si la porte est ouverte ou pas 
	private boolean porteOuverte ;
	

		// Constructeur :
	public Porte(int etage) 
	{
		this.etage = etage;
	}
	
	public Porte() 
	{
		
	}
	
		// Getters and Setters :
	
	public int getetage() {
		return etage;
	}

	public void setetage(int etage) {
		this.etage = etage;
	}

	
	public boolean isporteOuverte() {
		return porteOuverte;
	}
	
	public void setporteOuverte(boolean porteOuverte) {
		this.porteOuverte = porteOuverte;
	}

	
		// **** Methodes ****  
	
	// Methode qui fait attendre a la porte un laps de 3 secondes
	public void attendre() {
		
		// Attendre un certain laps de temps [3 sec.]
		try 
		{
			TimeUnit.SECONDS.sleep(3);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	// Methode qui ouvre la porte : 
	public void ouvrir() {
		
		if(!this.isporteOuverte())
		{
			// Ouvrir la porte
			this.setporteOuverte(true);
		}
	}
	
	public void fermer() {
		if(this.isporteOuverte()) {
			//fermer la porte
			this.setporteOuverte(false);
		}
	}
	
	
	// Methode qui signale a l'ascenseur la possibilite de demarrer
	public void signalerDepart (Ascenseur asc)
	{
		asc.setDemarrer(true);
	}
	
	
	
	
}
