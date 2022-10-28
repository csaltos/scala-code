import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.util.ByteString

import java.nio.charset.StandardCharsets
import scala.concurrent.ExecutionContext.Implicits.global

object EjemploDeFuturosApp extends App {

  implicit val system = ActorSystem()

  Http().singleRequest(HttpRequest(uri = "https://www.yahoo.com")) flatMap { response =>
    response.entity.dataBytes.runForeach(chunk =>
      print(chunk.decodeString(StandardCharsets.UTF_8))
    )
  } flatMap { _ =>
    system.terminate()
  }

}