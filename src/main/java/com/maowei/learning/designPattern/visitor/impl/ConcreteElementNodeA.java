package com.maowei.learning.designPattern.visitor.impl;

import com.maowei.learning.designPattern.visitor.ElementNode;
import com.maowei.learning.designPattern.visitor.Visitor;

public class ConcreteElementNodeA implements ElementNode{
    public void accept(Visitor visitor) {
        visitor.visitElementNodeA(this);
    }
}
