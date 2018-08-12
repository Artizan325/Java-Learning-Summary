package cn.edu.jxnu.leetcode.scala

import cn.edu.jxnu.leetcode.TreeNode
import scala.collection.mutable.Stack
import scala.collection.mutable.Seq
import scala.reflect.internal.util.Collections

/**
 * 树的遍历
 */
object DFS extends App {

    //前
    def qiandfs(root: TreeNode) {
        visit(root)
        qiandfs(root.left)
        qiandfs(root.right)
    }

    //中
    def zhongdfs(root: TreeNode) {
        zhongdfs(root.left)
        visit(root)
        zhongdfs(root.right)
    }

    //后
    def houdfs(root: TreeNode) {
        houdfs(root.left)
        houdfs(root.right)
        visit(root)
    }

    val visit = (root: TreeNode) => {
        println(root.value)
    }

    import util.control.Breaks._

    //前，144. Binary Tree Preorder Traversal (Medium)
    def preorderTraversal(root: TreeNode): Seq[Int] = {
        val ret = Seq[Int]()
        val stack = Stack[TreeNode]()
        stack.push(root)
        while (!stack.isEmpty) {
            val node = stack.pop()
            breakable {
                if (node == null) break
            }
            ret.:+(node.value)
            stack.push(node.right) // 先右后左，保证左子树先遍历
            stack.push(node.left)
        }
        return ret
    }
    //中， 94. Binary Tree Inorder Traversal (Medium)
    def inorderTraversal(root: TreeNode): Seq[Int] = {
        val ret = Seq[Int]()
        val stack = Stack[TreeNode]()
        if (root == null) return ret
        var cur = root
        while (cur != null || !stack.isEmpty) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            val node = stack.pop()
            ret.:+(node.value)
            cur = node.right
        }
        ret
    }

    /**
     * [因为是栈，先左子树出栈，后右子树出栈]
     * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
     */
    //后，145. Binary Tree Postorder Traversal (Medium)
    def postorderTraversal(root: TreeNode): Seq[Int] = {
        val ret = Seq[Int]()
        val stack = Stack[TreeNode]()
        stack.push(root)
        while (!stack.isEmpty) {
            val node = stack.pop()
            breakable {
                if (node == null) break
            }
            ret.:+(node.value)
            stack.push(node.left) // 先右后左，保证左子树先遍历
            stack.push(node.right)
        }
        ret.reverse
    }

}