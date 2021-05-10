package com.company;

//each node can have at most two nodes
/* A collection of nodes to symbolize hierarchy
organize data - for quick search, insnertion,deletion
Trie - dictionary
Network routing algorithim
Not bi-directional
Recursive data structure
For n nodes = there are n-1 edges
Depth of x = number of edges in path from root to x
Height of x = number of edges in longest path from x to a leaf
Height of tree = height of a root node

Leaf node = nodes with no children
*height of binary tree is the longest distance between root and a leaf node
*maximum number of nodes in a tree with height h is
*     n = (2^h+1) - 1
* Find the height of a binary tree given n nodes
*     n =(2^h+1) - 1
*     n+1 = (2^h+1)
*     h = log(n+1) - 1
Time depends on the height of a tree
1. Perfect binary tree = all nodes have at least two children h = log(n+1) - 1
2. complete binary tree = the last nodes in a row have 2 children h = log n
* Balanced binary  tree - difference between height of the left and right
*  subtree for every node is not more than k(mostly 1)
* Height of an empty tree = -1
* Height of a tree with one node = 0
*
* Binary trees can be implemented using
* 1. dynamically created nodes
* 2. arrays - takes the nodes form left to right store them in an array
* for node at index i
* left child index  = 2i+1
* right child index = 2i+1

            (Unsorted)Array      Linked List     (Sorted) Array     BST
search(x)   o(n)                  o(n)               o(log n)        o(log n)
insert(x)   o(1)                  o(1)               o(n)            o(log n)
remove(x)   o(n)                  o(n)               o(n)            o(log n)

Binary search
For each node, value of all the nodes in left subtree is lesser or equal
and value of the right subtree is greater
 */

public class BinaryTree {


}
