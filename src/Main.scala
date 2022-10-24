import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    var i = 1
    var Indication = new Array[String](3)
    var direction = new Array[Char](1)
    var serieInstruction: String = " "
    var tondeuse = new Tondeuse()

    try {

      val source = Source.fromFile("tondeuses.txt")
      val lines = source.getLines
      val xy_coinSup = lines.next().split(" ")

      while (lines.hasNext == true) {

        Indication = lines.next().split(" ")
        direction = Indication(2).toCharArray
        serieInstruction = lines.next()

        tondeuse = new Tondeuse()
        print(s"Tondeuse $i : ")
        tondeuse.findposition(
          direction(0),
          Indication(0).toInt,
          Indication(1).toInt,
          xy_coinSup(0).toInt,
          xy_coinSup(1).toInt,
          serieInstruction
        )
        i += 1
      }
      source.close()
    } catch {
      case one: java.io.FileNotFoundException =>
        println("Le fichier n'existe pas")
    }

  }
}