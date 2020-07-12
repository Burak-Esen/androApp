package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count=0;
    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.e("MainActivity", "Hello World");
        showCount=(TextView) findViewById(R.id.text_show_count);
    }

    public void resetCount(View view){
        Toast toast=Toast.makeText(this,R.string.reset_counter_message, Toast.LENGTH_SHORT);
        this.count=0;
        if (showCount != null)
            showCount.setText(Integer.toString(count));
        toast.show();
    }

    public void countUp(View view){
        this.count++;
        if (showCount != null)
            showCount.setText(Integer.toString(count));
    }
}