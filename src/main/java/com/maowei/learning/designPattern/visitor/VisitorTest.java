package com.maowei.learning.designPattern.visitor;

import com.maowei.learning.designPattern.visitor.impl.ConcreteElementNodeA;
import com.maowei.learning.designPattern.visitor.impl.ConcreteElementNodeB;
import com.maowei.learning.designPattern.visitor.impl.ConcreteVisitorA;
import com.maowei.learning.designPattern.visitor.impl.ConcreteVisitorB;

public class VisitorTest {
    public static void main(String[] args) {
        ConcreteElementNodeA e1 = new ConcreteElementNodeA();
        ConcreteElementNodeB e2 = new ConcreteElementNodeB();

        Visitor v1 = new ConcreteVisitorA();
        Visitor v2 = new ConcreteVisitorB();

        v1.visitElementNodeA(e1);
        v1.visitElementNodeB(e2);
        v2.visitElementNodeA(e1);
        v2.visitElementNodeB(e2);
    }
}
