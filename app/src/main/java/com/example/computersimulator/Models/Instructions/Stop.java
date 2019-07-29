package com.example.computersimulator.Models.Instructions;

import com.example.computersimulator.Events.PrintEvent;
import com.example.computersimulator.Events.StopEvent;
import com.example.computersimulator.Models.Computer;
import com.example.computersimulator.Utils.Stack;

import org.greenrobot.eventbus.EventBus;

public class Stop extends Instruction {

    final private int REQUIRED_ARGS = 0;

    public Stop(){

    }

    @Override
    public void execute(Computer computer) {
        computer.endProgram();
        EventBus.getDefault().post(new StopEvent("Done."));
    }
}
