
public class MenuJeuDeL {
	public static void menu() {

		char charJoueur = '1';
		char [][] plateau= new char [4][4];
		int difficulte;
		MethodeJeuDeL.remplirPlateauDepart(plateau);
		
		MethodeJeuDeL.tutoriel();
		
		difficulte=MethodeJeuDeL.selectionnerdifficulte();
		
		while(!MethodeJeuDeL.victoire(plateau, charJoueur)) {
			
			MethodeJeuDeL.afficherPlateau(plateau);
			System.out.println("C'est au tour du joueur : " + charJoueur + " \n");
			
			switch (difficulte) {
				case 1:
					MethodeJeuDeL.afficherOrientationPiece();
					MethodeJeuDeL.placementJoueur(plateau,charJoueur);
					MethodeJeuDeL.placementJeton(plateau);
					break;
	
				case 2:
				case 3:
				case 4:
					if (charJoueur=='1') {
						MethodeJeuDeL.afficherOrientationPiece();
						MethodeJeuDeL.placementJoueur(plateau,charJoueur);
						MethodeJeuDeL.placementJeton(plateau);
					}
					else {
						System.out.println("L'ordinateur joue ///////////////////////////////////// \n");
						MethodeJeuDeL.placementOrdinateur(plateau,charJoueur,difficulte);
						
					}
						
					break;			
			}
			
			
			
			
			
			
			
			
			
			
			if (charJoueur=='1') 
				charJoueur='2';
			else 
				charJoueur='1';	
		}
		
		MethodeJeuDeL.afficherPlateau(plateau);
		
		if(charJoueur=='1')
			System.out.println("VICTOIRE du joueur 2");
		else
			System.out.println("VICTOIRE du joueur 1");

	}
}
