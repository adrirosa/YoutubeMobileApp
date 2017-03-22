package com.example.adriana.rosa_td6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView indexText;
    private EditText editTextSearch;
    private Button buttonSearch;
    private String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indexText = (TextView) findViewById(R.id.textView);
        editTextSearch = (EditText) findViewById(R.id.editVideoSearch);
        buttonSearch = (Button) findViewById(R.id.button);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //catch the keyword
                keyword = getKeyword();
                System.out.println(keyword);
            }
        });
    }

    //function to catch the input. So the keyword
    public String getKeyword() {
        String inputText = editTextSearch.getText().toString();
        EditText editVideoSearch = (EditText) findViewById(R.id.editVideoSearch);
        if (inputText != null) {
            Intent i = new Intent(MainActivity.this, RecyclerActivity.class);
            i.putExtra("Keyword", editTextSearch.getText().toString());
            startActivity(i);
            editTextSearch.setText("");
        }
        return inputText;
    }
}
