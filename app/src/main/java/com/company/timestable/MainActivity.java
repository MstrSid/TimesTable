package com.company.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumbers;
    private SeekBar seekBar;
    private TextView textViewCurrentNumber;
    private ArrayList<String> results;
    private ArrayList<Integer> numbers;
    private int max = 50;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewNumbers = findViewById(R.id.listViewNumbers);
        seekBar = findViewById(R.id.seekBar);
        textViewCurrentNumber = findViewById(R.id.textViewCurrentNumber);
        numbers = new ArrayList<>();
        results = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, results);
        listViewNumbers.setAdapter(arrayAdapter);
        seekBar.setMax(max);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                numbers.clear();
                results.clear();
                if(i<min){
                    seekBar.setProgress(min);
                    numbers.clear();
                    results.clear();
                }
                for(int j = min; j <=count; j++){
                    textViewCurrentNumber.setText(String.valueOf(seekBar.getProgress()));
                    numbers.add(seekBar.getProgress()*j);
                    results.add(String.valueOf(seekBar.getProgress())+" * "+String.valueOf(j)+" = "+String.valueOf(numbers.get(j-1)));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(1);
    }
}