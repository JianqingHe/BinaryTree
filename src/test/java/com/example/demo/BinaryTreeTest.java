package com.example.demo;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历测试
 *
 * @author hejq
 * @date 2018-10-18 14:56
 */
public class BinaryTreeTest {

    /**
     * 前序遍历 （递归）
     *
     * @param node BinaryTreeNode
     */
    public void preTraversalRe(BinaryTreeNode node) {
        if (null != node) {
            System.out.println(node.getData() + "\n");
            preTraversalRe(node.getLeft());
            preTraversalRe(node.getRight());
        }
    }

    /**
     * 前序遍历 （非递归）
     *
     * @param node BinaryTreeNode
     */
    public void preTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while(true) {
            while (null != node) {
                System.out.println(node.getData() + "\n");
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            node = node.getRight();
        }
    }

    /**
     * 中序遍历 递归
     *
     * @param node BinaryTreeNode
     */
    public void inTraversalRe(BinaryTreeNode node) {
        if (null != node) {
            inTraversalRe(node.getLeft());
            System.out.println(node.getData() + "\n");
            inTraversalRe(node.getRight());
        }
    }

    /**
     * 中序遍历 非递归
     *
     * @param node BinaryTreeNode
     */
    public void inTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (null != node) {
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            System.out.println(node.getData() + "\n");
            node = node.getRight();
        }
    }

    /**
     * 后续遍历 递归
     *
     * @param node BinaryTreeNode
     */
    public void postTraversalRe(BinaryTreeNode node) {
        if (null != node) {
            postTraversalRe(node.getLeft());
            postTraversalRe(node.getRight());
            System.out.println(node.getData() + "\n");
        }
    }

    /**
     * 后续遍历 非递归
     *
     * @param node BinaryTreeNode
     */
    public void postTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            if (null != node) {
                stack.push(node);
                node = node.getLeft();
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                if (null == stack.lastElement().getRight()) {
                    node = stack.pop();
                    System.out.println(node.getData() + "\n");
                    while (node == stack.lastElement().getRight()) {
                        System.out.println(node.getRight() + "\n");
                        node = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }
                if (!stack.isEmpty()) {
                    node = stack.lastElement().getRight();
                } else {
                    node = null;
                }
            }
        }
    }

    /**
     * 层序遍历
     *
     * @param node BinaryTreeNode
     */
    public void levelTraversal(BinaryTreeNode node) {
        BinaryTreeNode treeNode;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            System.out.println(treeNode.getData() + "\n");
            if (null != treeNode.getLeft()) {
                queue.offer(treeNode.getLeft());
            }
            if (null != treeNode.getRight()) {
                queue.offer(treeNode.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, node10);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node8, node9);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        BinaryTreeTest tree = new BinaryTreeTest();

        System.out.println("---前序遍历-递归----");
        tree.preTraversalRe(node1);
        System.out.println("---前序遍历-非递归----");
        tree.preTraversal(node1);
        System.out.println();

        System.out.println("---中序遍历-递归----");
        tree.inTraversalRe(node1);
        System.out.println("---中序遍历-非递归----");
        tree.inTraversal(node1);
        System.out.println();

        System.out.println("---后序遍历-递归----");
        tree.postTraversalRe(node1);
        System.out.println("---后序遍历-非递归----");
        tree.postTraversal(node1);
        System.out.println();

        System.out.println("---层序遍历---");
        tree.levelTraversal(node1);
        System.out.println();
    }
}
