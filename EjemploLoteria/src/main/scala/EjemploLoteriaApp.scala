import com.loteria._

object EjemploLoteriaApp extends App {
  println("Bienvenido al ejemplo de loteria")
  val numero = math.random()
  Loteria.ejecutar(numero) match {
    case resultado @ GanadorMayor(numero) =>
      println(resultado.mensaje)
      println("Ganador registrado en base de datos premium " + numero)
    case resultado @ Ganador(numero) =>
      println(resultado.mensaje)
      println("Ganador registrado en base de datos " + numero)
    case resultado @ Casi(numero) =>
      println(resultado.mensaje)
      println("Guardando en otra tabla " + numero)
    case resultado @ VuelvaJugar =>
      println(resultado.mensaje)
      println("Sin guardado en base de datos")
  }

}
