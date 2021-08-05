package be.ehb.myrecipe.fragments.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import be.ehb.myrecipe.R;

public class SettingsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settingsFragment, new SettingsFragment())
                .commit();
    }}