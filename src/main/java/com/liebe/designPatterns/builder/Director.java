package com.liebe.designPatterns.builder;

public class Director {

    public Computer createComputerByDirector(BuilderComputer builderComputer){
        builderComputer.buildMainboard();
        builderComputer.builderCpu();
        builderComputer.buildHd();
        builderComputer.buildMemory();
        return builderComputer.buildComputer();
    }


}
