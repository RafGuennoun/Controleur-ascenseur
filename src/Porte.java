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
	
	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	
	public boolean isPorteOuverte() {
		return porteOuverte;
	}
	
	public void setPorteOuverte(boolean porteOuverte) {
		this.porteOuverte = porteOuverte;
	}

	
		// **** Methodes ****  
	
	// Methode qui ouvre la porte : 
	public void ouvrirEtFermerPorte()
	{
		// Ouvrir la porte
		this.setPorteOuverte(true);
		System.out.println("Porte ouverte : "+ this.isPorteOuverte());
		
		// Attendre un certain laps de temps [3 sec.]
		try 
		{
			TimeUnit.SECONDS.sleep(3);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			System.out.println("Erreur, la porte n'attends pas 3 secondes");			
		}
		
		// Fermer la porte
		this.setPorteOuverte(true);
		System.out.println("Porte fermée : " + this.isPorteOuverte());
		
	}
	
	/* Methodes en cas ou ...
	   
	// Methode qui ferme la porte : 
	public void fermerPorte()
	{
		System.out.println("Porte fermée");
		setPorteOuverte(false);
	}
		
	// Methode attendre un certain laps de temps [3 sec.]
	public void attendre ()
	{
		try 
		{
			TimeUnit.SECONDS.sleep(3);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			System.out.println("Erreur, la porte n'attends pas 3 secondes");			
		}
	}
	*/
	
	
	// Methode qui signale a l'ascenseur la possibilite de demarrer
	public void demarrerAscenseur (Ascenseur asc, boolean permission)
	{
		asc.setDemarrer(permission);
	}
	
	
	
	
}
