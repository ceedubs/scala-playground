package variance

class MyCollection[+A](private val elements: A*) {
  def filter(p: (A) => Boolean): MyCollection[A] = {
    val filteredElements = for (x <- elements if p(x)) yield x
    return new MyCollection[A](filteredElements:_*)
  }

  def :+(elem: A): MyCollection[A] = {
    return new MyCollection[A]((elements :+ elem):_*)
  }

  override def toString: String = {
    elements.toString
  }
}
