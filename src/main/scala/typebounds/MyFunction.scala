package typebounds

/**
 * A function of 1 parameter.
 *
 * @tparam T the type of the function parameter
 * @tparam R the return type of the function
 */
trait MyFunction1[T, R] {
  def apply(arg: T): R
}

/**
 * A function of 2 parameters.
 *
 * @tparam T1 the type of the first function parameter
 * @tparam T2 the type of the second function parameter
 * @tparam R the return type of the function
 */
trait MyFunction2[T1, T2, R] {
  def apply(arg1: T1, arg2: T2): R
}
