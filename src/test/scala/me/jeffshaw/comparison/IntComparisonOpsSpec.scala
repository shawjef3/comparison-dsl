package me.jeffshaw.comparison

import org.scalatest.FunSuite
import ToIntComparisonOps._

class IntComparisonOpsSpec extends FunSuite {

  test("or") {
    assertResult(0)(0 || 1)
    assertResult(-1)(1 || -1)
    assertResult(1)(-1 || 1)
  }

  test("or short circuits") {
    var shortCircuited = true
    def short: Int = {
      shortCircuited = true
      1
    }
    assertResult(0)(0 || short)
    assert(shortCircuited)
  }

  test("and") {
    assertResult(0)(0 && 0)
    assertResult(1)(0 && 1)
    assertResult(1)(1 && -1)
    assertResult(-1)(-1 && 1)
  }

  test("and short circuits") {
    var shortCircuited = true
    def short: Int = {
      shortCircuited = true
      0
    }
    assertResult(1)(1 && short)
    assert(shortCircuited)
  }

}
