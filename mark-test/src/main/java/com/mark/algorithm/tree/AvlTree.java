package com.mark.algorithm.tree;

public class AvlTree<K, V> {

    TreeNode<K, V> root = null;
    int length = 0;

    public static void main(String[] args) {
        TreeNode[][] container = null;
        try {
            AvlTree<Integer, String> avlTree = new AvlTree();
            for (int i = 0; i < 31; i++) {
                int random = new Double(Math.random() * 1000).intValue();
                avlTree.add(random, i + "");
            }
            container = new TreeNode[new Double(Math.pow(2, avlTree.root.height)).intValue()][avlTree.root.height];
            AvlTree.printTree(container, avlTree);
            System.out.println(avlTree.contain(1));
            System.out.println(avlTree.contain(2));
            avlTree.remove(avlTree.root.key);
            container = new TreeNode[new Double(Math.pow(2, avlTree.root.height)).intValue()][avlTree.root.height];

            AvlTree.printTree(container, avlTree);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public TreeNode add(K key, V value) {
        this.root = add(root, key, value);
        return this.root;
    }

    public TreeNode remove(K key) {
        return root = remove(root, key);
    }

    public TreeNode contain(K key) {
        return contain(root, key);
    }

    public int size() {
        return length;
    }

    private static <K, V> void printTree(TreeNode[][] container, AvlTree avlTree) {
        avlTree.layerorder(avlTree.root, container, (new Double(Math.pow(2, avlTree.root.height - 1)).intValue()), 0);
        for (TreeNode[] nodes : container) {
            for (TreeNode node : nodes) {
                System.out.print((node == null ? " " : node) + "\t");
            }
            System.out.println();
        }
    }

    private TreeNode add(TreeNode<K, V> treeNode, K key, V value) {
        if (treeNode == null) {
            length++;
            return new TreeNode<K, V>(key, value, 1);
        }
        if (treeNode.compare(key) == 1) {
            treeNode.left = add(treeNode.left, key, value);
            treeNode = leftRotation(treeNode, key);
        } else if (treeNode.compare(key) == -1) {
            treeNode.right = add(treeNode.right, key, value);
            treeNode = rightRotation(treeNode, key);
        } else {
            //替换
            treeNode.value = value;
            //用旧的
            //报错
        }
        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        return treeNode;
    }

    private TreeNode<K, V> rightRotation(TreeNode<K, V> treeNode, K key) {
        if (height(treeNode.right) - height(treeNode.left) == 2) {
            if (treeNode.right.compare(key) == -1) {
                treeNode = singleRightRotation(treeNode);
            } else {
                treeNode = doubleRightRotation(treeNode);
            }
        }
        return treeNode;
    }

    private TreeNode<K, V> leftRotation(TreeNode<K, V> treeNode, K key) {
        if (height(treeNode.left) - height(treeNode.right) == 2) {
            if (treeNode.left.compare(key) == 1) {
                treeNode = singleLeftRotation(treeNode);
            } else {
                treeNode = doubleLeftRotation(treeNode);
            }
        }
        return treeNode;
    }

    private TreeNode contain(TreeNode<K, V> treeNode, K key) {
        TreeNode result = null;
        if (treeNode != null && key != null) {
            if (key == treeNode.key) {
                return treeNode;
            } else {
                result = contain(treeNode.left, key);
                if (result == null) {
                    result = contain(treeNode.left, key);
                }
                return result;
            }
        }
        return null;
    }


    private TreeNode remove(TreeNode<K, V> treeNode, K key) {
        if (treeNode == null || key == null) {
            return null;
        }
        if (treeNode.compare(key) == 1) {
            treeNode.left = remove(treeNode.left, key);
            if (treeNode != null) {
                treeNode = rightRotation(treeNode, key);
            }
        } else if (treeNode.compare(key) == -1) {
            treeNode.right = remove(treeNode.right, key);
            if (treeNode != null) {
                treeNode = leftRotation(treeNode, key);
            }
        } else {
            length--;
            if (treeNode.left != null && treeNode.right != null) {
                if (height(treeNode.left) > height(treeNode.right)) {
                    TreeNode<K, V> max = max(treeNode.left);
                    treeNode.value = max.value;
                    treeNode.value = max.value;
                    treeNode.left = remove(treeNode.left, max.key);
                } else {
                    TreeNode<K, V> min = min(treeNode.right);
                    treeNode.key = min.key;
                    treeNode.value = min.value;
                    treeNode.right = remove(treeNode.right, min.key);

                }
            } else if (treeNode.left == null && treeNode.right == null) {
                return null;
            } else {
                treeNode = treeNode.left != null ? treeNode.left : treeNode.right;
            }
        }
        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        return treeNode;
    }

    private TreeNode<K, V> min(TreeNode<K, V> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode max(TreeNode<K, V> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode doubleLeftRotation(TreeNode treeNode) {
        treeNode.left = singleRightRotation(treeNode.left);
        return singleLeftRotation(treeNode);
    }

    private TreeNode doubleRightRotation(TreeNode treeNode) {
        treeNode.right = singleLeftRotation(treeNode.right);
        return singleRightRotation(treeNode);
    }

    private TreeNode singleLeftRotation(TreeNode treeNode) {
        TreeNode temp = treeNode.left;
        treeNode.left = temp.right;
        temp.right = treeNode;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        return temp;
    }

    private TreeNode singleRightRotation(TreeNode treeNode) {
        TreeNode temp = treeNode.right;
        treeNode.right = temp.left;
        temp.left = treeNode;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        return temp;
    }

    private int height(TreeNode node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            System.out.println(root.key);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.println(root.key);
        }
    }

    public void layerorder(TreeNode root, TreeNode[][] container, int x, int y) {
//        System.out.println(root + "," + x + "," + y);
        if (root != null) {
            container[x][y] = root;
            int step = new Double(Math.pow(2, container[0].length - y - 2)).intValue();
            layerorder(root.left, container, x - step, y + 1);
            layerorder(root.right, container, x + step, y + 1);
        }
    }

}

