package com.example.souka.projet;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Toast;

public class Chiffre extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chiffre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(Chiffre.this, "Appuyez sur un chiffre ^^ ", Toast.LENGTH_LONG).show();
        final GridView gridView = (GridView) findViewById(R.id.g2);
        // Instance of ImageAdapterChiffre Class
        gridView.setAdapter(new ImageAdapterChiffre(this));

        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch (position) {
                    case 0:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a1);
                        media.start();
                        break;
                    case 1:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a1);
                        media.start();
                        break;
                    case 2:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a2);
                        media.start();
                        break;
                    case 3:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a3);
                        media.start();
                        break;
                    case 4:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a4);
                        media.start();
                        break;
                    case 5:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a5);
                        media.start();
                        break;
                    case 6:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a6);
                        media.start();
                        break;
                    case 7:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a7);
                        media.start();
                        break;
                    case 8:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a8);
                        media.start();
                        break;
                    case 9:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a9);
                        media.start();
                        break;
                    case 10:
                        media = MediaPlayer.create(Chiffre.this, R.raw.a10);
                        media.start();
                        break;

                }


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alphabet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent intent;
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.nav_apprendre_alphabet:
                intent = new Intent(Chiffre.this, Choix.class);
                startActivity(intent);
                break;
            case R.id.nav_apprendre_chiffres:
                intent = new Intent(Chiffre.this, ChoixChiffre.class);
                startActivity(intent);
                break;
            case R.id.nav_voir_animaux:
                intent = new Intent(Chiffre.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_voir_videos:

                break;
            case R.id.nav_jouer:

                break;
        }
        return true;
    }
}
