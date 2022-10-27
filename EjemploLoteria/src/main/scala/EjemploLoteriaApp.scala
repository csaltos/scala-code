sealed trait Resultado
case class Ganador(numero: Double) extends Resultado
case class Casi(numero: Double) extends Resultado
case object VuelvaJugar extends Resultado

object Loteria {

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
  Loteria.ejecutar(numero) match {
    case Ganador(numero) =>
      println("Ganador registrado en base de datos " + numero)
    case Casi(numero) =>
      println("Guardando en otra tabla " + numero)
    case VuelvaJugar =>
      println("Sin guardado en base de datos")
  }

}
