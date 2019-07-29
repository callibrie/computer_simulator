package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Models.Computer;

import java.util.ArrayList;

public class Push extends Instruction {

    private int value;

    public Push(int value){
        this.value = value;
    }

    @Override
    public void execute(Computer computer) {
        computer.pushToResultContainer(this.value);
    }

    //TODO: add input validation
    public boolean validate(int value) {
        return false;
    }
}
