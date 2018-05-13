package com.maowei.learning.designPattern.visitor.impl;

import com.maowei.learning.designPattern.visitor.Visitor;

public class ConcreteVisitorA implements Visitor{
    public void visitElementNodeA(ConcreteElementNodeA nodeA) {
        System.out.println("Node A is visited by visitor A");
    }

    public void visitElementNodeB(ConcreteElementNodeB nodeB) {
        System.out.println("Node B is visited by visitor A");
    }
}
