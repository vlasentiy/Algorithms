package algorithms

class RemoveDuplicatesFromSortedArray {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    /*Example 1:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2]
    Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.

    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]

    Output: 5, nums = [0,1,2,3,4]
    Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
    */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var index = 0
        var current: Int? = null
        var length = 0

        for (i in 1 until nums.size) {
            if (nums[i] == nums[index] || nums[i] == nums[i - 1]) {
                if (nums[i] != current) {
                    index = i
                    current = nums[i]
                }
            } else if (current != null && nums[i] > current) {
                length = index
                val temp = nums[index]
                nums[index] = nums[i]
                nums[i] = temp
                current = nums[index]
                index++
            } else if (nums[i] != nums[length]) {
                length = i
            }
        }
        length++
        ////
        print("size: $length | ")
        nums.forEach { print("$it ") }
        println()
        ////
        return length
    }

    fun removeDuplicates2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 0
        for (j in 1 until nums.size) {
            if (nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1
    }
}