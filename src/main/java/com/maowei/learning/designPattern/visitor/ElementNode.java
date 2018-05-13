package com.maowei.learning.designPattern.visitor;

public interface ElementNode {
    void accept(Visitor visitor);
}
