package variance

object MyCollectionExample {
  def main(args: Array[String]) {
    val myCol = new MyCollection[Int](1, 2, 3, 4)
    println("all elements: " + myCol)
    val evenPredicate = { x: Int =>
      x % 2 == 0
    }
    println("even elements: " + myCol.filter(evenPredicate))
    val onePredicate = { x: AnyVal =>
      x.toString == "1"
    }

    println("one elements: " + myCol.filter(onePredicate))

    println("with 5: " + (myCol :+ 5))
  }
}
