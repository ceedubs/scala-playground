package typebounds

import collection.GenIterable

/**
 * A predicate that takes a single parameter.
 * A predicate is a boolean-valued function.
 *
 * @tparam T the type of the parameter the predicate evaluates
 */
trait Predicate1[T] extends MyFunction1[T, Boolean]

object CollectionUtils {
  def filter[T](items: GenIterable[T], predicate: Predicate1[T]) = {
    for {
      x <- items
      if predicate(x)
    } yield x
  }
}

object MyFunctionExamples {
  def main(args: Array[String]) {
    val isEven = new Predicate1[Int]() {
      def apply(n: Int) = n % 2 == 0
    }

    println("1 is even: " + isEven(1))
    println("2 is even: " + isEven(2))

    val evens = CollectionUtils.filter(List(1, 2, 3, 4), isEven)
    println("evens: " + evens)
  }
}
