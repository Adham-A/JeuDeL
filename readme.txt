
Demander contre qui souhaite jouer le joueur
Afficher le plateau
Placer sa piece
Choisir de placer ou non un jeton
Verifier que le joueur n'as pas gagné

Le plateau est un tableau de caractères à 2 dimensions
La pièce d'un joueur est symbolisé par 1 ou 2
Les jetons neutres sont symbolisés par '*'

Pour savoir si un joueur a gagner il faut vérifier qu'il n'a aucun coup valide, on ne peut pas jouer là ou on est.

					
					//Exemple victoire joueur 1

1| * 2 2 - 
2| - 1 2 - 
3| - 1 2 - 
4| - 1 1 * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 1 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
5
Entrez x du coin : 
1
Entrez y du coin : 
4
1| * 2 2 - 
2| - - 2 - 
3| 1 - 2 - 
4| 1 1 1 * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
non

1| * 2 2 - 
2| - - 2 - 
3| 1 - 2 - 
4| 1 1 1 * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 2 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
6
Entrez x du coin : 
3
Entrez y du coin : 
2
1| * - - - 
2| 2 2 2 - 
3| 1 - 2 - 
4| 1 1 1 * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
oui
Entrez position x actuelle du jeton : 
1
Entrez position y actuelle du jeton : 
1

Entrez la nouvelle position du jeton :
Entrez x : 
4
Entrez y : 
1

1| - - - * 
2| 2 2 2 - 
3| 1 - 2 - 
4| 1 1 1 * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Victoire du joueur 2

					

					//Exemple victoire joueur 2 

1| * 2 2 - 
2| - 1 2 - 
3| - 1 2 - 
4| - 1 1 * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 1 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
2
Entrez x du coin : 
2
Entrez y du coin : 
2
1| * 2 2 - 
2| 1 1 2 - 
3| - 1 2 - 
4| - 1 - * 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
oui
Entrez position x actuelle du jeton : 
4
Entrez position y actuelle du jeton : 
4
Entrez la nouvelle position du jeton :
Entrez x : 
4
Entrez y : 
1

1| * 2 2 * 
2| 1 1 2 - 
3| - 1 2 - 
4| - 1 - - 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 2 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
3
Entrez x du coin : 
3
Entrez y du coin : 
2
1| * - - * 
2| 1 1 2 2 
3| - 1 2 - 
4| - 1 2 - 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
oui
Entrez position x actuelle du jeton : 
4
Entrez position y actuelle du jeton : 
1
Entrez la nouvelle position du jeton :
Entrez x : 
2
Entrez y : 
1

1| * * - - 
2| 1 1 2 2 
3| - 1 2 - 
4| - 1 2 - 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 1 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
4
Entrez x du coin : 
2
Entrez y du coin : 
4
1| * * - - 
2| - 1 2 2 
3| - 1 2 - 
4| 1 1 2 - 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
oui
Entrez position x actuelle du jeton : 
1
Entrez position y actuelle du jeton : 
1
Entrez la nouvelle position du jeton :
Entrez x : 
4
Entrez y : 
1

1| - * - * 
2| - 1 2 2 
3| - 1 2 - 
4| 1 1 2 - 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 2 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
4
Entrez x du coin : 
4
Entrez y du coin : 
4
1| - * - * 
2| - 1 - 2 
3| - 1 - 2 
4| 1 1 2 2 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
oui
Entrez position x actuelle du jeton : 
2
Entrez position y actuelle du jeton : 
1
Entrez la nouvelle position du jeton :
Entrez x : 
3
Entrez y : 
2

1| - - - * 
2| - 1 * 2 
3| - 1 - 2 
4| 1 1 2 2 
   ̅1̅ ̅2̅ ̅3̅ ̅4
C'est au tour du joueur : 1 

Comment shouaitez vous placer votre pièce ?
*   **   **   *
*    *   *    *  *   ***  ***   *
**   *   *   **  ***   *  *   *** 
1    2   3    4  5     6  7     8

Entrez l'orientation souhaité : 
2
Entrez x du coin : 
2
Entrez y du coin : 
2
1| - - - * 
2| 1 1 * 2 
3| - 1 - 2 
4| - 1 2 2 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Voulez vous jouez le jeton : entrez oui/non 
non

1| - - - * 
2| 1 1 * 2 
3| - 1 - 2 
4| - 1 2 2 
   ̅1̅ ̅2̅ ̅3̅ ̅4
Victoire du joueur 1