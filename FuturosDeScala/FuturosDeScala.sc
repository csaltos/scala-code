import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.impl.Promise

def getTotalVenta(codigoDeUsuario: String): Future[Double] = {
  Future {
    Thread.sleep(2000)
    throw new IllegalStateException("Simulando un error")
    1000.0
  }
}

def guardarEnBaseDeDatos(totalVenta: Double): Future[Boolean] = {
  Future {
    Thread.sleep(2000)
    2000.0 / totalVenta
    true
  }
}

def valorFuturo = getTotalVenta("123420") flatMap { resultado =>
  guardarEnBaseDeDatos(resultado)
}

val resultadoFuturo: Future[Boolean] = valorFuturo recover {
  case exception =>
    //log.error("Error en calcular el total de venta", exception)
    false
}

val resultado = Await.result(resultadoFuturo, Duration.fromNanos(10000000000L))

val resultadoFuturo2: Future[Boolean] = valorFuturo recoverWith {
  case exception =>
    valorFuturo
}

val valor = Await.result(valorFuturo, Duration.Inf)

getTotalVenta("123420") map { resultado =>
  println("Resultado 1: " + resultado)
}

getTotalVenta("34579100") map { resultado =>
  println("Resultado 2: " + resultado)
}
