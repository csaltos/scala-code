import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

def getTotalVenta(codigoDeUsuario: String): Future[Double] = {
  Future {
    Thread.sleep(2000)
    1000.0
  }
}

def guardarEnBaseDeDatos(totalVenta: Double): Future[Boolean] = {
  Future {
    Thread.sleep(2000)
    true
  }
}

getTotalVenta("123420") flatMap { resultado =>
  guardarEnBaseDeDatos(resultado)
}

getTotalVenta("123420") map { resultado =>
  println("Resultado 1: " + resultado)
}

getTotalVenta("34579100") map { resultado =>
  println("Resultado 2: " + resultado)
}
