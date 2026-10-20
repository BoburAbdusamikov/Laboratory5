package task08

const val VAT_RATE = 0.12

inline val Double.withVat: Double
    get() = this * (1 + VAT_RATE)

val String.wordCount: Int
    inline get() = split(Regex("\\s+")).count { it.isNotBlank() }

inline val Int.kilobytes: Int
    get() = this * 1024

fun main() {
    print("Price without VAT: ")
    val price = readln().trim().toDoubleOrNull()
    if (price == null) {
        println("Not a number")
        return
    }
    println("Price with VAT: ${"%.2f".format(price.withVat)}")
    print("Write a sentence: ")
    val sentence = readln()
    println("Words: ${sentence.wordCount}")
    print("Number of kilobytes: ")
    val number = readln().trim().toIntOrNull()
    if (number == null) println("Not a whole number")
    else println("$number KB = ${number.kilobytes} bytes")
}
