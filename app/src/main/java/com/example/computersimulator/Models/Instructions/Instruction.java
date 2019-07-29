package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Models.Computer;

import java.util.ArrayList;

public abstract class Instruction {

//    protected int address;
//    protected ArrayList resultHolder;

    public abstract void execute(Computer computer);
    //private boolean validate(Object inputs[]){};
}
