package pb

fun getPrefixBorderArray(s: String): IntArray {
    val n = s.length
    val bp = IntArray(n)
    bp[0] = 0

    for (i in 1..<n) {
        var bpRight = bp[i - 1]

        while (bpRight > 0 && (s[i] != s[bpRight])) {
            bpRight = bp[bpRight - 1]
        }

        if (s[i] == s[bpRight]) {
            bp[i] = bpRight + 1
        } else {
            bp[i] = 0
        }
    }

    return bp
}

fun getPrefixBorderArrayM(s: String, bp: IntArray): IntArray {
    val n = s.length
    val bpm = IntArray(n)

    bpm[0] = 0
    bpm[n - 1] = bp[n - 1]

    for (i in 1..<n - 1) {
        if (bp[i] > 0 && (s[bp[i]] == s[i + 1])) {
            bpm[i] = bpm[bp[i] - 1]
        } else {
            bpm[i] = bp[i]
        }
    }

    return bpm
}

fun bpToBpm(bp: IntArray): IntArray {
    val n = bp.size
    val bpm = IntArray(n)

    bpm[0] = 0
    bpm[n - 1] = bp[n - 1]

    for (i in 1..<n - 1) {
        if (bp[i] > 0 && (bp[i] + 1 == bp[i + 1])) {
            bpm[i] = bpm[bp[i] - 1]
        } else {
            bpm[i] = bp[i]
        }
    }

    return bpm
}