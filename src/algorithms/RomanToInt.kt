package algorithms

class RomanToInt {
    //https://leetcode.com/problems/palindrome-number/

    //Input: "MCMXCIV"
    //Output: 1994
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    fun romanToInt(s: String): Int {
        var result = 0
        val charArray = s.toCharArray()
        var prev = 0

        for (x: Int in charArray.indices) {
            var fromLetter = getNumberFromLetter(charArray[charArray.size - x - 1])
            if (fromLetter < prev) {
                prev = fromLetter
                fromLetter *= -1
            }else{
                prev = fromLetter
            }
            result += fromLetter
        }

        return result
    }

    private fun getNumberFromLetter(c: Char): Int {
        return when (c) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}