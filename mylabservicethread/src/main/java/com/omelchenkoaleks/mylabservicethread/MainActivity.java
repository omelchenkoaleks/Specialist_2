package com.omelchenkoaleks.mylabservicethread;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "extra text";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.enter_text_et);
    }

    public void onClick(View view) {
        if (mEditText.length() > 0) {
            int number = Integer.parseInt(mEditText.getText().toString());
            Intent intent = new Intent(this, MyService.class);
            intent.putExtra(MainActivity.EXTRA_TEXT, number);
            startService(intent);
        } else {
            Toast.makeText(this,
                    "Enter number ... please !!!", Toast.LENGTH_SHORT).show();
        }
    }
}
