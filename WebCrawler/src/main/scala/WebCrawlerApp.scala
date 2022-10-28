import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source

object WebCrawlerApp extends App {

  def crawl(url: String): String = {
    val cabecera = Source.fromURL(url).getLines().toList.take(3)
    cabecera.mkString("\n")
  }

  val contenido = crawl("https://www.yahoo.com/")

  println(contenido)

}
