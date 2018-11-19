            package com.example.souka.projet;

            import android.Manifest;
            import android.content.Intent;
            import android.content.pm.PackageManager;
            import android.media.MediaPlayer;
            import android.net.Uri;
            import android.os.Bundle;
            import android.os.Environment;
            import android.provider.MediaStore;
            import android.support.design.widget.FloatingActionButton;
            import android.support.design.widget.Snackbar;
            import android.support.v4.app.ActivityCompat;
            import android.support.v4.app.Fragment;
            import android.support.v4.app.FragmentTransaction;
            import android.support.v4.content.ContextCompat;
            import android.support.v4.content.FileProvider;
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
            import android.widget.ArrayAdapter;
            import android.widget.GridView;
            import android.widget.ListView;
            import android.widget.MediaController;
            import android.widget.Toast;
            import android.widget.VideoView;

            import java.io.File;
            import java.io.IOException;
            import java.text.SimpleDateFormat;
            import java.util.ArrayList;
            import java.util.Date;
            import java.util.Locale;

            public class Histoires extends AppCompatActivity
                    implements NavigationView.OnNavigationItemSelectedListener {

                public static final int REQUEST_PERMISSION = 200;
                private static final int REQUEST_CAPTURE_IMAGE = 100;
                private String imageFilePath = "";
                private MediaPlayer media;
                private DrawerLayout mDrawerLayout;
                private ActionBarDrawerToggle mToggle;
                private NavigationView navigationView;
                private static final String TAG = "info";
                VideoView videoView;
                ListView listView;
                ArrayList<String> videolist;
                ArrayAdapter adapter;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_histoires);
                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    setSupportActionBar(toolbar);

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

                //    Toast.makeText(Histoires.this, "Amusez vous ^^ ", Toast.LENGTH_LONG).show();

                    videoView = findViewById(R.id.videoview);
                    listView = findViewById(R.id.lvideo);
                    videolist = new ArrayList<>();
                    videolist.add("histoire femme du coran 1");
                    videolist.add("Histoire 2: femme du coran");
                    videolist.add("histoire pour enfant");
                    adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,videolist);
                    if(listView!=null){
                        listView.setAdapter(adapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                switch(position){

                                    case 0:
                                        videoView.setVideoURI(Uri.parse( "android.resource://"+ getPackageName()+"/"+R.raw.histoire1));
                                        break;

                                    case 1:
                                        videoView.setVideoURI(Uri.parse( "android.resource://"+ getPackageName()+"/"+R.raw.videochiffre));
                                        break;
                                    case 2:
                                        videoView.setVideoURI(Uri.parse( "android.resource://"+ getPackageName()+"/"+R.raw.videoch));
                                        break;


                                }
                                videoView.setMediaController(new MediaController(Histoires.this));
                                videoView.requestFocus();
                                videoView.start();

                            }
                        });

                    }


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
                    getMenuInflater().inflate(R.menu.histoires, menu);
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
                            intent = new Intent(Histoires.this, Choix.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_apprendre_chiffres:
                            intent = new Intent(Histoires.this, ChoixChiffre.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_prendre_photo:
                            intent = new Intent(Histoires.this, Photos.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_voir_videos:
                            intent = new Intent(Histoires.this, Histoires.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_jouer:
                            intent = new Intent(Histoires.this, Photos.class);
                            startActivity(intent);
                            break;
                    }
                    return true;
                }




            }
