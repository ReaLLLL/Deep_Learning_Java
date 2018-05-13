package com.maowei.learning.designPattern.visitor;

import com.maowei.learning.designPattern.visitor.impl.ConcreteElementNodeA;
import com.maowei.learning.designPattern.visitor.impl.ConcreteElementNodeB;

public interface Visitor {
    void visitElementNodeA(ConcreteElementNodeA nodeA);
    void visitElementNodeB(ConcreteElementNodeB nodeB);
}
