package com.loteria

sealed trait Resultado {
  def mensaje: String
}

case class GanadorMayor(numero: Double) extends Resultado {
  val mensaje = "Ganador mayor con el numero " + numero
}
case class Ganador(numero: Double) extends Resultado {
  val mensaje = "Ganador normal con el numero " + numero
}
case class Casi(numero: Double) extends Resultado {
  val mensaje = "Casi gana con el numero " + numero
}
case object VuelvaJugar extends Resultado {
  val mensaje = "Vuelva a jugar"
}
