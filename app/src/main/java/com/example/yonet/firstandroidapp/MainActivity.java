package com.example.yonet.firstandroidapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LIFECYCLE = "Activity";
    public static final String EXTRA_MESSAGE = "com.example.yonet.firstandroidapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Send(View view){
        Intent intent = new Intent(this,DisplayMessageActivity.class);//this refer to the default activity of user interface
        EditText edit_message = (EditText)findViewById(R.id.edit_message);
        TextView conform = (TextView)findViewById(R.id.conform);
        if(edit_message.getText().toString() == null){
            conform.setText("text not entered");
            conform.setBackgroundColor(Color.RED);
        }else {
            String message = edit_message.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(LIFECYCLE,"Started");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(LIFECYCLE, "Resumed");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i(LIFECYCLE, "Paused");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i(LIFECYCLE, "Stopped");
    }
    //showed when destroyed
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(LIFECYCLE, "Destoyed");
    }
    //for the restart state
    @Override
    public void onRestart(){
        super.onRestart();
        Log.i(LIFECYCLE, "Restarted ");
    }


}
