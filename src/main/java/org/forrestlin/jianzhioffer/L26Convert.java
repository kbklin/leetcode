package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二叉搜索树与双向链表
 * @author: forrestlin
 * @create: 2019-11-14 18:12
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class L26Convert {

    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.right);
        if (pre == null) {
            pre = pRootOfTree;
        } else {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return pre;
    }
}
