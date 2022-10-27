package com.loteria

object Loteria {

  def ejecutar(numero: Double): Resultado = {
    if (numero > 0.9) {
      GanadorMayor(numero)
    } else if (numero > 0.7) {
      Ganador(numero)
    } else if (numero > 0.5) {
      Casi(numero)
    } else {
      VuelvaJugar
    }
  }
}
