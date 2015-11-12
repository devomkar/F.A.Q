package com.ironoid.fdsquiz;


import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.app.Notification.Action;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

import com.ironoid.fdsquiz.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);

        Preference help =findPreference("help");
        Preference donate =findPreference("donate");
        Preference myfb =findPreference("myfb");
        Preference myinsta =findPreference("myinsta");
        Preference myxda =findPreference("myxda");
        Preference mywa =findPreference("mywa");


        help.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Google is always there for u...be smart", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        donate.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse("https://www.paypal.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "I Will be always Thankfull for this donation", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        myxda.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse("https://forum.xda-developers.com/member.php?u=5999431");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Check out My XDA Profile!!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        myfb.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse("https://www.facebook.com/omkar.shinde.5496");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Check Out My Facebook!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        myinsta.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                // TODO Auto-generated method stub
                Uri uri = Uri.parse("https://www.instagram.com/omkarshinde7");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(SettingsActivity.this, "Check Out My Instagram!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        mywa.setOnPreferenceClickListener(new OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference arg0) {
                // TODO Auto-generated method stub

                Toast.makeText(SettingsActivity.this, "Add +917276899986 to Contacts to Chat With ME!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });





    }
}