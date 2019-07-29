package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Models.Computer;


public class Call extends Instruction {

    final private int REQUIRED_ARGS = 1;
    private int value;

    public Call(int value){
        this.value = value;
    }

    @Override
    public void execute(Computer computer) {
        // Execution offset of -1 to compensate for program counter increment
        computer.setAddress(value - 1);
    }

    //TODO: add input validation
    public boolean validate(int value) {
        return false;
    }
}
