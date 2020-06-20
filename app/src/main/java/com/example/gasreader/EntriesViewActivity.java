package com.example.gasreader;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class EntriesViewActivity extends Activity implements View.OnClickListener {

    private TableLayout table;
    private GasMeterDbHelper dbHelper;
    private TextView textAddress;
    private Spinner spinnerColumns;

    boolean[] Hides = new boolean[5];

    public EntriesViewActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries_view);

        TextView name = findViewById(R.id.nameCol);
        name.setOnClickListener(this);

        TextView surname = findViewById(R.id.surnameCol);
        surname.setOnClickListener(this);

        TextView address = findViewById(R.id.addressCol);
        address.setOnClickListener(this);

        TextView meterNumber = findViewById(R.id.meterNoCol);
        meterNumber.setOnClickListener(this);

        TextView meterState = findViewById(R.id.stateCol);
        meterState.setOnClickListener(this);


        table = (TableLayout)findViewById(R.id.table);
        dbHelper = new GasMeterDbHelper(this);


        showDatabase();
    }

    private void showDatabase() {
        Cursor cursor = dbHelper.odczytajWszystko();

        while(cursor.moveToNext())
        {
            String name = cursor.getString(1);

            String surname = cursor.getString(2);

            String address = cursor.getString(3);

            String meterNumber = cursor.getString(4);

            String state = cursor.getString(5);

            TextView textName = new TextView(this);
            textName.setText(name);
            textName.setGravity(Gravity.CENTER);

            TextView textSurname = new TextView(this);
            textSurname.setText(surname);
            textSurname.setGravity(Gravity.CENTER);

            textAddress = new TextView(this);
            textAddress.setText(address);
            textAddress.setGravity(Gravity.CENTER);

            TextView textMeterNumber = new TextView(this);
            textMeterNumber.setText(meterNumber);
            textMeterNumber.setGravity(Gravity.CENTER);

            TextView textState = new TextView(this);
            textState.setText(state);
            textState.setGravity(Gravity.CENTER);

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            row.addView(textName);
            row.addView(textSurname);
            row.addView(textAddress);
            row.addView(textMeterNumber);
            row.addView(textState);


            table.addView(row);

        }
        cursor.close();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.nameCol:
                        if(Hides[0]==false) {
                            for(int i=1; i<table.getChildCount(); i++) {
                                TableRow row = (TableRow) table.getChildAt(i);
                                row.getChildAt(0).setVisibility(View.INVISIBLE);
                                Hides[0] = true;
                            }
                        }else{
                            for(int i=1; i<table.getChildCount(); i++) {
                                TableRow row = (TableRow) table.getChildAt(i);
                                row.getChildAt(0).setVisibility(View.VISIBLE);
                                Hides[0] = false;
                            }
                        }

                break;

            case R.id.surnameCol:
                if(Hides[1]==false) {
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(1).setVisibility(View.INVISIBLE);
                        Hides[1] = true;
                    }
                }else{
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(1).setVisibility(View.VISIBLE);
                        Hides[1] = false;
                    }
                }

                break;

            case R.id.addressCol:
                if(Hides[2]==false) {
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(2).setVisibility(View.INVISIBLE);
                        Hides[2] = true;
                    }
                }else{
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(2).setVisibility(View.VISIBLE);
                        Hides[2] = false;
                    }
                }
                break;

            case R.id.meterNoCol:
                if(Hides[3]==false) {
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(3).setVisibility(View.INVISIBLE);
                        Hides[3] = true;
                    }
                }else{
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(3).setVisibility(View.VISIBLE);
                        Hides[3] = false;
                    }
                }
                break;

            case R.id.stateCol:
                if(Hides[4]==false) {
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(4).setVisibility(View.INVISIBLE);
                        Hides[4] = true;
                    }
                }else{
                    for(int i=1; i<table.getChildCount(); i++) {
                        TableRow row = (TableRow) table.getChildAt(i);
                        row.getChildAt(4).setVisibility(View.VISIBLE);
                        Hides[4] = false;
                    }
                }
                break;
        }
    }

    @Override
    protected void onDestroy()
    {
        dbHelper.close();
        super.onDestroy();
    }

}
