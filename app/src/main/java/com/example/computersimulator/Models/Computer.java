package com.example.computersimulator.Models;

import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;

import com.example.computersimulator.Models.Instructions.Instruction;
import com.example.computersimulator.Utils.Stack;

//Represents
public class Computer {

    private int programCounter;
    private SparseArray<Instruction> programStack;
    private Stack resultContainer;
    private boolean stopFlag = false;

    private final String TAG = "Computer";

    public Computer(int stackSize){
        this.programCounter = 0;
        this.programStack = new SparseArray<>(stackSize);
        this.resultContainer = new Stack(stackSize);
    }

    // Result Manipulation
    public int getTopValueofResults(){
        return this.resultContainer.pop();
    }

    public void pushToResultContainer(int value) throws IndexOutOfBoundsException {
        this.resultContainer.push(value);
    }

    // Instructions
    public int getProgramStackSize() {
        return this.programStack.size();
    }

    //computer commands
    public void insert(Instruction instruction){
        this.programStack.put(this.programCounter, instruction);
        Log.i(TAG, "Inserted: " + this.programStack.get(this.programCounter));
        this.programCounter++;
    }

    public void setAddress(int address){
        this.programCounter = address;
    }

    public void execute() throws IndexOutOfBoundsException{

        while(!this.stopFlag && this.programStack.size() > 0){
            int pointer = this.programCounter;
            Instruction current = this.programStack.get(pointer);
            Log.i(TAG, "Executing: " + pointer + current);
            if(current != null){
                current.execute(this);
                this.programStack.delete(pointer);
                this.programCounter++;
            }
            else endProgram();
        }
    }

    public void endProgram(){
        Log.i(TAG, "End of Program");
        this.stopFlag = true;
    }
}
