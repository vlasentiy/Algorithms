package algorithms

class RemoveElement {
    // https://leetcode.com/problems/remove-element/

/*    Example 1:

    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2]
    Explanation: Your function should return length = 2,
    with the first two elements of nums being 2.
    It doesn't matter what you leave beyond the returned length.
    For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0],
    your answer will be accepted.

    Example 2:

    Input: nums = [0,1,2,2,3,0,4,2], val = 2
    Output: 5, nums = [0,1,4,0,3]
    Explanation: Your function should return length = 5,
    with the first five elements of nums containing 0, 1, 3, 0, and 4.
    Note that the order of those five elements can be arbitrary.
    It doesn't matter what values are set beyond the returned length.

    */

    fun removeElement0(nums: IntArray, value: Int): Int {
        if (nums.isEmpty()) return 0
        var index = -1
        var length = 0
        var reverseIndex = nums.size - 1
        for (i in nums.indices) {
            if (i < reverseIndex) {
                if (nums[i] == value) {
                    if (nums[reverseIndex] != value) {
                        val temp = nums[i]
                        nums[i] = nums[reverseIndex]
                        nums[reverseIndex] = temp

                        reverseIndex--
                    } else {

                    }
                }
            }
        }

            print("size: $reverseIndex | $length; ")
            nums.forEach { print("$it ") }
            println()

            return length
        }

    fun removeElement(nums: IntArray, value: Int): Int {
        if (nums.isEmpty()) return 0
        var index = -1
        var length = 0
        var reverseIndex = nums.size - 1
        for (i in nums.indices) {
            if (index != -1) {
                val temp = nums[i]
                nums[i] = nums[index]
                nums[index] = temp
                //length--

            }
            if (i < reverseIndex) {
                if (nums[i] == value) {
                    //length++
                    if (i != reverseIndex) {
                        if (nums[i] != nums[reverseIndex]) {
                            val temp = nums[i]
                            nums[i] = nums[reverseIndex]
                            nums[reverseIndex] = temp
                            //reverseIndex--
                        } else {
                            index = i
                        }
                    }

                }
            }
        }

        print("size: $reverseIndex | $length; ")
        nums.forEach { print("$it ") }
        println()

        return length
    }

    fun removeElement2(nums: IntArray, value: Int): Int {
        if (nums.isEmpty()) return 0
        var index = 0
        var length = 0
        var reverseIndex = nums.size - 1
        for (i in nums.indices) {
            if (reverseIndex <= i) {
                index--
                if (nums[i] != value) {
                    length++
                }
                break
            }
            if (nums[i] == value) {
                if (nums[reverseIndex] != value) {
                    val temp = nums[i]
                    nums[i] = nums[reverseIndex]
                    nums[reverseIndex] = temp

                } else {
                    index = i
                    reverseIndex--
                }
                length++
            } else {
                if (nums[reverseIndex] != value) {
                    val temp = nums[index]
                    nums[index] = nums[reverseIndex]
                    nums[reverseIndex] = temp
                    index++
                } else {
                    reverseIndex--
                }
                length++
            }
        }
        //index++
        if (length + index == 0) {
            length = 0
        }
        print("size: $index | $length; ")
        nums.forEach { print("$it ") }
        println()

        return length
    }
}