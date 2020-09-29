package main;

import static org.junit.Assert.*;

import org.junit.Test;

//Teste unitaire de la classe (composante) Ascenseur
public class AscenseurTest {

	// teste de l'ajout de destinations et d'appels
	@Test
	public void testAjoutDestAppel()
	{
		Ascenseur asc = new Ascenseur(5);
		asc.ajoutDestination(2);
		asc.appeller(3);
		
		// les liste d'appels et de destinations doivent ne doivent pas etre vides
		assertFalse(asc.getAppels().isEmpty());
		assertFalse(asc.getDestinations().isEmpty());
		
		// effacer la derniere destination et le dernier appel
		asc.effacerDestination();
		asc.effacerAppel();
		
		assertTrue(asc.getAppels().isEmpty());
		assertTrue(asc.getDestinations().isEmpty());
	}
	
	// teste de la méthode demarrer (mise en marche) et signalerArret
	@Test
	public void testDemarrer() {
		
		Ascenseur asc = new Ascenseur(5);
		
		//l'ascenseur ne démarre pas si il n'y a pas au moins un appel ou une destination
		asc.ajoutDestination(2); //essaie avec destination
		
		asc.demarrer();
		
		// isArret doit retourner false
		assertFalse(asc.isArret());
		
		asc = new Ascenseur(5);
		asc.appeller(3); //essaie avec appel
		
		asc.demarrer();
		
		// isArret doit retourner false
		assertFalse(asc.isArret());
		
		asc.signalerArret();
		
		// isArret doit retourner true
		assertTrue(asc.isArret());
	}
	
	// teste de la méthode prendreDirection
	@Test
	public void testPrendreDirection()
	{
		// l'ascenseur sera par defaut a l'étage 1
		Ascenseur asc = new Ascenseur(5);
		
		asc.prendreDirection(4);
		
		// l'ascenseur devrait prendre la direction "Up"
		assertEquals("Up", asc.getDirection());
		
		asc.setEtageCourant(3); //changer d'etage pour faire autres testes
		asc.prendreDirection(1);
		
		// l'ascenseur devrait prendre la direction "Down"
		assertEquals("Down", asc.getDirection());
		
		asc.prendreDirection(3);
		asc.prendreDirection(3);
		
		// l'ascenseur devrait prendre la direction "none"
		assertEquals("none", asc.getDirection());
	}
	
	// testede la méthode deplacer (déplacement de l'ascenseur d'un étage)
	@Test
	public void testDeplacer()
	{
		Ascenseur asc = new Ascenseur(5);
		asc.appeller(3); // pour pouvoir demarrer l'ascenseur
		asc.demarrer();
		asc.prendreDirection(3); //direction == "Up"
		
		asc.deplacer();

		// l'etage courant devrait etre 2 (déplacement d'un etage vers le haut)
		assertEquals(2,asc.getEtageCourant());
		
		asc.prendreDirection(2); //direction == "none"
		asc.deplacer();
		
		// l'etage courant devrait etre 2 (aucun déplacement)
		assertEquals(2,asc.getEtageCourant());
		
		asc.prendreDirection(1); //direction == "Down"
		asc.deplacer();
		
		// l'etage courant devrait etre 1 (déplacement d'un etage vers le bas)
		assertEquals(1,asc.getEtageCourant());
	}
	
	// tester la méthode arriverADestination
	@Test
	public void testArriverADestination()
	{
		Ascenseur asc = new Ascenseur(5);
		asc.appeller(3); // pour pouvoir demarrer l'ascenseur
		asc.demarrer();
		asc.prendreDirection(3); //direction == "Up"
		
		// déplacement de deux etage vers le haut
		asc.deplacer();
		asc.deplacer();
		
		// l'ascenseur devrait etre arrivé à destination
		// la méthode arriverADestination devrait retourner true
		assertTrue(asc.arriverADestination(3));
	}
	
	// tester la méthode allerVersAppel
	@Test
	public void testAllerVersAppel()
	{
		Ascenseur asc = new Ascenseur(5);
		asc.appeller(3);
		
		// recupérer l'usager qui a appelé l'ascenseur
		boolean result = asc.allerVersAppel();

		// le resultat de la méthoed doit etre a true
		assertTrue(result);
		
		// l'ascenseur doit etre à l'etage 3
		assertEquals(3,asc.getEtageCourant());
		
		// l'ascenseur doit etre en arret
		assertTrue(asc.isArret());
		
		// l'appel doit etre effacé (liste vide car il y avait un seul appel)
		assertTrue(asc.getAppels().isEmpty());
	}
	
	//tester la methode allerVersDestination
	@Test
	public void testAllerVersDestination()
	{
		Ascenseur asc = new Ascenseur(5);
		asc.ajoutDestination(3);
		
		// aller vers la destination
		boolean result = asc.allerVersDestination();
		
		// le resultat de la méthoed doit etre a true
		assertTrue(result);
		
		// l'ascenseur doit etre à l'etage 3
		assertEquals(3,asc.getEtageCourant());
		
		// l'ascenseur doit etre en arret
		assertTrue(asc.isArret());
		
		// la destination doit etre effacé (liste vide car il y avait un seul appel)
		assertTrue(asc.getDestinations().isEmpty());
	}
	

}
