package typelevelprogramming

object NaturalNumbers {

  def main(args: Array[String]) = {
    TypeToValue.demo()
  }

  sealed trait NaturalNumber

  object NaturalNumber {
    sealed trait _0 extends NaturalNumber
    type _1 = Successor[_0]
    type _2 = Successor[Successor[_0]] // could also be Successor[_1]
    type _3 = Successor[_2]
    type _4 = Successor[_3]
    implicitly[Successor[_2] =:= _3] // will fail to compile if these types aren't equal
  }

  sealed trait Successor[N <: NaturalNumber] extends NaturalNumber

  sealed case class TypeToValue[T, VT](value: VT)

  object TypeToValue {
    import NaturalNumber._0
    implicit val _0ToInt = new TypeToValue[_0, Int](0)

    implicit def successorToInt[N <: NaturalNumber](implicit prevToInt: TypeToValue[N, Int]): TypeToValue[Successor[N], Int] = new TypeToValue[Successor[N], Int](prevToInt.value + 1);

    def toInt[N <: NaturalNumber](n: N)(implicit typeToVal: TypeToValue[N, Int]): Int = typeToVal.value

    def demo(): Unit = {
      import NaturalNumber._
      val zero: _0 = null
      println("zero to int: " + toInt(zero)) 
      val one: Successor[_0] = null
      println("one to int: " + toInt(one))
      val four: _4 = null
      println("four to int: " + toInt(four))
    }
  }

  sealed trait Sum[N <: NaturalNumber, M <: NaturalNumber, R <: NaturalNumber] 

  object Sum {
    import NaturalNumber._
    // n + 0 = n
    implicit def sum0[N <: NaturalNumber] = new Sum[N, _0, N]() {}

    // n + m' = n' + m
    implicit def sumAxiom2[N <: NaturalNumber, M <: NaturalNumber, R <: NaturalNumber](implicit mPredecessorSum: Sum[Successor[N], M, R]) = new Sum[N, Successor[M], R]() {}

    implicitly[Sum[_1, _2, _3]]
    // implicitly[Sum[_1, _2, _0]] // fails to compile
  }

}
