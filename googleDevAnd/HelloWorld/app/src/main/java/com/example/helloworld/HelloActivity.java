package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {
    public static final String EXTRA_RESET="com.example.android.helloworld.extra.RESET";
    private TextView mLastCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        mLastCount = (TextView) findViewById(R.id.tv_lastCount);
        Intent intent = getIntent();
        String lastCount = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mLastCount.setText(lastCount);
    }

    public void resetCount(View view){
        Intent intent= new Intent();
        intent.putExtra(EXTRA_RESET,0);
        setResult(RESULT_OK, intent);
        finish();
    }
}