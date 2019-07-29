package com.example.computersimulator.Utils;

import android.util.Log;

import java.util.ArrayList;

public class Stack {

    private ArrayList<Integer> stack;
    private int topIndex; //top index tracker
    private int capacity;

    private final String TAG = "Stack";

    public Stack(int size) {
        this.stack = new ArrayList<>(size);
        this.capacity = size;
        this.topIndex = -1; //empty
    }

    public void push(int input) {
        if (isFull()) {
            Log.e(TAG, "Stack is full.");
            throw new IndexOutOfBoundsException();
        }

        Log.i(TAG,"Inserting " + input);
        this.stack.add(input);
        topIndex++;
    }


    public int pop() {
        if (isEmpty()) {
            Log.e(TAG, "Stack is empty.");
            throw new IndexOutOfBoundsException();
        }

        int topValue = this.stack.get(this.topIndex);
        Log.i(TAG,"Pop: " + topValue);

        //remove top value
        this.stack.remove(this.topIndex--);
        return topValue;
    }

    public int getCurrentIndex() {
        return this.topIndex;
    }

    // Stack status checkers
    public int size() {
        return this.topIndex + 1;
    }

    public Boolean isEmpty() {
        return this.topIndex == -1;    // or return size() == 0;
    }

    public Boolean isFull() {
        return this.topIndex == this.capacity - 1;    // or return size() == capacity;
    }
}