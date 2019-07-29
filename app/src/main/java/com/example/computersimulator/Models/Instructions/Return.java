package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Models.Computer;
import com.example.computersimulator.Utils.Stack;

public class Return extends Instruction {

    final private int REQUIRED_ARGS = 2;

    public Return(){}

    @Override
    public void execute(Computer computer) {
        int address = computer.getTopValueofResults();
        // Execution offset of -1 to compensate for program counter increment
        computer.setAddress(address - 1);
    }
}
