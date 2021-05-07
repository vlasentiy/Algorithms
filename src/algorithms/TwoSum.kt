package algorithms

class TwoSum {
    //https://leetcode.com/problems/two-sum/
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i: Int in nums.indices)
            for (j: Int in i + 1 until nums.size) {
                println("[${nums[i]};${nums[j]}]")
                if (nums[i] + nums[j] == target) {

                    return intArrayOf(i, j)
                }
            }

        throw IllegalArgumentException("No two sum solution")
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (i: Int in nums.indices) {
            map[nums[i]] = i
        }

        for (i: Int in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement) && map[complement] != i) {
                return intArrayOf(i, map[complement]!!)
            }
        }

        throw IllegalArgumentException("No two sum solution")
    }

    fun twoSum3(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i: Int in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(i, map[complement]!!)
            }
            map[nums[i]] = i
        }

        throw IllegalArgumentException("No two sum solution")
    }
}