package algorithms

class LongestCommonPrefix {
    //https://leetcode.com/problems/longest-common-prefix/
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        if (strs.isNullOrEmpty()) return result
        var check = true
        var position = 0
        while (check) {
            if (position >= strs[0].length) return result
            val c = strs[0][position]
            strs.forEach {
                if (!check) {
                    return result
                }
                if (it.length < position + 1) {
                    check = false
                    return result
                }
                if (it[position] != c) {
                    check = false
                }
            }
            if (check) {
                result += c
            }
            position++
        }

        return result
    }

    fun longestCommonPrefix2(strs: Array<String>?): String? {
        if (strs == null || strs.isEmpty()) return ""
        for (i in strs[0].indices) {
            val c = strs[0][i]
            for (j in 1 until strs.size) {
                if (i == strs[j].length || strs[j][i] != c) return strs[0]
                    .substring(0, i)
            }
        }
        return strs[0]
    }
}