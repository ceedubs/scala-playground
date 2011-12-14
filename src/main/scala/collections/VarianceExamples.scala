package collections

object VarianceExamples {

	def main(args: Array[String]) {
    var bearList = List(new Bear(), new Bear())
    // bearList is now List[Bear]
    // could have used below line instead, but type inference saves some verbosity
    //var bearList: List[Bear] = List(new Bear(), new Bear())

    // List[Bear] is a sub-type of List[Animal]
    // this wouldn't be true with mutable lists, because someone could add a Zebra to our list!
    var animalList: List[Animal] = bearList
  }
}

trait Animal

class Bear extends Animal
