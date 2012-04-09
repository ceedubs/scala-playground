package naught


object NoneExample {
  def main(args: Array[String]) = {
    val userIds = List (1, 2, 3)
    val users = userIds map { getUserById(_) }
    println(users) // List(Some(User(1,Bob)), Some(User(2,Bill)), None)

    val validUsers = users.flatten
    println(validUsers) // List(User(1,Bob), User(2,Bill))

    val userNames = users map { user =>
      val name = user map { _.name }
      name.getOrElse("N/A")
    }
    println(userNames) // List(Bob, Bill, N/A)
  }

  def getUserById(id: Int): Option[User] = {
    id match {
      case 1 => Some(new User(1, "Bob"))
      case 2 => Some(new User(2, "Bill"))
      case _ => None
    }
  }
}

case class User(val id: Int, val name: String)
