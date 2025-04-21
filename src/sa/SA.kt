package sa

fun shiftAnd(pattern: String, text: String) {
    val m = pattern.length
    val n = text.length
    val chBeg = '0'
    val chEnd = 'z'
    val nA = chEnd - chBeg + 1


    val b = IntArray(nA) { 0 }
    for (j in 0..<m) {
        val charIndex = pattern[j] - chBeg
        b[charIndex] = b[charIndex] or (1 shl (m - 1 - j))
    }

    println("Битовая карта символов паттерна:")
    b.forEachIndexed { index, i ->
        println("${Char(index + chBeg.code)} ${Integer.toBinaryString(i).padStart(m, '0')} $i")
    }

    val uHigh = 1 shl (m - 1)
    var M = 0

    for (i in 0..<n) {
        val charIndex = text[i] - chBeg
        M = (M ushr 1 or uHigh) and (if (charIndex in b.indices) b[charIndex] else 0)

        if (M and 1 != 0) {
            println("Вхождение с позиции ${i - m + 1}")
        }
    }
}