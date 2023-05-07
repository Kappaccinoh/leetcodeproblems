# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @return {ListNode}
def detectCycle(head)
    slow = fast = head
    while slow && fast && fast.next
        slow = slow.next
        fast = fast.next.next
        
        if slow == fast
            slow = head
            while slow != fast # they have to meet at some point
                slow = slow.next
                fast = fast.next
            end
            return slow
        end
    end
    return nil
end