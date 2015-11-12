package com.ironoid.fdsquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button fdsquiz;
    Button deldquiz;
    Animation bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Uri> uris = new ArrayList<Uri>();
                Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                sendIntent.setType("application/vnd.android.package-archive");
                uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
                sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                startActivity(Intent.createChooser(sendIntent, null));

                Snackbar.make(view, "Share Knowledge", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce_anim);
        final Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        final ImageView logo = (ImageView) findViewById(R.id.faq_logo);
        final Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        logo.startAnimation(bounce);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logo.startAnimation(rotate);
            }
        });


        fdsquiz = (Button) findViewById(R.id.fdsquiz);
        fdsquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fdsquiz.startAnimation(zoom_in);
                final Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();

            }
        });
        deldquiz = (Button) findViewById(R.id.delduiz);
        deldquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deldquiz.startAnimation(zoom_in);
                final Intent deld = new Intent(MainActivity.this, DeldActivity.class);
                startActivity(deld);
                finish();


            }
        });


        final Button coquiz = (Button) findViewById(R.id.coquiz);
        coquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coquiz.startAnimation(zoom_in);
                final Intent co = new Intent(MainActivity.this, CoActivity.class);
                startActivity(co);
                finish();


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder close = new AlertDialog.Builder(this);

            close.setTitle("Really Exit ?");
            close.setMessage("Do you really want to exit the app and stop STUDING ??");
            close.setPositiveButton("Yes", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            ;
            close.setNegativeButton("No", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            ;
            AlertDialog alertDialog = close.create();
            alertDialog.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            AlertDialog.Builder close = new AlertDialog.Builder(this);

            close.setTitle("Really Exit ?");
            close.setMessage("Do you really want to exit the app and stop STUDING ??");
            close.setPositiveButton("Yes", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            ;
            close.setNegativeButton("No", new
                    DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            ;
            AlertDialog alertDialog = close.create();
            alertDialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

 if (id == R.id.nav_share) {

            String shareBody = "Hey , have a look at this wonderfull app F.A.Q.\nYou can Revise Your MCQ's and " +
                    "Frequently Asked Questions asked in Online Exam and Viva Using your Phone.\nJust Download the App From Here (will be updated soon)";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "FAQ App:");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));

        } else if (id == R.id.about) {

        } else if (id == R.id.action_settings) {

            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Credits(MenuItem view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        Toast.makeText(MainActivity.this, "Be What You Are...;-)", Toast.LENGTH_LONG).show();
        alertDialogBuilder.setIcon(R.drawable.omkar);
        alertDialogBuilder.setTitle("Omkar Shinde");
        alertDialogBuilder.setItems(R.array.array_value, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void Credits1(MenuItem view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        Toast.makeText(MainActivity.this, "Thanks for Suggestions...:-)", Toast.LENGTH_LONG).show();
        alertDialogBuilder.setIcon(R.drawable.ankit);
        alertDialogBuilder.setTitle("Ankit Mode");
        alertDialogBuilder.setItems(R.array.array_value1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void Credits3(MenuItem view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        Toast.makeText(MainActivity.this, "Thanks for Helping me in updating Database", Toast.LENGTH_LONG).show();
        alertDialogBuilder.setIcon(R.drawable.sushant);
        alertDialogBuilder.setTitle("Sushant Patil");
        alertDialogBuilder.setItems(R.array.array_value3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public void about(MenuItem view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Getting Started");
        alertDialogBuilder.setMessage("This app is made for students of SE Engg to study MCQ's while using their smartphone." +
                "\n\nThis app will help you to improve your knowledge." +
                "\n\nBe serious about STUDIES." +
                "\n\nThank You " +
                "\nOmkar Shinde");

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public void pref(SharedPreferences sharedPreferences){


    }
}