package services

/* case classのいいところ
- プロパティが公開される(todo.nameなど)
- インスタンスを作る時にnewが必要なくなる(val todo = Todo())
- equals,hashCode,toStringなどが実装される
*/
case class Todo(name: String) {

}
