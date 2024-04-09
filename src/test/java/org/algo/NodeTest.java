package org.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class NodeTest {

    @Test
    void validate_get_key() {
        Node<Integer> integerNode = buildNode();
        Assertions.assertEquals(7000009, integerNode.getKey(5));
        assertNull(integerNode.getKey(6));
    }

    @Test
    void validate_keys_sorted() {
        Node<Integer> integerNode = buildNode();
        Assertions.assertEquals(1000004, integerNode.getKey(0));
        Assertions.assertEquals(7000009, integerNode.getKey(5));
    }


    @Test
    void validate_children_are_sorted() {
        Node<Integer> parentNode = buildNode();
        parentNode.addChild(buildChildNode());
        parentNode.addChild(buildChildNode2());
        Node<Integer> child = parentNode.getChild(0);
        Assertions.assertEquals(10, child.getKey(0));
        Node<Integer> child2 = parentNode.getChild(1);
        Assertions.assertEquals(100, child2.getKey(0));
    }

    @Test
    void validate_remove_key() {
        Node<Integer> integerNode = buildNode();
        Assertions.assertEquals(5000008, integerNode.removeKey(4));
        Assertions.assertEquals(7000009, integerNode.getKey(4));
        Assertions.assertEquals(5, integerNode.getKeySize());
        integerNode.removeKey(4);
        Assertions.assertEquals(4, integerNode.getKeySize());
    }

    @Test
    void validate_remove_by_value() {
        Node<Integer> integerNode = buildNode();
        integerNode.removeKey(Integer.valueOf(7000009));
        Assertions.assertEquals(5, integerNode.getKeySize());
    }

    public Node<Integer> buildNode() {
        Node<Integer> node = new Node(5, 2, null);
        node.addKey(3000006);
        node.addKey(1000004);
        node.addKey(2000005);
        node.addKey(7000009);
        node.addKey(4000007);
        node.addKey(5000008);
        return node;
    }

    public Node<Integer> buildChildNode() {
        Node<Integer> node = new Node(5, 2, null);
        node.addKey(300);
        node.addKey(100);
        node.addKey(200);
        node.addKey(700);
        node.addKey(400);
        node.addKey(500);
        return node;
    }

    public Node<Integer> buildChildNode2() {
        Node<Integer> node = new Node(5, 2, null);
        node.addKey(30);
        node.addKey(10);
        node.addKey(20);
        node.addKey(70);
        node.addKey(40);
        node.addKey(50);
        return node;
    }

}