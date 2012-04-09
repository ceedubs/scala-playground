package typebounds

object AnimalExamples {
  def main(args: Array[String]) {
  }
}

trait Animal

class Bear extends Animal

class Dog extends Animal

class Cage[T <: Animal] {
  private[this] var animals: List[T] = Nil

  def cagedAnimals: List[T] = animals.toList // immutable version

  def add(animal: T) {
    animals = animal :: animals
  }

}
