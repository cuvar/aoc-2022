package dev.cuvar.aoc

import java.io.File

fun main() {
  val filename = "input.txt"
  val file = File(filename)
  val lines = file.readLines()

  // map to array of strings split by comma
  val splittedLines = lines.map { it.split(",") }
  val filtered = splittedLines.filter { it ->
    val firstSections = it[0].split("-").map { it.toInt() }
    val secondSections = it[1].split("-").map { it.toInt() }

    val firstContainsSecond = firstSections[0] <= secondSections[0] && firstSections[1] >= secondSections[1]
    val secondContainsFirst = secondSections[0] <= firstSections[0] && secondSections[1] >= firstSections[1]
    return@filter firstContainsSecond || secondContainsFirst
  }
    
  println(filtered.size)

}


