package com.mark.algorithm.tree;

public class TreeNode<K, V> {
    public int height = 0;
    public K key = null;
    public V value = null;
    public TreeNode<K, V> left;
    public TreeNode<K, V> right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode(K key, V value, int height) {
        this.key = key;
        this.value = value;
        this.height = height;
    }

//    public boolean compare(TreeNode compare) {
//        return this.value.hashCode() - compare.value.hashCode() > 0;
//    }

    public int compare(K key) {
        int result = this.key.hashCode() - key.hashCode();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return key + ":" + height;
    }
}
