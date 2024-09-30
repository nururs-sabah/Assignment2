package com.example.assignment2;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private SeekBar seekBar;
    private Switch switchEnableSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        switchEnableSeekbar = findViewById(R.id.switch_enable_seekbar);

        switchEnableSeekbar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            seekBar.setEnabled(isChecked);
   });
}
}