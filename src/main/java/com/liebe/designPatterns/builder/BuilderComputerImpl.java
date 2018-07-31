package com.liebe.designPatterns.builder;

public class BuilderComputerImpl implements BuilderComputer {

    private Computer computer ;

    public BuilderComputerImpl() {
        this.computer = new Computer();
    }

    @Override
    public void builderCpu() {
        computer.setCpu("安装cpu");
    }

    @Override
    public void buildMainboard() {
        computer.setMainboard("安装主板");
    }

    @Override
    public void buildHd() {
        computer.setHd("安装硬盘");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("安装内存");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
