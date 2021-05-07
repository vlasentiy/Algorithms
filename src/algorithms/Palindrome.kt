package algorithms

class Palindrome {
    //https://leetcode.com/problems/palindrome-number/
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x != 0) && (x % 10 == 0)) return false
        if (x < 10) return true
        var res: Int = x
        val list: ArrayList<Int> = ArrayList()

        while (res >= 10) {
            list.add(res % 10)
            res /= 10
        }
        list.add(res)

        val mid = list.size / 2 + 1
        list.forEachIndexed { index, i ->
            if (index < mid && index < (list.size - index - 1)) {
                if (list[index] != list[list.size - index - 1]) {
                    return false
                }
            }
        }

        return true
    }

    fun isPalindrome2(x: Int): Boolean {
        var res = x
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false
        }

        var revertedNumber = 0
        while (res > revertedNumber) {
            revertedNumber = revertedNumber * 10 + res % 10
            res /= 10
        }

        return res == revertedNumber || res == revertedNumber / 10
    }
}