package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Events.PrintEvent;
import com.example.computersimulator.Models.Computer;

import org.greenrobot.eventbus.EventBus;

public class Print extends Instruction {

    final private int REQUIRED_ARGS = 1;

    public Print(){
    }

    @Override
    public void execute(Computer computer) {
        //get item in top of stack
        String printString = Integer.toString(computer.getTopValueofResults());
        //send message to UI Thread
        EventBus.getDefault().post(new PrintEvent(printString));
    }
}
