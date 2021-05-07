package algorithms

class MergeTwoSortedLists {
    //https://leetcode.com/problems/merge-two-sorted-lists/
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return l1
        }
        if (l1 == null) {
            return l2!!
        } else if (l2 == null) {
            return l1
        }

        var node1: ListNode = if (l1.`val` <= l2.`val`) l1 else l2
        var node2: ListNode = if (l1.`val` > l2.`val`) l1 else l2

        var startNode1: ListNode? = node1
        var startNode2: ListNode? = node2

        var tail1: ListNode? = node1
        var tail2: ListNode? = node2

        do {
            if (node1.`val` <= node2.`val` && (node1.next != null && node1.next?.`val`!! >= node2.`val`)) {
                tail1 = node1.next
                tail2 = node2.next

                node1.next = node2
                node2.next = tail1

                if (startNode1 == null || startNode2 == null) {
                    startNode1 = node1
                    startNode2 = tail2
                }
                node1 = node1.next!!
                if (tail2 != null) {
                    node2 = tail2
                }
            } else if (node1.next != null) {
                node1 = node1.next!!
            } else if (tail1?.next == null && tail1?.`val`!! <= tail2?.`val`!!) {
                tail1.next = tail2
                break
            } else {
                node1.next = node2
                break
            }

            val hasTail = (tail1 != null && tail2 != null)

        } while (hasTail)

        return startNode1!!
    }

    fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }

    class ListNode(
        var `val`: Int,
        var next: ListNode? = null
    )
}