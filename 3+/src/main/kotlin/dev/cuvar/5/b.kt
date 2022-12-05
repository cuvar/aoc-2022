package dev.cuvar.aoc

import java.io.File

fun main() {
  val filename = "input.txt"
  val file = File(filename)
  val lines = file.readLines()

  // format rearrangment instructions
  val rearrangementLines = lines.slice(10..lines.size -1)
  val rearrangements = rearrangementLines.map { it.replace("move ", "").replace(" from ", ",").replace(" to ", ",") }
  
  // format gamepad
  val stackLines = lines.slice(0..7)
  val stacks = Array(9) { mutableListOf<Char>() }

  val gamepad = stackLines.map { 
    var cratesPerLine = mutableListOf<Char>()
    for(i in 0..it.length) {
      if (i % 4 == 1) {
        cratesPerLine.add(it.get(i))
      }
    }
    return@map cratesPerLine
  }

  val gamepadReversed = gamepad.reversed()
  // println(gamepadReversed)

  for(i in 0..gamepadReversed.size -1) {
    for(j in 0..gamepadReversed[i].size-1) {
      if(gamepadReversed[i].get(j) != ' ') {
        stacks[j].add(gamepadReversed[i].get(j))
      }
    }
  }

  // for(i in 0..stacks.size -1) {
  //   for(j in 0..stacks[i].size-1) {
  //     print(stacks[i][j])
  //   }
  //   println("")
  // }
  
  // println("after")

  rearrangements.forEach {
    val instrutionInfo = it.split(",")
    val amount = instrutionInfo[0].toInt()
    val from = instrutionInfo[1].toInt() -1
    val to = instrutionInfo[2].toInt() -1 

    // println(instrutionInfo)
    val cratesToMove = stacks[from].takeLast(amount)
    
    for(i in 0..amount -1) {
      stacks[from].removeLast()
      stacks[to].add(cratesToMove[i])
      // print(stacks[from])
      // print(" -> ")
      // print(removed)
      // print(" -> ")
      // print(stacks[to])
      // println("")
    }
  }
  
  for(i in 0..stacks.size -1) {
    for(j in 0..stacks[i].size-1) {
      print(stacks[i][j])
    }
    println("")
  }


}

DCVTCVPCL