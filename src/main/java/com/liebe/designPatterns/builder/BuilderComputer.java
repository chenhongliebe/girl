package com.liebe.designPatterns.builder;

public interface BuilderComputer {

    public void builderCpu();

    public void buildMainboard();

    public void buildHd();

    public void buildMemory();

    public Computer buildComputer();

}
