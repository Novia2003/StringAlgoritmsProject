import kmp.kmp
import pb.getPrefixBorderArray
import pb.getPrefixBorderArrayM
import zblock.naiveZValues
import zblock.prefixZValues

fun main() {
//    val s = "AABCAABXAAZ"
//    println(naiveZValues(s).joinToString(" "))
//    println(prefixZValues(s).joinToString(" "))

    val t = "AABCAABXAAZ"
    val p = "AAB"
//    println(getPrefixBorderArrayM(p, getPrefixBorderArray(p)).joinToString(" "))
//    println()
    println(kmp(t, p))
}