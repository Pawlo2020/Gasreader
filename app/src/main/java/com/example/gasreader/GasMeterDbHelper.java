package com.example.gasreader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class GasMeterDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + GasMeterContract.GasMeterTabela.NAZWA_TABELI + " (" +
                    GasMeterContract.GasMeterTabela._ID + " INTEGER PRIMARY KEY," +
                    GasMeterContract.GasMeterTabela.KOLUMNA_IMIE + " TEXT," +
                    GasMeterContract.GasMeterTabela.KOLUMNA_NAZWISKO + " TEXT," +
                    GasMeterContract.GasMeterTabela.KOLUMNA_ADRES + " TEXT," +
                    GasMeterContract.GasMeterTabela.KOLUMNA_NUMER_LICZ + " TEXT," +
                    GasMeterContract.GasMeterTabela.KOLUMNA_STAN + " TEXT)";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + GasMeterContract.GasMeterTabela.NAZWA_TABELI;

    public static final int DATABASE_VERSION = 1; // wersja bazy (zwiększana przy zmianie schematu tabel)
    public static final String DATABASE_NAME = "GasMeter.db"; // nazwa pliku bazy danych

    public GasMeterDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // w przykładzie baza to cache dla danych online, dlatego aktualizacja to:
        db.execSQL(SQL_DELETE_ENTRIES); // usunięcie danych
        onCreate(db); // utworzenie bazy od nowa
    }

    public void dodajWiersz(String name, String surName, String address, String meterNumber, String meterState)
    {
        SQLiteDatabase db = getWritableDatabase(); // dostęp w trybie do zapisu
        ContentValues values = new ContentValues(); // mapa wartości
        values.put(GasMeterContract.GasMeterTabela.KOLUMNA_IMIE, name); // nazwy kolumn to klucze
        values.put(GasMeterContract.GasMeterTabela.KOLUMNA_NAZWISKO, surName);
        values.put(GasMeterContract.GasMeterTabela.KOLUMNA_ADRES, address);
        values.put(GasMeterContract.GasMeterTabela.KOLUMNA_NUMER_LICZ, meterNumber);
        values.put(GasMeterContract.GasMeterTabela.KOLUMNA_STAN, meterState);
        db.insert(GasMeterContract.GasMeterTabela.NAZWA_TABELI, null, values); // wstawienie wiersza (rekordu)
    }

    public void usunWiersz(long id){
        SQLiteDatabase db = getWritableDatabase();
        String selection = GasMeterContract.GasMeterTabela._ID + " LIKE ?";

        String[] selectionArgs = { Long.toString(id)};

        int deletedRows = db.delete(GasMeterContract.GasMeterTabela.NAZWA_TABELI,selection, selectionArgs);
    }

    public Cursor odczytajWszystko()
    {
        SQLiteDatabase db = getReadableDatabase(); // dostęp w trybie do odczytu

        String[] kolumny = { BaseColumns._ID, GasMeterContract.GasMeterTabela.KOLUMNA_IMIE,
                GasMeterContract.GasMeterTabela.KOLUMNA_NAZWISKO, GasMeterContract.GasMeterTabela.KOLUMNA_ADRES, GasMeterContract.GasMeterTabela.KOLUMNA_NUMER_LICZ, GasMeterContract.GasMeterTabela.KOLUMNA_STAN};
        Cursor cursor = db.query(GasMeterContract.GasMeterTabela.NAZWA_TABELI, kolumny, null, null, null, null, null);
        // tabela do przeszukania, tablica nazw kolumn do zwrócenia (null to wszystkie)
        return cursor;
    }

    public void usunWszystko()
    {
        SQLiteDatabase db = getWritableDatabase(); // dostęp w trybie do zapisu
        db.delete(GasMeterContract.GasMeterTabela.NAZWA_TABELI, null, null); // usunięcie wszystkich wierszy
    }
}