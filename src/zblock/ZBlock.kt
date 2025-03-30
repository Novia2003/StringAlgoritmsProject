package zblock

fun naiveZValues(s: String): IntArray {
    val n = s.length

    val zp = IntArray(n)
    zp[0] = 0

    for (i in 1..<n) {
        var j = i

        while (j < n && s[j] == s[j - i]) {
            j++
        }

        zp[i] = j - i
    }

    return zp
}

fun prefixZValues(s: String): IntArray {
    val n = s.length
    val zp = IntArray(n)

    var l = 0
    var r = 0
    zp[0] = 0

    for (i in 1..<n) {
        zp[i] = 0

        if (i >= r) {
            zp[i] = strComp(s, n, 0, i)
            l = i
            r = l + zp[i]
        } else {
            val j = i - l

            if (zp[j] < r - i) {
                zp[i] = zp[j]
            } else {
                zp[i] = r - i + strComp(s, n, r - i, r)
                l = i
                r = l + zp[i]
            }
        }
    }

    return zp
}

private fun strComp(s: String, n: Int, i1: Int, i2: Int): Int {
    var eqLen = 0

    var index1 = i1
    var index2 = i2

    while (index1 < n && index2 < n && s[index1++] == s[index2++]) {
        eqLen++
    }

    return eqLen
}