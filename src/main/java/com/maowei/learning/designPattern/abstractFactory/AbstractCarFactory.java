package com.maowei.learning.designPattern.abstractFactory;

public interface AbstractCarFactory {

    public AbstractCarEngine buildCarEngine();

    public AbstractCarBody buildCarBody();

}
