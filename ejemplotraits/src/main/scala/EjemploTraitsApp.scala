package com.paul

trait Figura {

  def nombre: String

  def pintar() = {
    println("Pintando la figura " + nombre)
  }
}

object Cuadrado extends Figura {
  val nombre = "Cuadrado"

  override def pintar() = {
    println("Pintando cuadrado")
    super.pintar()
  }
}

object Circulo extends Figura {
  val nombre = "circulo"
}

object EjemploTraitsApp extends App {
  println("Bienvenido a ejemplos de traits")
  Cuadrado.pintar()
  Circulo.pintar()
}
