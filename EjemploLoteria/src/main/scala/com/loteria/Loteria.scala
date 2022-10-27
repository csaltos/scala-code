package com.loteria

sealed trait Loteria {
  def mensaje: String
}

object Loteria {
  def ejecutar(numero: Double): Loteria = {
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

case class GanadorMayor(numero: Double) extends Loteria {
  val mensaje = "Ganador mayor con el numero " + numero
}
case class Ganador(numero: Double) extends Loteria {
  val mensaje = "Ganador normal con el numero " + numero
}
case class Casi(numero: Double) extends Loteria {
  val mensaje = "Casi gana con el numero " + numero
}
case object VuelvaJugar extends Loteria {
  val mensaje = "Vuelva a jugar"
}
