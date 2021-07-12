package me.jeffshaw.comparison

import org.scalatest.funsuite.AnyFunSuite
import ToIntComparisonOps._

class IntComparisonOpsSpec extends AnyFunSuite {

  test("or") {
    assertResult(0)(0 || 1)
    assertResult(-1)(1 || -1)
    assertResult(1)(-1 || 1)
  }

  test("or short circuits") {
    var secondExecuted = false
    def short: Int = {
      secondExecuted = true
      1
    }
    assert(!secondExecuted)
    assertResult(0)(0 || short)
    assert(!secondExecuted)
  }

  test("and") {
    assertResult(0)(0 && 0)
    assertResult(1)(0 && 1)
    assertResult(1)(1 && -1)
    assertResult(-1)(-1 && 1)
  }

  test("and short circuits") {
    var secondExecuted = false
    def short: Int = {
      secondExecuted = true
      0
    }
    assert(!secondExecuted)
    assertResult(1)(1 && short)
    assert(!secondExecuted)
  }

}
