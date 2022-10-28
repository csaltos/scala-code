import scala.util.{Failure, Success, Try}

def procesar(numero: String): String = {
  val numeroDeVerdad = Try(numero.toInt)
  numeroDeVerdad match {
    case Failure(exception) =>
      // log.error("Procesado con valor erróneo", exception)
      "Número inválido, por favor reintente"
    case Success(valor) =>
      "El valor procesado es " + (valor * 2)
  }
}

procesar("3")

procesar("pepe")
