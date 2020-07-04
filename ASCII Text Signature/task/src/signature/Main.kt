package signature

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val name = scanner.nextLine()
    repeat(name.length + 4) {
        print("*")
    }
    println("\n* $name *")
    repeat(name.length + 4) {
        print("*")
    }
    println()
}
