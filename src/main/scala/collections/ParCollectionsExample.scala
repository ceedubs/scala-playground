package parcollections

import scala.collection.GenIterable

object ParCollectionsExample {

	def main(args: Array[String]) {
		val numbers = 1 to 10

		println("starting sequential processing")
		processNumbers(numbers)

		val parNumbers = numbers.par
		println("starting parallel processing")
		processNumbers(parNumbers)
	}

	def processNumbers(numbers: GenIterable[Int]) {
		val start = System.currentTimeMillis
		numbers foreach { _ => Thread.sleep(500) }
		println("took " + (System.currentTimeMillis - start) + " millis.")
	}
}
