package dev.cuvar.aoc

import java.io.File

fun main() {
  val filename = "input.txt"
  val file = File(filename)
  val lines = file.readLines()

  val input = lines[0];
  // println(input.length)
  var marker = -1
  val strLen = 14
  for(i in 0..input.length - strLen) {
    val chars = input.slice(i..i+strLen-1).toCharArray()
    val charSet = chars.toSet()

    if(charSet.size == chars.size) {
      marker = i
      break;
    }
  }

  println(marker + strLen)
}
