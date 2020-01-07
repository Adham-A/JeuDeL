
public class MenuJeuDeL {
	
	public static void menu() {

		char charJoueur = '1';
		char [][] plateau= new char [4][4];
		int difficulte;
		String pseudo1 ="",pseudo2="";
		
		MethodeJeuDeL.remplirPlateauDepart(plateau);
		MethodeJeuDeL.tutoriel();
		
		
		difficulte=MethodeJeuDeL.selectionnerdifficulte();
		
		System.out.println("Joueur 1 : ");
		pseudo1 = MethodeJeuDeL.saisiePseudo();
		
		if (difficulte==1) {
			System.out.println("Joueur 2 : ");
			pseudo2 = MethodeJeuDeL.saisiePseudo();
		}
			
		while(!MethodeJeuDeL.victoire(plateau, charJoueur)) {
			
			MethodeJeuDeL.afficherPlateau(plateau);
			
			if(charJoueur=='1') {
				System.out.println("C'est au tour de  " + pseudo1 + " \n");
			}
			
			switch (difficulte) {
				case 1:
					if(charJoueur=='2') {
						System.out.println("C'est au tour de  " + pseudo2 + " \n");
					}
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
						System.out.println(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n" + 
								"	            L'ordinateur joue\r\n" + 
								" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ ");
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
			System.out.println("Victoire du joueur 2");
		else
			System.out.println("Victoire du joueur 1");

	}
	
}
