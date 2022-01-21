package com.aymen.radiotn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Radio> listRadio = new ArrayList<Radio>();
        LayoutInflater layoutInflater = getLayoutInflater();

        listRadio.add(new Radio("Mosaique FM","https://tunisiefm.net/sites/default/files/styles/116_x_116/public/radio/logos/logo-mwzyk-fm.jpg?itok=3UrCjgiT","https://radio.mosaiquefm.net/mosalive")) ;

        RadioAdapter ra = new RadioAdapter(listRadio,layoutInflater,MainActivity.this) ;


        ListView lv = (ListView) findViewById(R.id.radios) ;
        lv.setAdapter(ra);

    }
}