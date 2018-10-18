package com.example.demo;

/**
 * 二叉树
 *
 * @author hejq
 * @date 2018-10-18 14:49
 */
public class BinaryTreeNode {

    /**
     * 值
     */
    private int data;

    /**
     * 左节点
     */
    private BinaryTreeNode left;

    /**
     * 右节点
     */
    private BinaryTreeNode right;

    public BinaryTreeNode() {}

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        super();
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
