import java.util.Scanner;

public class MethodeJeuDeL {
	static Scanner sc = new Scanner(System.in);

	public static void remplirPlateauDepart(char[][] t) {
		
		//Jetons neutres
		t[0][0] = '*' ; //Jeton1
 		t[3][3] = '*' ; //Jeton2
		
		//Piece Joueur 1
 		t[1][1] = '1' ;
 		t[1][2] = '1' ;
 		t[1][3] = '1' ;
 		t[2][3] = '1' ;
 		
 		//Piece Joueur 2
 		t[1][0] = '2' ;
 		t[2][0] = '2' ;
 		t[2][1] = '2' ;
 		t[2][2] = '2' ;
		 
		//Remplir les cases vides du plateau
		for (int x = 0; x < t.length; x++) {
			for (int y = 0; y < t[0].length; y++) {
				if (t[x][y] == '\u0000')
					t[x][y] = '-';
			}
		}
	}
	
	public static char[][] copiePlateau(char[][] plateau){
		char[][] copie = new char[4][4];
		for (int y=0; y<plateau[0].length;y++) 
			for (int x=0 ; x<plateau.length ; x++)
				copie[x][y] = plateau[x][y];
		return copie;
	}
	
	public static void afficherPlateau(char[][] plateau) {
		for (int y=0; y<plateau[0].length;y++) {
			System.out.print((y+1)+"| ");
			for (int x=0 ; x<plateau.length ; x++)
				System.out.print(plateau[x][y] + " ");
			System.out.println();
		}
		System.out.println("   ̅1̅ ̅2̅ ̅3̅ ̅4");
		System.out.println();
	}
	
	public static void afficherOrientationPiece() {
		System.out.println("Comment shouaitez vous placer votre pièce ?\r\n" + 
				"*   **   **   *\r\n" + 
				"*    *   *    *  *   ***  ***   *\r\n" + 
				"**   *   *   **  ***   *  *   *** \r\n" + 
				"1    2   3    4  5     6  7     8\r\n" + 
				"");
	}
	
	public static void enleverPieceJoueurDuPlateau(char[][] plateau, char charJoueur){
		for (int y=0; y<plateau[0].length;y++) 
			for (int x=0 ; x<plateau.length ; x++)
				if(plateau[x][y] == charJoueur)
					plateau[x][y] = '-';
	}
	
	public static boolean verification(int x, int y, int orientationPiece,char[][] plateauSansL, char charJoueur) {
		//Cette méthode vérifie	qu'une pièce peut être placé à un certain endroit avec une orientation donnée et retourne vrai si c'est le cas
		switch(orientationPiece) { //Vérification trois cases de hauteur ou trois cases de longeur
			
			case 1:
			case 4:
			
				if(y<2)  
					return false;
			
				if(!verification3casesHauteur(x,y,orientationPiece,plateauSansL,charJoueur))
					return false;
				break;
			
			case 2:
			case 3:
				
				if(y>1) 
					return false; 
				
				if(!verification3casesHauteur(x,y,orientationPiece,plateauSansL,charJoueur))
					return false;
				break;
			
			case 5:
			case 7:
				
				if (x>1) 
					return false;
			
				if(!verification3casesLongueur(x,y,orientationPiece,plateauSansL,charJoueur))
					return false;
				break;
			
			case 6:
			case 8:
				
				if (x<2)
					return false;
				
				if(!verification3casesLongueur(x,y,orientationPiece,plateauSansL,charJoueur))
					return false;
				break;
			}
		
		return verificationCoin(x, y, orientationPiece, plateauSansL, charJoueur); //Vérification du coin
	}

	public static boolean verification3casesHauteur(int x, int y,int orientation, char[][] plateauSansL, char charJoueur) {

		int hauteur = plateauSansL[0].length;
		
		switch(orientation) {
			case 1 :
			case 4 :
					for ( int i=y; i>y-hauteur+1 ;i-- ) 
						if(plateauSansL[x][i]!='-') 
							return false ;
					break;
			case 2 :
			case 3 :
					for ( int i=y; i<y+hauteur-1;i++) 
						if(plateauSansL[x][i]!='-') 
							return false ;
					break;
		
		}
		
		return true;
	}
		
