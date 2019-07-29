package com.example.computersimulator.Input;

import android.util.Log;

import com.example.computersimulator.Exceptions.InvalidArguments;
import com.example.computersimulator.Models.Computer;
import com.example.computersimulator.Models.Instructions.Call;
import com.example.computersimulator.Models.Instructions.Multiply;
import com.example.computersimulator.Models.Instructions.Print;
import com.example.computersimulator.Models.Instructions.Push;
import com.example.computersimulator.Models.Instructions.Return;
import com.example.computersimulator.Models.Instructions.Stop;

public class ProgramRunner {
    //creates the computer
    //initializes the commands
    //populates the stack

    private final int PRINT_TENTEN_BEGIN = 50;
    private final int MAIN_BEGIN = 0;
    private final int MAX_STACK_SIZE = 100;

    private final String TAG = "PROGRAM_RUNNER";

    public static Computer computer;

    // Define contents of main function (execution test)
    public void initialize() throws InvalidArguments {

        // Initialize commands that get value at runtime
        Multiply MULT = new Multiply();
        Print PRINT = new Print();
        Return RET = new Return();
        Stop STOP = new Stop();

        // Create new computer with a stack of 100 addresses
        computer = new Computer(MAX_STACK_SIZE);
        Log.i(TAG, "Program Stack Size: " + computer.getProgramStackSize());

        // Instructions for the print_tenten function
        computer.setAddress(PRINT_TENTEN_BEGIN);
        computer.insert(MULT);
        computer.insert(PRINT);
        computer.insert(RET);

        // The start of the main function
        computer.setAddress(MAIN_BEGIN);
        computer.insert(new Push(1009));
        computer.insert(PRINT);

        // Return address for when print_tenten function finishes
        computer.insert(new Push(6));

        // Setup arguments and call print_tenten
        computer.insert(new Push(101));
        computer.insert(new Push(10));
        computer.insert(new Call(PRINT_TENTEN_BEGIN));

        // Stop the program
        computer.insert(STOP);

        computer.setAddress(MAIN_BEGIN);
    }

    public void start(){
        computer.execute();
    }
}
