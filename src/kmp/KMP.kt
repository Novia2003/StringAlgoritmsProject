package kmp

import pb.bpToBpm
import pb.getPrefixBorderArray

fun kmp(t: String, p:String) {
    val bp = getPrefixBorderArray(p)

    val m = p.length
    val n = t.length

    val bpm = bpToBpm(bp)

    var k = 0

    for (i in 0..<n) {
        while (k > 0 && p[k] != t[i]) {
            k = bpm[k - 1]
        }

        if (p[k] == t[i]) {
            k++
        }

        if (k == m) {
            println("Вхождение с позиции " + (i - k + 1))
            k = bpm[k - 1]
        }
    }
}