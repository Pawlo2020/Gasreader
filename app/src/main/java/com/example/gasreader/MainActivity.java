package com.example.gasreader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button addButt, dbViewButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButt = (Button)findViewById(R.id.addButt);

        dbViewButt = (Button)findViewById(R.id.dbViewButt);

        addButt.setOnClickListener(this);

        dbViewButt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addButt:
                Intent intencja = new Intent(this, NewEntryActivity.class);
                startActivity(intencja);
                break;

            case R.id.dbViewButt:
                Intent intencja2 = new Intent(this, EntriesViewActivity.class);
                startActivity(intencja2);
                break;
        }
    }
}