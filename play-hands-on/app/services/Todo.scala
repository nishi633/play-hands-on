package services

import javax.inject.Inject

import anorm.SqlParser._
import anorm._
import play.api.db.DBApi

import scala.language.postfixOps

/* case classのいいところ
- プロパティが公開される(todo.nameなど)
- インスタンスを作る時にnewが必要なくなる(val todo = Todo())
- equals,hashCode,toStringなどが実装される
*/
case class Todo(name: String)

@javax.inject.Singleton
class TodoService @Inject() (dbapi: DBApi) {

  // DB
  private val db = dbapi.database("default")

  val simple = {
    get[String]("todo.name") map {
      case name => Todo(name)
    }
  }

  def list(): Seq[Todo] = {

    db.withConnection { implicit connection =>

      SQL(
        """
          select * from todo
        """
      ).as(simple *)

    }

  }

}
