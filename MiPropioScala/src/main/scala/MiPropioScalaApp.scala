sealed trait Opcion[+A] {

  def estaVacio: Boolean

  def estaLleno: Boolean = !estaVacio

  def leerOValorPorDefecto[B >: A](valorPorDefecto: => B): B = {
    if (estaLleno) {
      leer
    } else {
      valorPorDefecto
    }
  }

  def leer: A

}

case class Algo[+A](valor: A) extends Opcion[A] {
  def estaVacio = false
  //def leerOValorPorDefecto[B >: A](valorPorDefecto: => B): B = valor
  def leer: A = valor
}

case object Ninguno extends Opcion[Nothing] {
  def estaVacio = true
  //def leerOValorPorDefecto[B](valorPorDefecto: => B): B = valorPorDefecto
  def leer: Nothing = throw new IllegalStateException("Error llamando a una opción vacía")
}

object MiPropioScalaApp extends App {

  println("Bienvenido a mi propio Scala")

  def maximo: Opcion[Int] = Ninguno

  val maximoValor = maximo.leerOValorPorDefecto(1000)

  println("Valor de máximo efectivo: " + maximoValor)

  if (maximo.estaLleno) {
    println("El máximo es " + maximo.leer)
  } else {
    println("No hay máximo")
  }

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
