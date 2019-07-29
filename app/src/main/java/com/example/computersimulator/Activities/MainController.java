package com.example.computersimulator.Activities;

import android.util.Log;

import com.example.computersimulator.Exceptions.InvalidArguments;
import com.example.computersimulator.Input.ProgramRunner;

public class MainController {
    private ProgramRunner programRunner;
    private final String TAG = "ProgramRunner";

    public void startProgram() {
        //

        try{
            programRunner = new ProgramRunner();
            programRunner.initialize();
            programRunner.start();
        }catch(InvalidArguments err){
            Log.w(TAG, err.toString());
        }catch(Exception e){
            Log.e(TAG, e.toString());
        }
    }

}
