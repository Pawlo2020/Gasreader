package com.example.gasreader;

import android.provider.BaseColumns;

public final class GasMeterContract {
    private GasMeterContract() {}

    public static class GasMeterTabela implements BaseColumns
    {
        public static final String NAZWA_TABELI = "gas_meter_entries";
        public static final String KOLUMNA_IMIE = "name";
        public static final String KOLUMNA_NAZWISKO = "surname";
        public static final String KOLUMNA_ADRES = "address";
        public static final String KOLUMNA_NUMER_LICZ = "meter_number";
        public static final String KOLUMNA_STAN = "meter_state";
    }
}
