package com.maowei.learning.designPattern.ResponsibilityChain;

public abstract class Handler {

    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract String handleRequest(int amount);
}
