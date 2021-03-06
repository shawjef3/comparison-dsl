package me.jeffshaw.comparison

import scala.language.implicitConversions

trait ToIntComparisonOps {

  implicit def IntToIntComparisonOps(x: Int): IntComparisonOps =
    new IntComparisonOps(x)

}

object ToIntComparisonOps extends ToIntComparisonOps

/**
  * Provides operations for for creating short-circuited aggregates of comparisons. Import
  * the contents of [[ToIntComparisonOps$]] to add `||` and `&&` to [[Int]].
  *
  * It's best to construct your aggregate comparison using expressions, `def`s, or `lazy val`s.
  * `val`s are okay, but if you're only using them for the overall comparison, then it's possible
  * you will perform an unnecessary comparison.
  *
  * For instance, in the following, only the first expression will be evaluated, since its terms are equal.
  *
  * {{{
  *   1.compareTo(1) || 1.compareTo(2)
  * }}}
  *
  * If the parts are factored into `defs` or `lazy val`s, the second one is still not evaluated.
  *
  * {{{
  *   def first = 1.compareTo(1)
  *   def second = 1.compareTo(2)
  *   first || second
  * }}}
  *
  * However, if the parts are factored into `val`s, then they are both evaluated, even though the second one
  * is unused.
  *
  * {{{
  *   val first = 1.compareTo(1)
  *   val second = 1.compareTo(2)
  *   first || second
  * }}}
  *
  * Using a `lazy val` is good for preventing a comparison from being performed more than once.
  *
  * {{{
  *   import me.jeffshaw.comparison.ToLazyIntComparisonOps._
  *   def c0: Int = ???
  *   lazy val c1: Int = ???
  *   def c2: Int = ???
  *   def c3: Int = ???
  *   c0 || (c1 && c2) || (c1 && c3)
  * }}}
  *
  * which can be simplified to
  *
  * {{{
  *   import me.jeffshaw.comparison.ToLazyIntComparisonOps._
  *   def c0: Int = ???
  *   def c1: Int = ???
  *   def c2: Int = ???
  *   def c3: Int = ???
  *   c0 || (c1 && (c2 || c3))
  * }}}
  *
  * but maybe in some cases the first would be easier to reason about.
  *
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
