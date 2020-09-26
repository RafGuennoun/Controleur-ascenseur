package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Ascenseur;

class AscenseurTest {

	
	// Test de la methode demarrer()
	@Test
	void testDemarrer() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		assertTrue(ascenseur.isArret());
		
		// Ajouter un appel 
		ascenseur.appeller(5);
		ascenseur.demarrer();
		assertFalse(ascenseur.isArret());
		
	}

	// Test de la methode arriverADestination
	@Test
	void testArriverADestination() {
			
		Ascenseur ascenseur = new Ascenseur(10);
			
		ascenseur.setEtageCourant(1);
		int destination = 5;
			
		assertFalse(ascenseur.arriverADestination(destination));
		
		ascenseur.setEtageCourant(destination);
			
		assertTrue(ascenseur.arriverADestination(destination));
			
	}
	
	// Test de la methode ajouterDestination
	@Test
	void testAjouterDestination() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		// la lise des destinations est vide
		assertTrue(ascenseur.getDestinations().isEmpty());
		
		// Ajouter une destination 
		ascenseur.ajoutDestination(5);
		assertFalse(ascenseur.getDestinations().isEmpty());
		assertEquals(1, ascenseur.getDestinations().size());
		
	}
	
	// Test de la methode appeler
	@Test
	void testAppeler() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		// La liste des appels est vide
		assertTrue(ascenseur.getAppels().isEmpty());
		
		// appel d'un etage existant
		ascenseur.appeller(5);
		assertFalse(ascenseur.getAppels().isEmpty());
		assertEquals(1, ascenseur.getAppels().size());
		ascenseur.getAppels().remove(0);
		assertTrue(ascenseur.getAppels().isEmpty());
		
		// appel d'un etage existant
		ascenseur.appeller(12);
		assertTrue(ascenseur.getAppels().isEmpty());
		
		
		
	}
	
	// Test de la methode prendreDirection
	@Test
	void testPrendreDirection() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		// Par defaut les direction est "none" , on verifie ca 
		assertEquals("none",ascenseur.getDirection());
		
		//  ** Cas etageCourant < etage d'appel ** 
		// L'ascenseur est au premier etage
		ascenseur.setEtageCourant(1);
		
		// L'ascenseur resoit un appel du 5eme etage
		ascenseur.prendreDirection(5);
		assertEquals("Up",ascenseur.getDirection());
		
		//  ** Cas etageCourant > etage d'appel ** 
		// L'ascenseur est au 5eme etage
		ascenseur.setEtageCourant(5);
				
		// L'ascenseur resoit un appel du 2eme etage
		ascenseur.prendreDirection(2);
		assertEquals("Down",ascenseur.getDirection());
		
		
	}

	// Test de la methode deplacer
	@Test
	void testDeplacer() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		// Par defaut les direction est "none"
		assertEquals("none",ascenseur.getDirection());
		
		// ** Ces : direction est "Up" ** 
		// L'ascenseur est au 2eme etage
		ascenseur.setEtageCourant(2);
		assertEquals(2, ascenseur.getEtageCourant());
		
		// L'ascenseur est en arret
		assertTrue(ascenseur.isArret());
		
		// L'ascenseur resoit un appel du 5eme etage
		ascenseur.appeller(5);
		
		// L'ascenseur prend la direction de l'appel
		ascenseur.prendreDirection(5);
		
		// Demarrage de l'ascenseur
		ascenseur.demarrer();
		assertFalse(ascenseur.isArret());
		
		// La direction change vers "Up" grace a la methode prendreDirection
		ascenseur.deplacer();
		assertEquals(3, ascenseur.getEtageCourant());
		
		// Cas arriver a l'etage max 10
		ascenseur.setEtageCourant(10);
		
		ascenseur.setDirection("Up");
		assertEquals("Up",ascenseur.getDirection());
		
		ascenseur.demarrer();
		assertFalse(ascenseur.isArret());
		
		ascenseur.deplacer();
		// L'ascenseur ne monte pas vers l'etage 11 car l'etage max est le 10
		assertEquals(10, ascenseur.getEtageCourant());
		
		
		
		
		// ** Ces : direction est "Down" ** 
		// L'ascenseur est au 9eme etage
		ascenseur.setEtageCourant(9);
		assertEquals(9, ascenseur.getEtageCourant());
						
		// L'ascenseur resoit un appel du 5eme etage
		ascenseur.appeller(5);
				
		// L'ascenseur prend la direction de l'appel
		ascenseur.prendreDirection(5);
				
		// Demarrage de l'ascenseur
		ascenseur.demarrer();
		assertFalse(ascenseur.isArret());
				
		// La direction change vers "Down" grace a la methode prendreDirection
		ascenseur.deplacer();	
		assertEquals(8, ascenseur.getEtageCourant());
		
		// Cas arriver a l'etage minimum 1
		ascenseur.setEtageCourant(1);
			
		ascenseur.setDirection("Down");
		assertEquals("Down",ascenseur.getDirection());
		
		ascenseur.demarrer();
		assertFalse(ascenseur.isArret());
				
		ascenseur.deplacer();
		// L'ascenseur ne descend pas car elle est dans l'etage minimum
		assertEquals(1, ascenseur.getEtageCourant());
		
	
	}
	
	// Test de la methode signalerArret
	@Test
	void testSignalerArret() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		// L'ascenseur n'est pas en arret
		ascenseur.setArret(false);
		assertFalse(ascenseur.isArret());
		
		// utiliser la methode signalerArret
		ascenseur.signalerArret();
		assertTrue(ascenseur.isArret());
		
	}

	// Test de la methode effacerAppel
	@Test
	void testEffacerAppel() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		assertEquals(0, ascenseur.getAppels().size());
		
		// Ajouter un premier appel de 3 
		ascenseur.appeller(3);
		assertEquals(1, ascenseur.getAppels().size());
		
		// Ajouter un deuxieme appel de 5
		ascenseur.appeller(5);
		assertEquals(2, ascenseur.getAppels().size());
		
		// Effacer un appel
		ascenseur.effacerAppel();
		assertEquals(1, ascenseur.getAppels().size());
		
		// Effacer un appel
		ascenseur.effacerAppel();
		assertEquals(0, ascenseur.getAppels().size());
		
		// Effacer un appel alors qu'il n y a pas d'appels
		ascenseur.effacerAppel();
		assertEquals(0, ascenseur.getAppels().size());

	}
	
	// Test de la methode effacerDestination
	@Test
	void testEffacerDestination() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		assertEquals(0, ascenseur.getDestinations().size());
		
		// Ajouter une destination vers 3 
		ascenseur.ajoutDestination(3);
		assertEquals(1, ascenseur.getDestinations().size());
		
		// Effacer une destination
		ascenseur.effacerDestination();
		assertEquals(0, ascenseur.getAppels().size());
		
		// Effacer une destination alors que la liste des destinations est vide
		ascenseur.effacerDestination();
		assertEquals(0, ascenseur.getAppels().size());

	}

	// Test de la methode renverserDestiination
	@Test
	void testRenverserDestination() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		
		// ** Cas etage min **
		// L'ascenseur est dans l'etage min
		assertEquals(1, ascenseur.getEtageCourant());
		
		// Modifier les direction de l'ascenseur vers "Down"
		ascenseur.setDirection("Down");
		assertEquals("Down", ascenseur.getDirection());
		
		// Utiliser la methode renverserDirection
		ascenseur.renverserDirection();
		assertEquals("Up", ascenseur.getDirection());
		
		
		
		
		
		// ** Cas etage max **
		// L'ascenseur est dans l'etage max
		ascenseur.setEtageCourant(10);
		assertEquals(10, ascenseur.getEtageCourant());
				
		// Modifier les direction de l'ascenseur vers "Up"
		ascenseur.setDirection("Up");
		assertEquals("Up", ascenseur.getDirection());
				
		// Utiliser la methode renverserDirection
		ascenseur.renverserDirection();
		assertEquals("Down", ascenseur.getDirection());
		
		
		
		
		
		// ** Cas non etage min et non etage max **
		// L'ascenseur est dans l'etage 5
		ascenseur.setEtageCourant(5);
		assertEquals(5, ascenseur.getEtageCourant());
				
		// Modifier les direction de l'ascenseur vers "Down"
		ascenseur.setDirection("Down");
		assertEquals("Down", ascenseur.getDirection());
				
		// Utiliser la methode renverserDirection
		ascenseur.renverserDirection();
		assertEquals("Down", ascenseur.getDirection());	
		
		// Modifier les direction de l'ascenseur vers "Up"
		ascenseur.setDirection("Up");
		assertEquals("Up", ascenseur.getDirection());
						
		// Utiliser la methode renverserDirection
		ascenseur.renverserDirection();
		assertEquals("Up", ascenseur.getDirection());
		
		
		
		
		
	}

	// Test methode allerVersAppel
	@Test
	void testAllerVersAppel() {
		
		Ascenseur ascenseur = new Ascenseur(10);
		
		
		// L'ascenseur est au premier etage 
		assertEquals(1 , ascenseur.getEtageCourant());
		assertEquals(0, ascenseur.getAppels().size());
		
		// L'ascenseur recoit un premier appel de l'etage 5
		ascenseur.appeller(5);
		assertEquals(1, ascenseur.getAppels().size());
		
		// L'ascenseur recoit un deuxieme appel de l'etage 8
		ascenseur.appeller(8);
		assertEquals(2, ascenseur.getAppels().size());
		
		// L'ascenseur recoit un troisieme appel de l'etage 2
		ascenseur.appeller(2);
		assertEquals(3, ascenseur.getAppels().size());
				
		// utiliser la methode allerVersAppel
		ascenseur.allerVersAppel();
		
		// L'ascenseur va vers le premier appel d'abord ( 5eme etage ) 
		assertEquals(5 , ascenseur.getEtageCourant());
		
		// L'ascenseur supprime les premier appel de la liste de appels
		assertEquals(2, ascenseur.getAppels().size());
		
		// utiliser la methode allerVersAppel
		ascenseur.allerVersAppel();
			
		// L'ascenseur va ensuite vers le deuxieme appel ( 8eme etage ) 
		assertEquals(8 , ascenseur.getEtageCourant());
				
		// L'ascenseur supprime les premier appel de la liste de appels
		assertEquals(1, ascenseur.getAppels().size());
		
		// utiliser la methode allerVersAppel
		ascenseur.allerVersAppel();
					
		// L'ascenseur va ensuite vers le troisieme appel ( 2eme etage ) 
		assertEquals(2 , ascenseur.getEtageCourant());
						
		// L'ascenseur supprime les premier appel de la liste de appels
		assertEquals(0, ascenseur.getAppels().size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	// Test methode allerVersDestination
	@Test
	void testAllerVersDestination() {
		
		Ascenseur ascenseur = new Ascenseur(10);

		// L'ascenseur est au premier etage 
		assertEquals(1 , ascenseur.getEtageCourant());
		assertEquals(0, ascenseur.getDestinations().size());
		
		// Ajouter une premiere destination vers le 3eme etage
		ascenseur.ajoutDestination(3);
		assertEquals(1, ascenseur.getDestinations().size());
		
		// utiliser la methode allerVers Destination
		ascenseur.allerVersDestination();
		
		// Verifier si arriver a l'etage de destination 
		assertEquals(3, ascenseur.getEtageCourant());
		
		// Verifier si la destintion a ete supprimée
		assertEquals(0, ascenseur.getDestinations().size());
		
	}
	
	/*
	@Test
	void test() {
		
	}
	 */
	
	
	
	
	
}
