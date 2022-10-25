package com.paul

class Animal(val nombre: String, presentarArticulo: Boolean) {

  def descripcion() = {
    print("Hola, soy ")
    if (presentarArticulo) {
      print("un ")
    }
    println(nombre)
  }

}

object Perro extends Animal(nombre = "perrito", presentarArticulo = true) {

  def saludar() = {
    descripcion()
  }

}

object EjemplosClasesYObjectosApp extends App {

  println("Bienvenidos a ejemplos de clases y objetos")

  Perro.saludar()
  Perro.saludar()

  val animal1 = new Animal(nombre = "Cookie", presentarArticulo = false)
  animal1.descripcion()

  val lori = new Animal(nombre = "Lori", presentarArticulo = false)
  lori.descripcion()

  animal1.descripcion()
  lori.descripcion()
}

