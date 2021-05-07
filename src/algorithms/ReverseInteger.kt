package algorithms

class ReverseInteger {
    //https://leetcode.com/problems/reverse-integer/
    fun reverse(x: Int): Int {
        if (x >= Int.MAX_VALUE || x <= Int.MIN_VALUE) {
            return 0
        }
        var y = Math.abs(x)
        var result = 0
        var multiplier = 0
        val k = ArrayList<Int>()
        var check = 0.0
        while (y >= 10) {
            k.add(multiplier, y % 10)
            multiplier++
            y /= 10
        }
        k.add(multiplier, y)


        for (i: Int in k.indices) {
            val pow: Long = Math.pow(10.0, (k.size - (i + 1)).toDouble()).toLong()

            val r = k[i] * pow
            if (r - Int.MAX_VALUE >= 0) {
                return 0
            }
            result += r.toInt()
            check += r.toInt()
            if (check >= Int.MAX_VALUE) {
                return 0
            }
        }
        if (x < 0) {
            result *= -1
        }
        if (result <= Int.MIN_VALUE) {
            return 0
        }

        return result
    }

    fun reverse2(x: Int): Int {
        var x = x
        var res: Long = 0
        while (x != 0) {
            res = res * 10 + x % 10
            x /= 10
        }
        return if (res < Int.MIN_VALUE || res > Int.MAX_VALUE) {
            0
        } else {
            res.toInt()
        }
    }
}