package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Models.Computer;

public class Multiply extends Instruction {

    final private int REQUIRED_ARGS = 2;

    public Multiply(){

    }

    @Override
    public void execute(Computer computer) {
        int operand1 = computer.getTopValueofResults();
        int operand2 = computer.getTopValueofResults();

        computer.pushToResultContainer(operand1 * operand2);
    }

    //TODO: add input validation
    public boolean validate() {
        return false;
    }
}
