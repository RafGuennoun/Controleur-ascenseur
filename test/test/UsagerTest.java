package test;

import static org.junit.Assert.*;

import org.junit.Test;
import main.Porte;
import main.Usager;

public class UsagerTest {

	//tester la methode entrer
	@Test
	public void testEntrer() {
		Porte porte = new Porte(1);
		
		//tester d'abord avec une porte ouverte
		porte.ouvrir();
		
		Usager usager = new Usager(1, "Up");
		usager.entrer(porte);
		
		//l'attribut entre doit etre à true
		assertTrue(usager.isEntre());
		
		//tester avec une porte fermé
		Usager usager2 = new Usager(1, "Up");
		porte.fermer();
		
		usager2.entrer(porte);
		
		//L'attribut entre doit rester à false
		assertFalse(usager2.isEntre());
	}
	
	//tester la methode sortir
	@Test
	public void testSortir() {
		Porte porte = new Porte(1);
		
		//tester d'abord avec une porte ouverte
		porte.ouvrir();
		
		Usager usager = new Usager(1, "Up");
		usager.setEntre(true); //pour tester si la methode modifie
		
		usager.sortir(porte);
		
		//l'attribut entre doit etre à false
		assertFalse(usager.isEntre());
		
		//tester avec une porte fermé
		Usager usager2 = new Usager(1, "Up");
		usager2.setEntre(true);//pour tester 
		porte.fermer();
		
		usager2.sortir(porte);
		
		//L'attribut entre doit rester à true
		assertTrue(usager2.isEntre());
	}
	

}
