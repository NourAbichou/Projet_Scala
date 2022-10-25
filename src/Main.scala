import scala.io.Source //une bibliothèque destinée à créer une représentation itérable d'un fichier source.

object Main {

  def main(args: Array[String]): Unit = {

    var i = 1                                 //Une variable affichant le numero de tondeuse par ordre.

    var indication = new Array[String](3)     //un tableau qui va extraire l'information de chaque ligne du fichier d'entrée et il est de taille 3.

    var direction = new Array[Char](1)        //un tableau qui va extraire l'information la direction intiale de la tondeuse founri par le fichier d'entrée
                                              //et il est de taille 1.

    var serieInstruction: String = " "        //la chaîne de caractères qui contiendra la série d'instructions.

    var tondeuse = new Tondeuse()             //la variable tondeuse est une instance de classe Tondeuse qui déterminera et affichera
                                              //la position et l'orientation finaux de la tondeuse.

    try {                                     //Try et catch permet la gestion d'un erreur liée a l'inexistance de la ficher fourni par
                                              //l'utlisateur afin d'eviter de faire planter tout le programmer.

      val source = Source.fromFile("tondeuses.txt")   //Ouverture de la fichier source.

      val lines = source.getLines                     //lines contiennent une seule ligne au fur et à mesure de la lecture de la ficher source.

      val xy_coinSup = lines.next().split(" ") //Passation d'un ligne a un autre par la fonction next().
                                                      //xy_coinSup récupéra les coordonnées du coin supérieur droit de la pelouse.
                                                      //La fonction "split" retourne un String ???diviser par les espaces

      while (lines.hasNext == true) {                 //le boucle while permet de determiner pour chaque tondeuse sa postion et son orientation qu'elle
                                                      //achève sa série d'instructions.
                                                      //le boucle s'arretra quand ne fichier est vide, c-a-d il y n'a plus de ligne.
                                                      //la fonction hasNext permettera de verifer la condition de validation de la boucle while.

        indication = lines.next().split(" ")   //affectation de la ligne des données intiales(x,y,direction) dans un tableau

        direction = indication(2).toCharArray         // récupération de la direction à partir du tableau indication créer ci dessus
        serieInstruction = lines.next()               // récupération des instructions

        tondeuse = new Tondeuse()                     // création d'une instance Tondeuse

        print(s"Tondeuse $i : ")                     // Appel de la méthode TrouverPosition avec les données récupérées précédemment
                                                     // (en convertissant les x et y vers int en utilisant la fonction toInt
        tondeuse.TrouverPosition(
          direction(0),
          indication(0).toInt,
          indication(1).toInt,
          xy_coinSup(0).toInt,
          xy_coinSup(1).toInt,
          serieInstruction
        )
        i += 1
      //NB : La détermination du nombre de tondeuse est basée sur le nombre de lignes du fichier source.
      //     Le premier ligne du fichier correspond aux coordonnés du coin supérieur droit, puis chaque
      //     paire de lignes correspondra à une tondeuse et ainsi de suite.
      }

      source.close() //Fermuture de la ficher source

    } catch {     // Dans le cas ou le ficher est invalide le programme va afficher a l'ulilisateur que le ficher n'exist pas.
      case one: java.io.FileNotFoundException =>
        println("Le fichier n'existe pas")
    }

  }
}