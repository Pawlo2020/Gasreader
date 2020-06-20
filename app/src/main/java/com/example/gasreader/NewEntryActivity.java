package com.example.gasreader;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewEntryActivity extends Activity implements View.OnClickListener {

    EditText nameEdit, surnameEdit, addressEdit, meterNO, stateReader;
    Button newEntryButton;

    GasMeterDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        dbHelper = new GasMeterDbHelper(this);

        nameEdit = (EditText)findViewById(R.id.personName);
        surnameEdit = (EditText)findViewById(R.id.personSurname);
        addressEdit = (EditText)findViewById(R.id.personAddress);
        meterNO = (EditText)findViewById(R.id.meterNO);
        stateReader = (EditText)findViewById(R.id.meterState);

        newEntryButton = (Button)findViewById(R.id.newEntryButton);

        newEntryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.newEntryButton:
                String name = nameEdit.getText().toString();
                String surname = surnameEdit.getText().toString();
                String address = addressEdit.getText().toString();
                String meterNumber = meterNO.getText().toString();
                String state = stateReader.getText().toString();

                dbHelper.dodajWiersz(name,surname,address,meterNumber,state);



                Intent intencja = new Intent(this, MainActivity.class);
                startActivity(intencja);
                break;
        }
    }
}
