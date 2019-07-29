package com.example.computersimulator.Activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.computersimulator.Events.PrintEvent;
import com.example.computersimulator.Events.StopEvent;
import com.example.computersimulator.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private MainController mainController;
    private ProgressBar progress;
    private EditText displayText;
    private Button runButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runButton = findViewById(R.id.btn_run);
        progress = findViewById(R.id.progress);
        displayText = findViewById(R.id.editText);

        runButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                runButton.setEnabled(false);
                progress.setVisibility(View.VISIBLE);
                displayText.setText(""); // Clear the contents of the text view

                mainController = new MainController();
                mainController.startProgram();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void dismissProgress(){
        progress.setVisibility(View.INVISIBLE);
    }

    public void displayMessage(String message) {
        String currentText = displayText.getText().toString();
        currentText += message + "\n";
        displayText.setText(currentText);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPrintEvent(PrintEvent event) {
        displayMessage(event.message);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStopEvent(StopEvent event) {
        Toast.makeText(MainActivity.this, event.message, Toast.LENGTH_LONG).show();
        dismissProgress();
    }
}
