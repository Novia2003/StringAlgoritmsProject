package kr

fun gorner2Mod(s: IntArray, m: Int, q: Int): Int {
    var res = 0

    for (i in 0..<m) {
        res = (res * 2 + s[i]).mod(q)
    }

    return res
}

fun kr(p: String, t: String, q: Int) {
    val m = p.length
    val n = t.length
    var p2m = 1

    for (i in 0..<(m - 1)) {
        p2m = (p2m * 2).mod(q)
    }

    val hp = gorner2Mod(p.map { it.digitToInt() }.toIntArray(), m, q)
    var ht = gorner2Mod(t.map { it.digitToInt() }.toIntArray(), m, q)

    for (j in 0..(n-m)) {
        if (ht == hp) {
            var k = 0

            while (k < m && p[k] == t[j + k]) {
                k++
            }

            if (k == m) {
                println("Вхождение с позиции $j")
            }
        }

        ht = if (j + m != n) {
            ((ht - p2m * t[j].digitToInt()) * 2 + t[j + m].digitToInt()).mod(q)
        } else {
            ((ht - p2m * t[j].digitToInt()) * 2).mod(q)

        }

        if (ht < 0) {
            ht += q
        }
    }
}