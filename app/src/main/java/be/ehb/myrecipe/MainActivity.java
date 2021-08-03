package be.ehb.myrecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import be.ehb.myrecipe.fragments.map.MapFragment;
import be.ehb.myrecipe.fragments.recipe.RecipesFragment;
import be.ehb.myrecipe.fragments.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    AppBarConfiguration appBarConfiguration;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * THIS CODE HELPS TO NAVIGATE BETWEEN FRAGMENTS VIA BOTTOM NAVIGATION.
        * THANKS TO LINE 39, WE ARE DECLARING OUR HOME PAGE AT STARTUP OF THE APPLICATION.
         */
        BottomNavigationView bottomNavigationView =  findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host, new RecipesFragment()).commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.recipesFragment, R.id.addRecipeFragment, R.id.mapFragment, R.id.settingsFragment).build();
        navController = Navigation.findNavController(this, R.id.nav_host);
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);


    }

    /*
    * THIS METHOD WIL HELP US TO NAVIGATE TO THE SELECTED FRAGMENT BY THE USER (VIA THE MENU OF THE BOTTOM NAVIGATION).
     */
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment clickedFragment = null;
            switch (item.getItemId()){
                case R.id.recipesFragment:
                    clickedFragment = new RecipesFragment();
                    break;

                case R.id.mapFragment:
                    clickedFragment = new MapFragment();
                    break;

                case R.id.settingsFragment:
                    clickedFragment = new SettingsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host, clickedFragment).commit();
            return true;
        }
    };



}