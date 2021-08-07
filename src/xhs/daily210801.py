#!usr/bin/python3

'''
    Asked by LinkedIn recently.
    Given a binary tree, find the minimum depth of the tree.
    The minimun depth is the shortest distance from the root to a leave.
'''

class Node:
    def __init__(self, value, left=None, right=None):
        #<span style="color: #3465a4">
        self.value = value
        self.left = left
        self.right = right

def min_depth_bst(root):
    # Fill this in.
    pass
    if root.left is None and root.right is None:
        return 0
    elif root.left is not None and root.right is None:
        return min_depth_bst(root.left) + 1
    elif root.right is not None and root.left is None:
        return min_depth_bst(root.right) + 1
    else:
        return min(min_depth_bst(root.left)+1, min_depth_bst(root.right)+1)

n6 = Node(6, None, Node(7))
n4 = Node(4, Node(8), Node(9))
n3 = Node(3, None, Node(4))
n2 = Node(2, Node(5), n6)
n1 = Node(1, n2, n3)
# n3 = Node(3, None, Node(4))
# n1 = Node(1, Node(2), n3)
print(min_depth_bst(n1))
# 2