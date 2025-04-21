import sa.shiftAnd

fun main() {
//    val s = "AABCAABXAAZ"
//    println(naiveZValues(s).joinToString(" "))
//    println(prefixZValues(s).joinToString(" "))

//    val t = "AABCAABXAAZ"
//    val p = "AAB"
//    println(getPrefixBorderArrayM(p, getPrefixBorderArray(p)).joinToString(" "))
//    println()
//    println(kmp(t, p))


//    val t = "110100111011110111"
//    val p = "1110"
//
//    kr(p, t, 7)
//
    val pattern = "abc"
    val text = "12d3abc4ab4c56abc789"

    shiftAnd(pattern, text)
}