

// la classe Faucheuse détermine et imprime les coordonnées x,y finales et le orientation
//  finale de la tondeuse une fois que ses instructions sont finalisées.
class Tondeuse {

//la fonction TrouverOrientation retourne une nouvelle orientation en fonction de l'orientation
// et la direction de la tondeuse.
  def TrouverOrientation(
                            orientationInitiale: Char, //L'orination initiale de la tondeuse
                            direction: Char            //La direction intiale de la tondeuse
                          ): Char = {

  //initialisation de la variable qui contiendra l'orientation finale (N,E,W,S)
    var orientationFinale: Char = ' '

  //La structure conditionnelle imbriquée IF vérifie d'abord l'orientation initiale (N,E,W,S), puis vérifie dans un deuxième temps la direction
  //si celle-ci est D:Droite ou G:Gauche et affecte à la variable orientation finale une valeur (N,E,W,S).

    if (orientationInitiale == 'N') {
      if (direction == 'D') {
        orientationFinale = 'E'
      } else if (direction == 'G') {
        orientationFinale = 'W'
      }
    } else if (orientationInitiale == 'W') {
      if (direction == 'D') {
        orientationFinale = 'N'
      } else if (direction == 'G') {
        orientationFinale = 'S'
      }
    } else if (orientationInitiale == 'S') {
      if (direction == 'D') {
        orientationFinale = 'W'
      } else if (direction == 'G') {
        orientationFinale = 'E'
      }
    } else if (orientationInitiale == 'E') {
      if (direction == 'D') {
        orientationFinale = 'S'
      } else if (direction == 'G') {
        orientationFinale = 'N'
      }

    }
    return orientationFinale
  }

  //La fonction TrouverPosition déterminera les coordonnées x,y finales en se servant de la fonction TrouverOrientation à chaque
  //étapedes Instructions et imprimera au final les coordonnées x,y finales et l'orientation finale de la tondeuse.
  def TrouverPosition(
                    orientationInitiale: Char, //L'orination initiale de la tondeuse
                    xIntiale: Int,             //le corrdonne de la tondeuse sur l'axe de x
                    yIntiale: Int,             //le corrdonne de la tondeuse sur l'axe de y
                    xlimite: Int,              //xLimite et yLimite representent les coordonnées du coin supérieur droit de la pelouse.
                    ylimite: Int,
                    mouvements: String         //une séquence d'instructions permettant à la tondeuse d'explorer la pelouse.
                  ): Unit = {

    var xfinale: Int = xIntiale                //Initialisation de corrdonne de x fianl en xIntiale.


    var yfinale: Int = yIntiale                //Initialisation la valeur de y final à valeur de de corrodone de y intiale.


    var orientationFinale: Char = orientationInitiale //Initialisation de l'orientation finale de la tondeuse par son orientation initiale, puis écraser celle-ci avec la nouvelle orientation
                                                      //obtenue à l'aide de la fonction TrouverOrientation.


    var positionTondeuse: String = "" //Cette variable contiendra les corrdonnées x et y finaux et la direction finale
                                      //sous la forme : x y Orientation.


    for (element <- mouvements) {    //parcourir la serie de l'instruction


  //La partie ci-dessous traitera deux cas en fonction des composants de la directive.
  //La variable mouvements ne peut comporter que trois instruction (D, G) pour faire
  //pivoter la tondeuse a droite ou la gauche et (A) pour la faire avancer.


    //Priemere condition  :
      if (element == 'D' || element == 'G') {

      orientationFinale = TrouverOrientation(orientationFinale, element) //Affectation du valeur de l'orientation finale par resultat
                                                                         //de la fonction TrouverOrientation pour chaque elements.
      }

      if (element == 'A') {


    //Les coordonnes (x,y) prendra des valeurs en fonction de l'orientation fianle obtune pour chaque element.

        orientationFinale match {

    //N.B : la tondeuse deplace sur un espace de deux dimensions (x,y)
    //Il existe quatre cas possibles :
    //Une orienation vers le "E" ou vers le "W", va faire varier(une augmentation ou une diminution de 1) x.
    //Une orienation vers le "S" ou vers le "N", va faire varier(une augmentation ou une diminution de 1) y.


    //N.B : les zéros de conditionnement des orientations "S" et "W" sont les coordonnées de le coin inférieur gauche (0,0),
    //      autrement dit les coordonnées finaux (x,y) ne devront pas être négatifs de sorte que la tondeuse ne dépassera
    //      pas les frontières de la pelouse.



          case 'N' => if (yfinale < ylimite) yfinale = yfinale + 1 //Avancement d'une case sur l'axe de y

          case 'S' => if (yfinale > 0) yfinale = yfinale - 1       //Diminution d'une case sur l'axe de y

          case 'E' => if (xfinale < xlimite) xfinale = xfinale + 1 //Avancement d'une case sur l'axe de x

          case 'W' => if (xfinale > 0) xfinale = xfinale - 1       //Diminution d'une case sur l'axe de y

    //Dans le cas où les les coordonnées (x,y) finaux ne respectent pas les conditions ci-dessus,  (x,y) finaux
    // ne vont pas changer de valeur et ils vont garder la derniere valeur affectées.

        }

      }

    }


    positionTondeuse =
      xfinale.toString + " " + yfinale.toString + " " + orientationFinale //Construction une chaine de caractere sous la forme
                                                                          //xfinale yfinale orientationFinale.
      println(positionTondeuse)
  }
}

