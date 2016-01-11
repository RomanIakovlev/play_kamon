package controllers

import kamon.Kamon
import play.api.Play.current
import play.api.libs.ws.WS
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {
  def index = Action.async {
    val traceCtx = Kamon.tracer.newContext("WS_call_custom_trace")
    WS.url("http://google.com").get().map { r =>
      traceCtx.finish()
      Ok(views.html.index("Your new application is ready: " + r.body))
    }
  }

}