
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
	
	public static char[][] copiePlateau(char[][] t){
		char[][] copie = new char[4][4];
		for (int y=0; y<t[0].length;y++) 
			for (int x=0 ; x<t.length ; x++)
				copie[x][y] = t[x][y];
		return copie;
	}
	
	public static void afficherPlateau(char[][] t) {
		for (int y=0; y<t[0].length;y++) {
			System.out.print((y+1)+"| ");
			for (int x=0 ; x<t.length ; x++)
				System.out.print(t[x][y] + " ");
			System.out.println();
		}
		System.out.println("   ̅1̅ ̅2̅ ̅3̅ ̅4");
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
			
				if(!verification3casesLongeur(x,y,orientationPiece,plateauSansL,charJoueur))
					return false;
				break;
			
			case 6:
			case 8:
				
				if (x<2)
					return false;
				
				if(!verification3casesLongeur(x,y,orientationPiece,plateauSansL,charJoueur))
					return false;
				break;
			}
		
		return verificationCoin(x, y, orientationPiece, plateauSansL, charJoueur);
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
		
	public static boolean verification3casesLongeur(int x, int y,int orientation, char[][] plateauSansL, char charJoueur) {
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
	}

	public static boolean victoire(char[][] plateau, char charJoueur){
		
		int longeur = plateau.length;
		int hauteur = plateau[0].length;
		int nbrpossibilite=0;
		
		char[][] plateauSansL = copiePlateau(plateau);
		enleverPieceJoueurDuPlateau(plateauSansL, charJoueur);
		
		for(int x = 0; x<longeur ; x++) 
			for (int y = 0 ; y<hauteur ;y++) 
					for(int orientation=1;orientation<5 ;orientation++) {
						if(verification(x, y, orientation, plateauSansL, charJoueur))
						nbrpossibilite++;
						if (nbrpossibilite>=2)
							return false;
					}
		
		for (int y=0; y<hauteur ; y++)
			for (int x=0;x<longeur;x++)
					for(int orientation=5;orientation<9 ;orientation++) {
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
					System.out.println("Entrez la nouvelle position du jeton :\nEntrez x : ");
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
				"Après avoir deplaçé sa pièce un joueur peut décider ou non de bouger un des jetons neutres symbolisés par :  '*' \r\n" + 
				"Le but du jeu est d'empecher l'adversaire d'avoir des déplacements restants.\r\n" + 
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
				"---> **        *\n");
	}
	
	public static int selectionnerdifficulte() {
		
		int choix;
		System.out.println("1.Jouer contre un humain\r\n" + 
				"2.Jouer contre une IA (facile)\r\n" + 
				"3.Jouer contre une IA (moyen)\r\n" + 
				"4.Jouer contre une IA (difficile)");
		choix = Integer.parseInt(sc.nextLine());
		
		while( choix<1 || choix>4) {
			System.out.println("Erreur de sélection : \n ");
			System.out.println("1.Jouer contre un humain\r\n" + 
					"2.Jouer contre une IA (facile)\r\n" + 
					"3.Jouer contre une IA (moyen)\r\n" + 
					"4.Jouer contre une IA (difficile)");
			choix = Integer.parseInt(sc.nextLine());
		}
		
		return choix;
	}
	
	public static void placementOrdinateur(char[][] plateau,char charJoueur,int difficulte) {
		
		switch(difficulte) {
		case 2 :
			placementOrdinateurFacile(plateau,charJoueur);
			break;
		case 3 :
			
			break;
		case 4 :
			
			break;
		}
		
	}
	
	public static void placementJetonOrdinateurAleatoire(char[][] plateau) {
		
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
	
	public static int [] placerCoordonneesJetonsDansTableau(char[][] plateau) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
