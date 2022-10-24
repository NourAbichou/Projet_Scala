

class Tondeuse {

  /** la methode orientation finale nous permettons de determiner une nouvelle
   * orientation de notre tondeuse en se basant sur sa orientation intiale
   * (N,E,W,S) et sa direction : à gauche ou bien à droite
   */

  def findFinalOrientation(
                            orientationInitial: Char,
                            direction: Char
                          ): Char = {

    var orientation_final: Char = ' '

    if (orientationInitial == 'N') {
      if (direction == 'D') {
        orientation_final = 'E'
      } else if (direction == 'G') {
        orientation_final = 'W'
      }
    } else if (orientationInitial == 'W') {
      if (direction == 'D') {
        orientation_final = 'N'
      } else if (direction == 'G') {
        orientation_final = 'S'
      }
    } else if (orientationInitial == 'S') {
      if (direction == 'D') {
        orientation_final = 'W'
      } else if (direction == 'G') {
        orientation_final = 'E'
      }
    } else if (orientationInitial == 'E') {
      if (direction == 'D') {
        orientation_final = 'S'
      } else if (direction == 'G') {
        orientation_final = 'N'
      }

    }
    return orientation_final
  }

  /** * On va définir une fonction sous le nom de "findposition" qui nous
   * permettra d'afficher la position finale sous forme d'une chaine de
   * caractere
   */
  def findposition(
                    orientationInitial: Char,
                    xIntial: Int,
                    yIntial: Int,
                    xlimite: Int,
                    ylimite: Int,
                    mouvements: String
                  ): Unit = {

    /** * on va initialiser la valeur de x final à valeur de de corrodone de x
     * intial
     */
    var xfinal: Int = xIntial

    /** * on va initialiser la valeur de y final à valeur de de corrodone de y
     * intial
     */
    var yfinal: Int = yIntial

    /** * cette variable va etre intialiser par la valeur de l'orientation
     * Initial et ensuite de l'ecraser par la nouvelle orientation grace a
     * notre classe orientation finale
     */
    var orientationFinale: Char = orientationInitial

    /** * c'est la varable a retourner qui contient les corrdonnées x et y
     * finaux et la direction finale
     */
    var myposition: String = ""

    /** * le boucle while permet de parcourir notre chaine d'instructement
     */

    for (element <- mouvements) {

      /** * Dans cette partie on va discuter deux cases soit on pivote la
       * tendouse a droite ou a gauche, ou bien on trouve une instruction pour
       * le avancer
       */

      /** * si l'element au postion de l'indice i egale G ou D alors on va
       * determiner la nouvelle orientation
       */

      if (element == 'D' || element == 'G') {

        /** * on fait appel a la classe orientationfianl afin de determiner a
         * chaque fois la nouvelle orientation
         */

        /*  il faut rendre orienation plus dynamique*/
        orientationFinale = findFinalOrientation(orientationFinale, element)
      }

      /** * si l'element au postion de l'indice i egale A on va avancer la
       * dondeuse et donc de mettre a jour les corrdonnées de x et y tout en
       * respectant les differents cas possible
       */
      if (element == 'A') {

        /** * en se basant sur les differents orientation possible la tondeuse
         * peut se depacer et les coordonnes de x ou y va augmenter ou diminuer
         * de 1
         */

        /** * On utilise le case et pattern matching afin d'acualiser les
         * corrdonnées de x et y en fonction leurs orientations
         */

        /** * On applique le pattern matching sur l'orientation genere par la
         * classe de l'orientationfinale
         */

        orientationFinale match {

          /** * Il existe quatre cas possible : Si l'ortientation de notre
           * tendeuse est vers le Est "E" ou bien vers West "W", on va faire
           * varier x sinon si elle une orientation vers Nord "N" ou bien Sud
           * "S", on fait varie y
           */

          /** * on va travailler sur un plan de deux dimensions x et y sachant
           * les valeurs minimales correpond aux coordonnées du coin
           * supérieur(0,0) et les valeurs maximium sont (xlimite,yfinal)
           */

          case 'N' => if (yfinal < ylimite) yfinal = yfinal + 1

          /** on avance d'une case sur l'axe de y */
          case 'S' => if (yfinal > 0) yfinal = yfinal - 1

          /** on  diminu par une unité la valeur de y */
          case 'E' => if (xfinal < xlimite) xfinal = xfinal + 1

          /** on avance d'une case sur l'axe de x */
          case 'W' => if (xfinal > 0) xfinal = xfinal - 1

          /** on  diminu par une unité la valeur de x */

          /** le zero dans les condtions de "S" et "W" signifie que le valeur
           * des corrdonnes ne doit pas etre negative sinon la tondeuse va
           * sortir de son plan de travaille
           */

          /** * Si les coordonnées (x,y) ne respecte pas ces condition le valeur
           * de xfinal et yfinal ne vont pas change et vont les derniers
           * valeurs affectées
           */

        }

      }

    }

    /** on contruit et retouner notre chaine de caractre qui presnete la
     * position finale de la tondeuse sous la forme : xfinal yfinal
     * orientationFinale
     */
    myposition =
      xfinal.toString + " " + yfinal.toString + " " + orientationFinale
    println(myposition)
  }
}

