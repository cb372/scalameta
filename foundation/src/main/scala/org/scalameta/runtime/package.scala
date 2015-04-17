package org.scalameta

import scala.runtime.ScalaRunTime

package object runtime {
  def arrayClass(clazz: Class[_], rank: Int): Class[_] = {
    Predef.require(rank > 0)
    if (rank == 1) ScalaRunTime.arrayClass(clazz)
    else arrayClass(ScalaRunTime.arrayClass(clazz), rank - 1)
  }
}