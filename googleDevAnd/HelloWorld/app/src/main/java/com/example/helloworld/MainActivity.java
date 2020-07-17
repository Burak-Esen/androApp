package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="com.example.android.helloworld.extra.MESSAGE";
    public static final int RESET_REQUEST=1;
    private int count=0;
    private TextView showCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.e("MainActivity", "Hello World");
        showCount=(TextView) findViewById(R.id.text_show_count);
    }

    public void lunchHelloActivity(View view){
//        Toast toast=Toast.makeText(this,R.string.reset_counter_message, Toast.LENGTH_SHORT);
//        this.count=0;
//        if (showCount != null)
//            showCount.setText(Integer.toString(count));
//        toast.show();
        Intent intent = new Intent(this, HelloActivity.class);
        String number = String.valueOf(count);
        intent.putExtra(EXTRA_MESSAGE, number);
        startActivityForResult(intent, RESET_REQUEST);
    }

    public void countUp(View view){
        this.count++;
        if (showCount != null)
            showCount.setText(Integer.toString(count));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESET_REQUEST) {
            if (resultCode == RESULT_OK) {
                int reset = data.getIntExtra(HelloActivity.EXTRA_RESET, 0);
                count=reset;
                showCount.setText("0");
            }
        }
    }
}