import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.io.Source

object WebCrawlerApp extends App {
  def crawl(url: String): Future[String] = {
    Future {
      val cabecera = Source.fromURL(url).getLines().toList.take(3)
      cabecera.mkString("\n")
    }
  }

  def load(nombre: String, url: String): Future[Boolean] = {
    crawl(url) map { contenido =>
      println(s"${nombre}: " + contenido)
      true
    } recover {
      case error =>
        println(s"No se pudo cargar ${nombre}: " + error.getMessage)
        false
    }
  }

  for {
    r1 <- load("Yahoo", "https://www.yahoo.com/")
    r2 <- load("Google", "https://www.google.com/")
    r3 <- load("IBM", "https://www.ibm.com/")
  } yield {
    if (r1 && r2 && r3) {
      println("Completo")
    } else {
      println("Fallido")
    }
  }

  load("Yahoo", "https://www.yahoo.com/") flatMap { _ =>
    load("Google", "https://www.google.com/") flatMap { _ =>
      load("IBM", "https://www.ibm.com/")
    }
  }

  val resultados = Seq(
    load("Yahoo", "https://www.yahoo.com/"),
    load("Google", "https://www.google.com/"),
    load("IBM", "https://www.ibm.com/")
  )

  val completado = Future.sequence(resultados)

  Await.ready(completado, Duration.Inf)

}
