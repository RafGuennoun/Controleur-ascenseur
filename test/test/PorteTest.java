package test;

import static org.junit.Assert.*;

import org.junit.Test;
import main.Porte;

public class PorteTest {

	public PorteTest() {
		
	}
	
	// teste de la methode ouvrir
	@Test
	public void testOuvrir() {
		Porte porte = new Porte(1);
		
		porte.ouvrir();
		//l'attribut porteOuverte doit etre a true
		//la methode isPorteOuverte doit retourner true
		
		assertTrue(porte.isPorteOuverte());
	}
	
	// teste de la methode fermer
		@Test
		public void testFermer() {
			Porte porte = new Porte(1);
			
			porte.fermer();
			//l'attribut porteOuverte doit etre a false
			//la methode isPorteOuverte doit retourner false
			
			assertFalse(porte.isPorteOuverte());
		}

}
