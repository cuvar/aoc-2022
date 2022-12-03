package dev.cuvar.aoc

import java.io.File

// Lowercase item types a through z have priorities 1 through 26.
// Uppercase item types A through Z have priorities 27 through 52.

fun generatePriorities():HashMap<Char, Int> {
  val prioMap = HashMap<Char, Int>()
  
  var i = 1;
  for (chars in 'a'..'z') {
    prioMap[chars] = i
    i++;
  }
  for (chars in 'A'..'Z') {
    prioMap[chars] = i
    i++;
  }
  
  return prioMap
}


fun main() {
  val filename = "input.txt"
  val prioMap = generatePriorities();
  // println(prioMap)

  val file = File(filename)
  val lines = file.readLines()
  // var sameChars = CharArray(lines.size)
  // var sameChars = arrayOf<Char>()
  var sameChars = ArrayList<Char>()

  for (line in lines) {
    val substr1 = line.substring(0, line.length / 2)
    val substr2 = line.substring(line.length / 2, line.length)
    
    var canContinue = false
    for(charA in substr1) {
      for(charB in substr2) {
        if(canContinue) {
          break
        }
        if (charA == charB) {
          sameChars.add(charA)
          canContinue = true
          continue;
        }
      }
    }
  }
  
  
  if(sameChars.size != lines.size) {
    println(sameChars.size)
    println(lines.size)
    println("error")
    return
  }

  println("sameChars")
  println(sameChars)

  var prioSum = 0
  for(char in sameChars) {
    if(!prioMap.containsKey(char)) {
      print("missing prio key")
      return
    }
    // prioSum += prioMap[char]!!
    prioMap[char]?.let { prioSum += it }
    
  }
  println(prioSum)


}




