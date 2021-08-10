package be.ehb.myrecipe.fragments.recipe;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import be.ehb.myrecipe.model.Recipe;
import be.ehb.myrecipe.model.RecipeViewModel;
import be.ehb.myrecipe.util.RecipeAdapter;

import be.ehb.myrecipe.R;

public class RecipesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private FragmentActivity fragmentActivity;

    @NonNull
    public static RecipesFragment newInstance() {
        RecipesFragment fragment = new RecipesFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActivity = (FragmentActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RecipeView =  inflater.inflate(R.layout.fragment_recipes, container, false);
        FloatingActionButton addRecipe = RecipeView.findViewById(R.id.fab_add_recipe);
        addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addRecipe.hide();
                Navigation.findNavController(v).navigate(R.id.action_to_new_recipe_fragment);
            }
        });

        recipeAdapter = new RecipeAdapter(getActivity());
        recyclerView = RecipeView.findViewById(R.id.rv_recipes);
        recyclerView.setAdapter(recipeAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecipeViewModel model = new ViewModelProvider(fragmentActivity).get(RecipeViewModel.class);
        model.getRecipeList().observe(getViewLifecycleOwner(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                recipeAdapter.addRecipes(recipes);
                recipeAdapter.notifyDataSetChanged();
            }
        });



        return RecipeView;
    }
}