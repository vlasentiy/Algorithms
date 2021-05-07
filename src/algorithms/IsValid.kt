package algorithms

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class IsValid {
    //https://leetcode.com/problems/valid-parentheses/
    fun isValid(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length % 2 == 1) {
            return false
        }
        var subStringStart = -1
        var subStringEnd = -1
        for (l in 0 until s.length / 2) {
            val c1 = s[s.length - l - 1] - 1
            val c2 = c1 - 1
            if (s[l] == c1 || s[l] == c2) {
                subStringStart = l - 1
                subStringEnd = s.length - l + 1
            } else {
                break
            }
        }

        var s2 = s
        if (subStringStart != -1) {
            s2 = s.substring(subStringStart, subStringEnd)
        }


        val list = ArrayList<Pair<Int, Int>>()
        for (j in s2.indices) {
            var jump = 0
            loop@ for (k: Int in (j + 1) until s2.length) {

                val c1 = s2[k] - 1
                val c2 = c1 - 1

                if (s2[j] == s2[k]) {
                    jump++
                }
                if ((s2[j] == c1 || s2[j] == c2)) {
                    if (jump == 0) {
                        list.add(Pair(j, k))
                        break@loop
                    } else {
                        jump--
                    }
                }
            }
        }

        if (list.size < s2.length / 2) {
            return false
        }
        list.removeIf { it.second - it.first == 1 }

        for (i: Int in list.indices)
            for (j: Int in i + 1 until list.size) {
                if (list[i].second > list[j].first && list[i].first < list[j].first && list[i].second < list[j].second) {
                    return false
                }
            }

        return true
    }

    fun isValid2(s:String): Boolean{
        val mappings: MutableMap<Char, Char> = HashMap()

        mappings['('] = ')'
        mappings['['] = ']'
        mappings['{'] = '}'

        val parenthesis: Stack<Char?> = Stack()
        for (i in s.indices) {
            val c: Char = s[i]
            if (mappings.containsKey(c)) {
                parenthesis.push(mappings[c])
            } else if (mappings.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() !== c) {
                    return false
                }
            }
        }
        return parenthesis.isEmpty()
    }
}