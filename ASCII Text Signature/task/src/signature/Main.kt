package signature

import java.io.File
import java.util.*

fun parseFont(path: String, spaceLength: Int): Array<Array<String>> {
    val scanner = Scanner(File(path))

    val linesInLetter = scanner.nextInt()
    scanner.nextLine()
    val lettersLines = Array(linesInLetter) { Array(53) { "" } }

    for (letterIndex in 0 until 52) {
        scanner.nextLine()
        for (lettersLine in lettersLines) {
            lettersLine[letterIndex] = scanner.nextLine()
        }
    }

    for (lettersLine in lettersLines) {
        repeat(spaceLength) {
            lettersLine[52] += " "
        }
    }

    return lettersLines
}

fun getStringLinesWithFont(string: String, font: Array<Array<String>>): Array<String> {
    val stringLines = Array(font.size) { "" }

    for (letter in string) {
        for (lineIndex in font.indices) {
            stringLines[lineIndex] += font[lineIndex][when {
                letter == ' ' -> 52
                letter.isLowerCase() -> letter - 'a'
                else -> letter - 'A' + 26
            }]
        }
    }

    return stringLines
}

fun printLine(line: String, size: Int) {
    val totalSpaces = if (size > line.length) size - line.length else 0
    val leftSpaces = totalSpaces / 2
    val rightSpaces = if (totalSpaces == 0) 0 else (totalSpaces - 1) / 2 + 1

    print("88  ")
    repeat(leftSpaces) {
        print(' ')
    }
    print(line)
    repeat(rightSpaces) {
        print(' ')
    }
    println("  88")
}

fun printLineWithCharacters(character: Char, size: Int) {
    repeat(size) {
        print(character)
    }
    println()
}

fun main() {
    val scanner = Scanner(System.`in`)
    val romanFont = parseFont("/home/nikita/Projects/IdeaProjects/ASCII Text Signature/font/roman.txt", 10)
    val mediumFont = parseFont("/home/nikita/Projects/IdeaProjects/ASCII Text Signature/font/medium.txt", 5)

    val nameLines = getStringLinesWithFont(scanner.nextLine(), romanFont)
    val statusLines = getStringLinesWithFont(scanner.nextLine(), mediumFont)

    val tagLength = if (statusLines[0].length > nameLines[0].length) statusLines[0].length else nameLines[0].length

    printLineWithCharacters('8', tagLength + 8)
    for (i in nameLines) {
        printLine(i, tagLength)
    }
    for (i in statusLines) {
        printLine(i, tagLength)
    }
    printLineWithCharacters('8', tagLength + 8)
}
