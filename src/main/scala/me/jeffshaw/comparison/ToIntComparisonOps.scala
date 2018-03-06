package me.jeffshaw.comparison

trait ToIntComparisonOps {

  implicit def IntToIntComparisonOps(x: Int): IntComparisonOps =
    new IntComparisonOps(x)

}

object ToIntComparisonOps extends ToIntComparisonOps

/**
  * Provides operations for for short-circuiting aggregates of comparisons.
  */
class IntComparisonOps(val x: Int) extends AnyVal {

  /**
    * If the comparison is equal, short circuit. Otherwise, try the alternative comparison.
    */
  def ||(y: => Int): Int = {
    if (x == 0) {
      x
    } else {
      y
    }
  }

  /**
    * If the comparison is non-equal, short circuit. Otherwise, do the additional comparison.
    */
  def &&(y: => Int): Int = {
    if (x == 0) {
      y
    } else {
      x
    }
  }

}
