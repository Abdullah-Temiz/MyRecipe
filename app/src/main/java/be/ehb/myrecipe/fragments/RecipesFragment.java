package be.ehb.myrecipe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import be.ehb.myrecipe.R;

public class RecipesFragment extends Fragment {

    public RecipesFragment() {
    }

    public static RecipesFragment newInstance() {
        RecipesFragment fragment = new RecipesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RecipeView =  inflater.inflate(R.layout.fragment_recipes, container, false);
        FloatingActionButton fab_add = RecipeView.findViewById(R.id.fab_add_recipe);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_to_new_recipe_fragment);
            }
        });
        return RecipeView;
    }
}