package com.paul

object EjemploCaseClassesApp extends App {

  println("Ejemplos de case classes")

  val pepe = Persona("Pepe", "Sanchez", 50)
  val maria = Persona("Maria", "Sajarova", 40)
  val otroPepe = Persona("Pepe", "Sanchez", 50)
  val miEmpresa = PersonaJuridica("F2132343G", "Paul Inc.", 1)

  println("Nombre: " + pepe.nombre)
  println("Nombre: " + maria.nombre)
  println("Mi empresa es: " + miEmpresa)

  if (pepe == otroPepe) {
    println("Son el mismo Pepe")
  } else {
    println("Son diferentes")
  }

}
