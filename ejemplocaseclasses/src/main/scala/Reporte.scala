package com.paul

object Reporte extends Impresora {

  def reportar() = {
    val usuario = Usuario("1", "Efraín")
    imprimir(usuario)
  }

}
