package controllers

import javax.inject._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

// import Todo
import services._

class TodoController @Inject()(mcc: MessagesControllerComponents)
  extends MessagesAbstractController(mcc) {

  def helloworld() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok("Hello World")
  }

  def list() = Action { implicit request: MessagesRequest[AnyContent] =>
    // sample
    val items: Seq[Todo] = Seq(Todo("Todo1"), Todo("Todo2"))
    Ok(views.html.list(items))
  }

  def todoNew() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok("a")
  }
}