	public static boolean verification3casesLongueur(int x, int y,int orientation, char[][] plateauSansL, char charJoueur) {
		int longeur = plateauSansL.length;
	
		switch(orientation) {
		
			case 5 :
			case 7 :
				for (int i=x; i<x+longeur-1 ; i++) 
					if(plateauSansL[i][y]!='-')
						return false;
				break;
			case 6:
			case 8:
				for (int i=x; i>x-longeur+1 ; i--) 
					if(plateauSansL[i][y]!='-')
						return false;
				break;
		}
		return true;
	}
	
	public static boolean verificationCoin(int x, int y, int orientationPiece,char[][] plateauSansL, char charJoueur) {
		switch (orientationPiece) { //Vérification case adjacente au coin
		
		case 1:
		case 3:
			if (x==3 || plateauSansL[x+1][y]!='-') //Impossible que x=3 pour orientation 1 et 3
				return false;
			else 
				return true;
			
		case 2:		
		case 4:
			if (x==0 || plateauSansL[x-1][y]!='-') 
				return false;
			else 
				return true;
			
		case 5:
		case 8:
			if (y==0 || plateauSansL[x][y-1]!='-')
				return false;
			else
				return true;
		
		case 6:
		case 7:
			if (y==3 || plateauSansL[x][y+1]!='-')
				return false;
			else
				return true;
		}
		return false;
	}
	
	public static boolean comparaison2Tableau(char[][] tableau1, char[][] tableau2) {
		for (int y=0; y<tableau1[0].length;y++) 
			for (int x=0 ; x<tableau1.length ; x++)
				if( tableau1[x][y] != tableau2[x][y])
					return false;
		return true;
	}

	public static boolean placementPiece(int x, int y, int orientationPiece,char[][] plateau, char charJoueur) {
		//Cette méthode place une piece à des coordonnées avec son orientation si c'est possible et renvoie true sinon renvoie false
		
		x-=1; //Change x vers son indice dans le tableau		
		y-=1; //Change y vers son indice dans le tableau
		
		char[][] plateauSansL = copiePlateau(plateau);
		enleverPieceJoueurDuPlateau(plateauSansL, charJoueur);
		
		if (!verification(x, y, orientationPiece, plateauSansL, charJoueur)) 
			return false;
		else 
			switch(orientationPiece) { //Place les cases en hauteur et en longeur
			
			case 1:
			case 4:	
				for ( int i=y; i>y-3 ;i-- )
					plateauSansL[x][i]=charJoueur;		
				break;
			
			case 2:
			case 3:
				for ( int i=y; i<y+3 ;i++ ) 
					plateauSansL[x][i]=charJoueur;	
				break;
			
			case 5:
			case 7:
				
				for (int i=x; i<x+3 ; i++) 
					plateauSansL[i][y]=charJoueur;
				break;
			
			case 6:
			case 8:

				for (int i=x; i>x-3 ; i--) 
					plateauSansL[i][y]=charJoueur;
				break;
				
			}
		
			switch (orientationPiece) { //Place les cases adjacentes aux coins
			
			case 1:
			case 3:
				plateauSansL[x+1][y]=charJoueur;
				break;
				
			case 2:		
			case 4:
				plateauSansL[x-1][y]=charJoueur; 
				break;
				
			case 5:
			case 8:
				plateauSansL[x][y-1]=charJoueur; 
				break;
				
			case 6:
			case 7:
				 plateauSansL[x][y+1]=charJoueur;
				 break;
			}
			
			if (comparaison2Tableau(plateau,plateauSansL))
				return false;

			for (int i=0; i<plateau[0].length;i++) 
				for (int j=0 ; j<plateau.length ; j++)
					plateau[i][j] = plateauSansL[i][j];
			return true;	
	}
	
