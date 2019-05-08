package com.mycompany.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mycompany.myproject.myproject.Myproject;
import com.mycompany.myproject.pkga.HelloCallback;
import com.mycompany.myproject.pkga.Pkga;
import com.mycompany.myproject.pkgb.Pkgb;
import com.mycompany.myproject.std.StrSlice;
import com.mycompany.myproject.std.StrStrMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(Myproject.anExportedProjectLevelFunc());
                String fromGo = Pkga.niceCallback(new HelloCallback() {
                    @Override
                    public String yourName() {
                        return "GoUp";
                    }
                });
                System.out.println("Hello Mr. " + fromGo);
                try {
                    System.out.println(Pkgb.getMap2().get(Pkgb.getMap2().keys().get(0)));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        StrStrMap map = Pkgb.getMap2();

        for (int i = 0; i < map.keys().len(); i++) {
            try {
                String key =  map.keys().get(i);
                String value = map.get(key);
                System.out.println(i + " - " + key +": " + value);
            } catch (Exception e) {

            }
        }
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
