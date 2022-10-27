sealed trait Opcion[+A] {
  def estaVacio: Boolean
  def leer: A
}

case class Algo[+A](valor: A) extends Opcion[A] {
  def estaVacio = false
  def leer: A = valor
}

case object Ninguno extends Opcion[Nothing] {
  def estaVacio = true
  def leer: Nothing = throw new IllegalStateException("Error llamando a una opción vacía")
}

object MiPropioScalaApp extends App {

  println("Bienvenido a mi propio Scala")

  def maximo: Opcion[Int] = Ninguno

  if (maximo.estaVacio) {
    println("No hay máximo")
  } else {
    println("El máximo es " + maximo.leer)
  }

  maximo match {
    case Algo(valor) =>
      println("El máximo es " + valor)
    case Ninguno =>
      println("No hay máximo")
  }

}
