# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @return {Integer[][]}
def level_order(root)
    result = []
    return result if root.nil?
    inner_level_order(root, 0, result)
    result
end

def inner_level_order(root, level, result)
    result[level] ||= []
    result[level].append(root.val)
    if root.left != nil
        inner_level_order(root.left, level + 1, result) 
    end
    if root.right != nil
        inner_level_order(root.right, level + 1, result)
    end
end