	public static void placementJoueur(char[][] plateau, char charJoueur) {
		//Cette méthode demande au joueur d'entrez les coordonnées ainsi que l'orientation de la pièce qu'il shouaite placer
		System.out.println("Entrez l'orientation souhaité : ");
		int orientation = Integer.parseInt(sc.nextLine());
		System.out.println("Entrez x du coin : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("Entrez y du coin : ");
		int y = Integer.parseInt(sc.nextLine());
		
		while( x<1 || x>4 || y<1 || y>4 || !placementPiece(x, y, orientation, plateau, charJoueur)) {
			System.out.println("Ce que vous essayez de faire n'est pas possible");
			System.out.println("Entrez l'orientation souhaité");
			orientation = Integer.parseInt(sc.nextLine());
			System.out.println("Entrez x du coin : ");
			x = Integer.parseInt(sc.nextLine());
			System.out.println("Entrez y du coin : ");
			y = Integer.parseInt(sc.nextLine());
		}
		System.out.println();
	}

	public static boolean victoire(char[][] plateau, char charJoueur){
		//Cette méthode retourne vrai s'il ne reste qu'une possibilité de jeu au joueur c'est à dire là ou est sa pièce
		int longeur = plateau.length;
		int hauteur = plateau[0].length;
		int nbrpossibilite=0;
		
		char[][] plateauSansL = copiePlateau(plateau);
		enleverPieceJoueurDuPlateau(plateauSansL, charJoueur);
		
		for(int x = 0; x<longeur ; x++) 
			for (int y = 0 ; y<hauteur ;y++) 
					for(int orientation=1;orientation<9 ;orientation++) {
						if(verification(x, y, orientation, plateauSansL, charJoueur))
						nbrpossibilite++;
						if (nbrpossibilite>=2)
							return false;
					}
		return true;
	}
	
	public static boolean verificationCoordonneesJeton(int x, int y,char[][] plateau) {
		if(plateau[x][y]!='*')
			return false;
		return true;
	}
	
	public static void placementJeton(char[][] plateau) {
	
		int x,y; //Coordonnees ou le jeton est 
		int x_jeton,y_jeton; //Coordonnees ou l'on veut placer le jeton
		String choix;
		
		afficherPlateau(plateau);
		System.out.println("Voulez vous jouez le jeton : entrez oui/non ");
		choix = sc.nextLine();
		
		while( !choix.equals("oui") && !choix.equals("non") )  {
			System.out.println("Voulez vous jouez le jeton : entrez oui/non ");
			choix = sc.nextLine();
		}
		
		switch (choix) {
			case "oui" :
				do{
					System.out.println("Entrez position x actuelle du jeton : ");
					x = Integer.parseInt(sc.nextLine());
					System.out.println("Entrez position y actuelle du jeton : ");
					y = Integer.parseInt(sc.nextLine());
					x--;
					y--;
					
					if(x<0 ||x>3 || y>3 || y<0 || !verificationCoordonneesJeton(x, y, plateau))
						System.out.println("Erreur recommencez \n");
					
				}while(x<0 ||x>3 || y>3 || y<0 || !verificationCoordonneesJeton(x, y, plateau));
			
				do {
					System.out.println("Entrez la nouvelle position du jeton :\n\nEntrez x : ");
					x_jeton = Integer.parseInt(sc.nextLine());
					x_jeton--;
					
					System.out.println("Entrez y : ");
					y_jeton = Integer.parseInt(sc.nextLine());
					y_jeton--;
				
					if (x_jeton<0 ||x_jeton>3 || y_jeton>3 || y_jeton<0 || plateau[x_jeton][y_jeton]!='-' )
						System.out.println("Erreur recommencez \n");
					
				} while(x_jeton<0 ||x_jeton>3 || y_jeton>3 || y_jeton<0 || plateau[x_jeton][y_jeton]!='-' );
				
				plateau[x_jeton][y_jeton] ='*';
				plateau[x][y]='-';	
		}
		
		System.out.println();
	}

	public static void tutoriel() {
		System.out.println("Bienvenue dans le jeu de L, \r\n" + 
				"C'est un jeu inventé par Edward de Bono en 1968 qui fait appel à la pensée stratégique.\r\n" + 
				"Tour à tour chaque joueur peut déplacer son tétromino en forme de L sur le terrain.\r\n" + 
				"Après avoir déplacé sa pièce un joueur peut décider ou non de bouger un des jetons neutres symbolisés par :  '*' \r\n" + 
				"Le but du jeu est d'empêcher l'adversaire d'avoir des déplacements restants.\r\n" + 
				"Exemple : \r\n" + 
				"\r\n" + 
				"1| - - * - \r\n" + 
				"2| 2 2 2 - \r\n" + 
				"3| 1 - 2 - \r\n" + 
				"4| 1 1 1 * \r\n" + 
				"   ̅1̅ ̅2̅ ̅3̅ ̅4\r\n" + 
				"\r\n" + 
				"Ici c'est le tour du joueur 1 et il ne possède plus aucun valide il a donc perdu.\r\n" + 
				"\r\n" + 
				"Le coin d'un tétromino est utilisé pour placer sa pièce :\r\n" + 
				"\r\n" + 
				"Exemple : \r\n" + 
				"\r\n" + 
				"     *\r\n" + 
				"     *    ---> ***\r\n" + 
				"---> **        * \n");
	}
	
	public static int selectionnerdifficulte() {
		
		int choix;
		System.out.println("1.Jouer contre un humain\r\n" + 
				"2.Jouer contre l'ordinateur (facile)\r\n" + 
				"3.Jouer contre l'ordinateur (moyen)\r\n" + 
				"4.Jouer contre l'ordinateur (difficile)");
		choix = Integer.parseInt(sc.nextLine());
		
		while( choix<1 || choix>4) {
			System.out.println("Erreur de sélection : \n ");
			System.out.println("1.Jouer contre un humain\r\n" + 
					"2.Jouer contre une IA (facile)\r\n" + 
					"3.Jouer contre une IA (moyen)\r\n" + 
					"4.Jouer contre une IA (difficile)");
			choix = Integer.parseInt(sc.nextLine());
		}
		
		System.out.println();
		return choix;
	}
	
	public static void placementOrdinateur(char[][] plateau,char charJoueur,int difficulte) {
		//Cette méthode appelle les méthodes de placement de l'ordinateur en fonction de la difficulté
		switch(difficulte) {
		case 2 :
			placementOrdinateurFacile(plateau,charJoueur); // Joue aléatoirement
			break;
		case 3 :
			placementOrdinateurMoyen(plateau, charJoueur); // Joue aléatoirement sauf s'il y a un coup meurtrier
			break;
		case 4 :
			placementOrdinateurDifficile(plateau, charJoueur); //Joue un coup gagnant ou essaie de jouer le meilleur coup
			break;
		}
	}
	
	public static void placementJetonOrdinateurAleatoire(char[][] plateau) {
		//Place un jeton aléatoirement
		int[] coordonnees = placerCoordonneesJetonsDansTableau(plateau);
		int x,y,nouveauX,nouveauY;
		
		if ((int)(Math.random()*2)==1) {
			x = coordonnees[0];
			y = coordonnees[1];
		}
		else {
			x = coordonnees[2];
			y = coordonnees[3];
		}
		
		do {
			nouveauX = (int)(Math.random()*4);
			nouveauY = (int)(Math.random()*4);
		}while(plateau[nouveauX][nouveauY]!='-');
			
		plateau[nouveauX][nouveauY] = '*' ;
		plateau[x][y] = '-' ;

		}		
	
	public static int[] placerCoordonneesJetonsDansTableau(char[][] plateau) {
		int indextableau = 0;
		int[] tableauCoordonnees;
		tableauCoordonnees = new int[4];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				if (plateau[i][j]=='*') {
					tableauCoordonnees[indextableau] = i;
					tableauCoordonnees[indextableau+1] = j;
					indextableau+=2;
				}
				if (indextableau==4) {
					return tableauCoordonnees;
				}
			}
		}
		return tableauCoordonnees;
	
	}
	
	public static void placementOrdinateurFacile(char[][] plateau,char charJoueur) {
		int x;
		int y;
		int orientation;	
		do {
			x = (int)(Math.random()*4)+1;
			y = (int)(Math.random()*4)+1;
			orientation = (int)(Math.random()*8)+1;	
		}while(!placementPiece(x, y, orientation, plateau, charJoueur));
		
		if ( (int)(Math.random()*2)==1) {
			placementJetonOrdinateurAleatoire(plateau);
		}
	}
	
	public static void placementOrdinateurMoyen(char[][] plateau,char charJoueur) {
	
		int[] tableauCoordonneesPieceJeton = chercherCoupGagnant(plateau, charJoueur);
		if (tableauCoordonneesPieceJeton[8]==1) {
			int xPiece = tableauCoordonneesPieceJeton[0]+1;
			int yPiece = tableauCoordonneesPieceJeton[1]+1;
			int orientationPiece = tableauCoordonneesPieceJeton[2];
			placementPiece(xPiece, yPiece, orientationPiece, plateau, charJoueur);
			
			if (tableauCoordonneesPieceJeton[7]==1) {
				int xJetonInitial =  tableauCoordonneesPieceJeton[3];
				int yJetonInitial = tableauCoordonneesPieceJeton[4];
				int nouveauXJeton =  tableauCoordonneesPieceJeton[5];
				int nouveauYJeton =  tableauCoordonneesPieceJeton[6];
				placementJetonOrdinateur(plateau, xJetonInitial, yJetonInitial, nouveauXJeton, nouveauYJeton);
			}
		}
		else {
		placementOrdinateurFacile(plateau, charJoueur);
		}
		
	}
	
	public static int[] chercherCoupGagnant(char[][] plateau,char charJoueur) {
		/*Cette méthode renvoie un tableau.
		 * Il permet de savoir s'il y a un coup gagnant de pièce avec ou sans Jeton
		 * Et s'il y en a renvoie les coordonnées de la pièce et/ou du jeton
		 */
		
		int[] tableauresultat = {0,0,0,0,0,0,0,0,0}; 
		
		/* {x,y,orientation,xJeton,yJeton,nouveauXJeton,nouveauYJeton,booleenJeton,booleenCoupGagnant}
		*
		* BooleenJeton permet de savoir s'il faut déplaçer un jeton
		* xJeton et yJeton donne les coordonnées du jeton à déplaçer
		* 
		*/
		
		char [][] plateauDeTest = copiePlateau(plateau) ;
		int [] resultatJeton;
		
		for(int x = 0; x<4 ; x++)  {
			for (int y = 0; y<4 ;y++) {
					for(int orientation=1;orientation<9 ;orientation++) {
						if(placementPiece(x+1, y+1, orientation, plateauDeTest, charJoueur)) {
							if(charJoueur=='2') {
								charJoueur='1';
							}
							else{
								charJoueur='2';
							}
							
							if(victoire(plateauDeTest, charJoueur)) {
								tableauresultat[0] = x;
								tableauresultat[1] = y;
								tableauresultat[2] = orientation;
								tableauresultat[8] = 1 ;
								return tableauresultat;
							}
							
							resultatJeton = chercherJetonGagnant(plateauDeTest, charJoueur);
							if (resultatJeton[4]==1) { //BooleenPlacementJeton
								tableauresultat[0] = x;
								tableauresultat[1] = y;
								tableauresultat[2] = orientation;
								tableauresultat[3] = resultatJeton[0];
								tableauresultat[4] = resultatJeton[1];
								tableauresultat[5] = resultatJeton[2];
								tableauresultat[6] = resultatJeton[3];
								tableauresultat[7] = resultatJeton[4];
								tableauresultat[8] = 1 ;
								return tableauresultat;
							}
							
							if(charJoueur=='1') {
								charJoueur='2';
							}
							else{
								charJoueur='1';
							}
						}
					}
			}
		}
		
		return tableauresultat;
	}
	
	public static int[] chercherJetonGagnant(char[][] plateau,char charJoueur) {
		
		int[] resultatJeton = {0,0,0,0,0};
		/* {xInitialJeton,yInitialJeton,nouveauXJeton,nouveauYJeton,booleenJeton}
		*
		* booleenJeton permet de savoir s'il faut déplacer un jeton
		*/
		
		//Permet de sauvegarder la position initial des Jetons pour les replacer lorsqu'on vérifie toutes les positions possibles des autres Jetons.
		int[] CoordonneesJetons = placerCoordonneesJetonsDansTableau(plateau);
		int xInitialPremierJeton = CoordonneesJetons[0];
		int yInitialPremierJeton = CoordonneesJetons[1];
		int xInitialDeuxiemeJeton = CoordonneesJetons[2];
		int yInitialDeuxiemeJeton = CoordonneesJetons[3];
		
		//Change le premier Jeton en un caractère '-'  afin de permettre de tester les possibilités avec le premier jeton
		plateau[xInitialPremierJeton][yInitialPremierJeton] = '-';
		
		for(int xJeton = 0; xJeton<4 ; xJeton++)  {
			for (int yJeton = 0 ; yJeton<4 ;yJeton++) {
				if(plateau[xJeton][yJeton]=='-') {
					plateau[xJeton][yJeton]='*' ;
					if(victoire(plateau, charJoueur)) {
						resultatJeton[0] = xInitialPremierJeton;
						resultatJeton[1] = yInitialPremierJeton;
						resultatJeton[2] = xJeton;
						resultatJeton[3] = yJeton;
						resultatJeton[4] = 1;
						plateau[xJeton][yJeton]='-';
						plateau[xInitialPremierJeton][yInitialPremierJeton]='*';
						plateau[xInitialDeuxiemeJeton][yInitialDeuxiemeJeton]='*';
						return resultatJeton;
					}
					plateau[xJeton][yJeton]='-';
				}
			}
		}
		
		// Change le deuxieme Jeton en un caractère '-'  afin de permettre de tester les possibilités avec le deuxieme jeton
		plateau[xInitialDeuxiemeJeton][yInitialDeuxiemeJeton]='-';
		//Replace le Jeton 1
		plateau[xInitialPremierJeton][yInitialPremierJeton] = '*';
	
		for(int xJeton = 0; xJeton<4 ; xJeton++)  {
			for (int yJeton = 0 ; yJeton<4 ;yJeton++) {
				if(plateau[xJeton][yJeton]=='-') {
					plateau[xJeton][yJeton]='*' ;
					if(victoire(plateau, charJoueur)) {
						resultatJeton[0] = xInitialDeuxiemeJeton;
						resultatJeton[1] = yInitialDeuxiemeJeton;
						resultatJeton[2] = xJeton;
						resultatJeton[3] = yJeton;
						resultatJeton[4] = 1;
						plateau[xJeton][yJeton]='-';
						plateau[xInitialPremierJeton][yInitialPremierJeton]='*';
						plateau[xInitialDeuxiemeJeton][yInitialDeuxiemeJeton]='*';
						return resultatJeton;
					}
					plateau[xJeton][yJeton]='-';
				}
			}
		}
		
		//Replace le jeton 2
		plateau[xInitialDeuxiemeJeton][yInitialDeuxiemeJeton]='*';
		
		return resultatJeton;
	}
	
	public static void placementJetonOrdinateur(char[][] plateau,int xJeton,int yJeton, int nouveauXJeton, int nouveauYJeton) {
		plateau[xJeton][yJeton] = '-';
		plateau[nouveauXJeton][nouveauYJeton] = '*';
	}
	
	public static void placementOrdinateurDifficile(char[][] plateau,char charJoueur) {
		int[] tableauCoordonneesPieceJeton ;
		int[] meilleurCoup;
		
		tableauCoordonneesPieceJeton = chercherCoupGagnant(plateau, charJoueur);
		if (tableauCoordonneesPieceJeton[8]==1) {
			placementOrdinateurMoyen(plateau, charJoueur); //Appelle la méthode de placement ordinateur moyen s'il y a un coup gagnant
		}
		else {
			meilleurCoup = evaluationPlacementPieceEtJeton(plateau, charJoueur);
			int xPiece = meilleurCoup[0];
			int yPiece = meilleurCoup[1];
			int orientationPiece = meilleurCoup[2];
			placementPiece(xPiece+1, yPiece+1, orientationPiece, plateau, charJoueur);
			int xJeton=meilleurCoup[3];
			int yJeton=meilleurCoup[4];
			int nouveauXJeton=meilleurCoup[5];
			int nouveauYJeton=meilleurCoup[6];
			placementJetonOrdinateur(plateau, xJeton, yJeton, nouveauXJeton, nouveauYJeton);
		}
	}
	
	public static int[] evaluationPlacementPieceEtJeton (char[][] plateau, char charJoueur) {
		int meilleurEvaluation = -999 ;
		int[] evaluationJeton ;
		int[] evaluation = {0,0,0,0,0,0,0,0};
		// xPiece,yPiece,orientation,xJetonInitial,yJetonInitial,nouveauX,nouveauY,meilleurEvaluationCombiné
		
		for(int x = 0; x<4 ; x++)  {
			for (int y = 0; y<4 ;y++) {
				for(int orientation=1;orientation<9 ;orientation++) {
					char[][] plateauDeTest = copiePlateau(plateau);
					if(placementPiece(x+1, y+1, orientation, plateauDeTest, charJoueur)) {
						if(evaluationPiece(plateauDeTest, charJoueur)>meilleurEvaluation) {
							meilleurEvaluation = evaluationPiece(plateauDeTest, charJoueur);
							evaluation[0] = x;
							evaluation[1] = y;
							evaluation[2] = orientation;
							evaluationJeton = evaluationMeilleurJeton(plateauDeTest) ;
							evaluation[3] = evaluationJeton[0];
							evaluation[4] = evaluationJeton[1];
							evaluation[5] = evaluationJeton[2];
							evaluation[6] = evaluationJeton[3];
							evaluation[7] = evaluationJeton[4]+meilleurEvaluation;
						}		
					}
				}
			}
		}
		return evaluation;
	}
	
	public static int evaluationPiece (char[][] plateau, char charJoueur) {
		int evaluation=0;
		for (int ligneDuBas = 0; ligneDuBas < plateau.length; ligneDuBas++) {
			if(plateau[ligneDuBas][3]==charJoueur)
				evaluation--;
		}
		
		for (int ligneDuHaut = 0; ligneDuHaut < plateau.length; ligneDuHaut++) {
			if(plateau[ligneDuHaut][0]==charJoueur)
				evaluation--;		
		}
		
		for (int colonneGauche = 0; colonneGauche < plateau[0].length; colonneGauche++) {
			if(plateau[0][colonneGauche]==charJoueur)
				evaluation--;
		}
		
		for (int colonneDroite = 0; colonneDroite < plateau[3].length; colonneDroite++) {
			if(plateau[3][colonneDroite]==charJoueur)
				evaluation--;
		}

		return evaluation;
	}
	
	public static int[] evaluationJeton (char[][] plateau) {
		int evaluation=0;
		int[] evaluationJeton = {0,0};
		// evaluationJeton1,evaluationJeton2
		int[] coordonnees = placerCoordonneesJetonsDansTableau(plateau);
		
		if(coordonnees[0]==0 || coordonnees[0]==3 ) //Verifie que le jeton n'est pas sur un bord du plateau
		evaluation--;
		if(coordonnees[1]==0 || coordonnees[1]==3 )
		evaluation--;
		
		evaluationJeton[0] = evaluation;
		evaluation=0;
		
		if(coordonnees[2]==0 || coordonnees[2]==3 ) //Verifie que le jeton 2 n'est pas sur un bord du plateau
		evaluation--;
		if(coordonnees[3]==0 || coordonnees[3]==3 )
		evaluation--;
		
		evaluationJeton[1] = evaluation;
		evaluation=0;
		
		if (evaluationJeton[0]==0) { //Le jeton 1 est au centre du plateau
			if(plateau[coordonnees[0]][coordonnees[1]+1]=='-') //Regarde les cases autour pour savoir si un Jeton est collé à une pièce
				evaluation++;
			if(plateau[coordonnees[0]][coordonnees[1]-1]=='-')
				evaluation++;
			if(plateau[coordonnees[0]+1][coordonnees[1]]=='-')
				evaluation++;
			if(plateau[coordonnees[0]-1][coordonnees[1]]=='-')
				evaluation++;
		}
		evaluationJeton[0] = evaluation;
		evaluation=0;
		
		if (evaluationJeton[1]==0) { //Le jeton 2 est au centre du plateau
			if(plateau[coordonnees[2]][coordonnees[3]+1]=='-') //Regarde les cases autour pour savoir si le jeton est collé à une pièce
				evaluation++;
			if(plateau[coordonnees[2]][coordonnees[3]-1]=='-')
				evaluation++;
			if(plateau[coordonnees[2]+1][coordonnees[3]]=='-')
				evaluation++;
			if(plateau[coordonnees[2]-1][coordonnees[3]]=='-')
				evaluation++;
		}
		evaluationJeton[1] = evaluation;
		
		return evaluationJeton;
	}
	
	public static int[] evaluationMeilleurJeton (char[][] plateau) {
		
		int[] resultatJeton = {0,0,0,0,0};
		// {xInitialJeton,yInitialJeton,nouveauXJeton,nouveauYJeton,evaluationJetonCombinee}
		int[] evaluation = {0,0};
		//EvaluationJeton1,EvaluationJeton2
		int evaluationCombinee = -999;
		//EvaluationCombinee Jeton1 + Jeton 2
		char[][] plateauProvisoire = copiePlateau(plateau);
		
		//Permet de sauvegarder la position initial des Jetons pour les replacer lorsqu'on vérifie toutes les positions possibles des autres Jetons.
		int[] CoordonneesJetons = placerCoordonneesJetonsDansTableau(plateauProvisoire);
		int xInitialPremierJeton = CoordonneesJetons[0];
		int yInitialPremierJeton = CoordonneesJetons[1];
		int xInitialDeuxiemeJeton = CoordonneesJetons[2];
		int yInitialDeuxiemeJeton = CoordonneesJetons[3];
		
		//Change le premier Jeton en un caractère '-'  afin de permettre de tester les possibilités avec le premier jeton
		plateauProvisoire[xInitialPremierJeton][yInitialPremierJeton] = '-';
		
		for(int xJeton = 0; xJeton<4 ; xJeton++)  {
			for (int yJeton = 0 ; yJeton<4 ;yJeton++) {
				if(plateauProvisoire[xJeton][yJeton]=='-') {
					plateauProvisoire[xJeton][yJeton]='*' ;
					evaluation = evaluationJeton(plateauProvisoire);

					if(evaluation[0]+evaluation[1]>evaluationCombinee) {
						evaluationCombinee = evaluation[0]+evaluation[1];
						resultatJeton[0] = xInitialPremierJeton;
						resultatJeton[1] = yInitialPremierJeton;
						resultatJeton[2] = xJeton;
						resultatJeton[3] = yJeton;
						resultatJeton[4] = evaluationCombinee;
					}
					plateauProvisoire[xJeton][yJeton]='-';
				}
			}
		}
		
		// Change le deuxieme Jeton en un caractère '-'  afin de permettre de tester les possibilités avec le deuxieme jeton
		plateauProvisoire[xInitialDeuxiemeJeton][yInitialDeuxiemeJeton]='-';
		//Replace le Jeton 1
		plateauProvisoire[xInitialPremierJeton][yInitialPremierJeton] = '*';
	
		for(int xJeton = 0; xJeton<4 ; xJeton++)  {
			for (int yJeton = 0 ; yJeton<4 ;yJeton++) {
				if(plateauProvisoire[xJeton][yJeton]=='-') {
					plateauProvisoire[xJeton][yJeton]='*' ;
					evaluation = evaluationJeton(plateauProvisoire);

					if(evaluation[0]+evaluation[1]>evaluationCombinee) {
						evaluationCombinee = evaluation[0]+evaluation[1];
						resultatJeton[0] = xInitialPremierJeton;
						resultatJeton[1] = yInitialPremierJeton;
						resultatJeton[2] = xJeton;
						resultatJeton[3] = yJeton;
						resultatJeton[4] = evaluationCombinee;
					
					}
					plateauProvisoire[xJeton][yJeton]='-';
				}
			}
		}
		
		//Replace le jeton 2
		plateauProvisoire[xInitialDeuxiemeJeton][yInitialDeuxiemeJeton]='*';
		
		return resultatJeton;
	}

}