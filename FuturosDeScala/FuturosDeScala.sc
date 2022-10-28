import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.impl.Promise

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

val valorFuturo = getTotalVenta("123420") flatMap { resultado =>
  guardarEnBaseDeDatos(resultado)
}

valorFuturo recover {
  case exception =>
    //log.error("Error en calcular el total de venta", exception)
    0.0
}

valorFuturo recoverWith  {
  case exception =>
    getTotalVenta("123420")
}

val valor = Await.result(valorFuturo, Duration.Inf)

getTotalVenta("123420") map { resultado =>
  println("Resultado 1: " + resultado)
}

getTotalVenta("34579100") map { resultado =>
  println("Resultado 2: " + resultado)
}
