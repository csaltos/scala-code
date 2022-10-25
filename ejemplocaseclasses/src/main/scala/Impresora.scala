package com.paul

trait Impresora {

  def imprimir(usuario: Usuario) = {
    println("ID: " + usuario.id)
    println(s"Nombre ${usuario.nombre}")
  }

}
