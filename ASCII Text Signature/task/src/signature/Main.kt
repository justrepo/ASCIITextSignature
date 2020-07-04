package signature

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val font = "____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _\n" +
            "|__| |__] |    |  \\ |___ |___ | __ |__| |  | |_/  |    |\\/|\n" +
            "|  | |__] |___ |__/ |___ |    |__] |  | | _| | \\_ |___ |  |\n" +
            "_  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___ \n" +
            "|\\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \\/   \\_/    / \n" +
            "| \\| |__| |    |_\\| |  \\ ___]  |  |__|  \\/  |_|_| _/\\_   |    /__"

    val fontLines = font.split('\n')
    val concatenatedFontLines = Array<String>(3) { "" }

    var currentLine = 0
    for (line in fontLines) {
        concatenatedFontLines[currentLine] += "$line "
        ++currentLine
        if (currentLine == 3) {
            currentLine = 0
        }
    }

    val lettersLines = Array(3) { Array(26) { "" } }

    var currentLetter = 0
    for (i in concatenatedFontLines[0].indices) {
        for (j in 0..2) {
            lettersLines[j][currentLetter] = lettersLines[j][currentLetter] + concatenatedFontLines[j][i]
        }
        if (concatenatedFontLines[0][i] == ' ' && concatenatedFontLines[1][i] == ' ' && concatenatedFontLines[2][i] == ' ') {
            ++currentLetter
        }
    }

    val name = scanner.nextLine()
    val nameLines = Array(3) { "" }
    for (l in name) {
        for (i in lettersLines.indices) {
            if (l == ' ') {
                nameLines[i] += "     "
            } else {
                nameLines[i] += lettersLines[i][l.toLowerCase() - 'a']
            }
        }
    }

    val status = scanner.nextLine() + " "
    val tagLength = if (status.length > nameLines[0].length) status.length else nameLines[0].length


    repeat(tagLength + 1 + 2 + 1 + 1) {
        print('*')
    }
    println()
    for (i in nameLines) {
        print("*  ")
        if (tagLength > i.length) {
            repeat((tagLength - i.length) / 2) {
                print(' ')
            }
        }
        print(i)
        if (tagLength > i.length) {
            repeat((tagLength - i.length - 1) / 2 + 1) {
                print(' ')
            }
        }
        println(" *")
    }

    print("*  ")
    if (tagLength > status.length) {
        repeat((tagLength - status.length) / 2) {
            print(' ')
        }
    }
    print(status)
    if (tagLength > status.length) {
        repeat((tagLength - status.length - 1) / 2 + 1) {
            print(' ')
        }
    }
    println(" *")

    repeat(tagLength + 1 + 2 + 1 + 1) {
        print('*')
    }
    println()
}
