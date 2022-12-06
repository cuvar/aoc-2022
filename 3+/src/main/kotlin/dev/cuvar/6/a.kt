package dev.cuvar.aoc

import java.io.File

fun main() {
  val filename = "input.txt"
  val file = File(filename)
  val lines = file.readLines()

  val input = lines[0];
  print(input.length)
  var marker = -1
  for(i in 0..input.length - 4) {
    val chars = input.slice(i..i+3).toCharArray()
    val charSet = chars.toSet()

    if(charSet.size == chars.size) {
      marker = i
      break;
    }
  }

  println(marker + 4)
}
