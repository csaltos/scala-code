import scala.util.{Failure, Success, Try}

def procesar(numero: String): Try[Int] = {
  Try(numero.toInt) map (n => n * 2)
}

def procesar2(numeroDeVerdad: Int): Try[Int] = {
  Try(20 / numeroDeVerdad)
}

def procesar3(numero: Int): Try[Int] = {
  Try(numero * 100)
}

procesar("hola") flatMap procesar2 flatMap procesar3 map { resultado =>
  println("El resultado es: " + resultado)
}

procesar("3") flatMap { resultado =>
  procesar2(resultado) flatMap { resultado2 =>
    procesar3(resultado2) map { resultado3 =>
      resultado3 + 1000
    }
  }
}
