sealed trait Resultado
case class Ganador(numero: Double) extends Resultado
case class Casi(numero: Double) extends Resultado
case object VuelvaJugar extends Resultado

object Loteria {

  def mensajeResultado(resultado: Resultado): String = {
    resultado match {
      case Ganador(numero) =>
        "Ganador con el numero " + numero
      case Casi(numero) =>
        "Casi gana con el numero " + numero
      case VuelvaJugar =>
        "Vuelva a jugar"
    }
  }

  def ejecutar(numero: Double): Resultado = {
    if (numero > 0.9) {
      Ganador(numero)
    } else if (numero > 0.7) {
      Casi(numero)
    } else {
      VuelvaJugar
    }
  }
}

object EjemploLoteriaApp extends App {
  println("Bienvenido al ejemplo de loteria")
  val numero = math.random()
  val resultado = Loteria.ejecutar(numero)
  val mensaje = Loteria.mensajeResultado(resultado)
  println(mensaje)
  resultado match {
    case Ganador(numero) =>
      println("Ganador registrado en base de datos " + numero)
    case Casi(numero) =>
      println("Guardando en otra tabla " + numero)
    case VuelvaJugar =>
      println("Sin guardado en base de datos")
  }

}
