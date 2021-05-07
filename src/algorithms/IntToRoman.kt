package algorithms

import java.lang.StringBuilder


class IntToRoman {
    //https://leetcode.com/problems/integer-to-roman/

    private var romanList: ArrayList<ArrayList<Pair<Int, String>>> = arrayListOf(
        arrayListOf(
            Pair(1, "I"),
            Pair(2, "II"),
            Pair(3, "III"),
            Pair(4, "IV"),
            Pair(4, "V"),
            Pair(6, "VI"),
            Pair(7, "VII"),
            Pair(8, "VIII"),
            Pair(9, "IX")
        ),
        arrayListOf(
            Pair(10, "X"),
            Pair(20, "XX"),
            Pair(30, "XXX"),
            Pair(40, "XL"),
            Pair(50, "L"),
            Pair(60, "LX"),
            Pair(70, "LXX"),
            Pair(80, "LXXX"),
            Pair(90, "XC")
        ),
        arrayListOf(
            Pair(100, "C"),
            Pair(200, "CC"),
            Pair(300, "CCC"),
            Pair(400, "CD"),
            Pair(500, "D"),
            Pair(600, "DC"),
            Pair(700, "DCC"),
            Pair(800, "DCCC"),
            Pair(900, "CM")
        ),
        arrayListOf(Pair(1000, "M"), Pair(2000, "MM"), Pair(3000, "MMM"), Pair(4000, "MMMM"))
    )

    fun intToRoman(num: Int): String {
        val result = StringBuilder()
        var number = num
        var multi = 1.0

        while (number > 0) {
            val q = number % Math.pow(10.0, multi)
            multi++
            if (q > 0) {
                result.insert(0, getRomanFromNumber(q.toInt(), multi.toInt() - 1))
                number -= q.toInt()
            }
        }

        return result.toString()
    }

    private fun getRomanFromNumber(number: Int, multi: Int): String {
        val pair = romanList[multi - 1].first { it.first == number }
        return pair.second
    }

    //OLD

    private var pairList: ArrayList<Pair<Int, String>> = arrayListOf(
        Pair(1, "I"),
        Pair(5, "V"),
        Pair(10, "X"),
        Pair(50, "L"),
        Pair(100, "C"),
        Pair(500, "D"),
        Pair(1000, "M"),
        Pair(4001, "")
    )

    fun intToRomanOld(num: Int): String {
        val result = StringBuilder()
        var number = num
        var multi = 1.0

        while (number > 0) {
            val q = number % Math.pow(10.0, multi)
            multi++
            if (q > 0) {
                result.insert(0, getStringFromNumber(q.toInt()))
                number -= q.toInt()
            } else {
                result.insert(0, getStringFromNumber(number))
                number = 0
            }
        }

        return result.toString()
    }

    private fun getStringFromNumber(num: Int): String {
        var min = pairList[0]
        var index = 0
        var result = ""

        for (i: Int in 1 until pairList.size) {
            if (num >= pairList[i].first && num < pairList[i + 1].first) {
                min = pairList[i]
                index = i
                break
            }
        }

        var x = min.first
        result += min.second

        while (x != num) {
            if (num == pairList[index].first) {
                return pairList[index].second
            } else if (num == pairList[index + 1].first - pairList[index].first) {
                return "${pairList[index].second}${pairList[index + 1].second}"
            } else if (index > 0 && num == pairList[index + 1].first - pairList[index - 1].first) {
                return "${pairList[index - 1].second}${pairList[index + 1].second}"
            } else {

                val index2 =
                    if (pairList[index + 1].first - pairList[index].first == pairList[index].first) index - 1 else index

                x += pairList[index2].first
                result += pairList[index2].second
            }
        }

        return result
    }

}