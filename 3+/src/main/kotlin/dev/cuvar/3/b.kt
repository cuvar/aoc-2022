package dev.cuvar.aoc

import java.io.File

fun main() {
  val filename = "input.txt"
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

  val file = File(filename)
  val lines = file.readLines()
  var sameChars = ArrayList<Char>()

  // var groups = ArrayList<String>() // hard coded
  var skipLine = 0;
  for (j in 0..lines.size - 3) {
    if(skipLine > 0) {
      skipLine--
      continue;
    }
    val samechar = checkSameChar(lines[j], lines[j+1], lines[j+2])
    skipLine = 2
    sameChars.add(samechar)

    // println("------------")
    // println(lines[j])
    // println(lines[j+1])
    // println(lines[j+2])
    // println(samechar)
  }

  println(sameChars.size)
  
  // if(sameChars.size != lines.size) {
  //   println(sameChars.size)
  //   println(lines.size)
  //   println("error")
  //   return
  // }

  // println("sameChars")
  // println(sameChars)

  // todo: later
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

fun checkSameChar(a: String, b: String, c:String): Char {
  var sameChar = ' '
  // for (i in 0..a.length - 1) {
  //   for (j in 0..b.length - 1) {
  //   // if(a[i] == b[i] && a[i] == c[i]) {
  //   //   sameChar = a[i]
  //   //   break;
  //   // }
  //   }
  // }

  var canContinue = false
    for(charA in a) {
      for(charB in b) {
        if(canContinue) {
          break
        }
        if (charA == charB) {
          for(charC in c) {
            if(canContinue) {
              break
            }
            if(charA == charC) {
              sameChar = charA
              canContinue = true
              continue;
            }
          }
        }
      }
    }

  return sameChar
}



