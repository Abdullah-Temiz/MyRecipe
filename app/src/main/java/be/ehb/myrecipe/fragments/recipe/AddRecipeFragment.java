package be.ehb.myrecipe.fragments.recipe;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import be.ehb.myrecipe.R;
import be.ehb.myrecipe.model.Recipe;
import be.ehb.myrecipe.model.RecipeViewModel;

public class AddRecipeFragment extends Fragment {

    private EditText etRecipeName, etRecipeIngredients, etRecipeDescription;
    private Recipe selected;
    private FragmentActivity fragmentActivity;
    Button btnSaveRecipe;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActivity = (FragmentActivity) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_recipe, container, false);

        selected = (getArguments() != null)?(Recipe) getArguments().getSerializable("InsertedRecipe"):null;

        etRecipeName = view.findViewById(R.id.et_recipe_name);
        etRecipeIngredients = view.findViewById(R.id.et_recipe_ingredients);
        etRecipeDescription = view.findViewById(R.id.et_recipe_description);

        if(selected != null){
            etRecipeName.setText(selected.getRecipeName());
            etRecipeIngredients.setText(selected.getRecipeIngredients());
            etRecipeDescription.setText(selected.getRecipeDescription());
        }

        btnSaveRecipe = view.findViewById(R.id.btn_recipe_save);
        btnSaveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeViewModel viewModel = new ViewModelProvider(fragmentActivity).get(RecipeViewModel.class);
                if(selected == null){
                    Recipe recipe = new Recipe(etRecipeName.getText().toString(), etRecipeIngredients.getText().toString(),etRecipeDescription.getText().toString());
                    viewModel.insertRecipe(recipe);
                    Toast.makeText(getContext(),"Recipe added succesfully !",Toast.LENGTH_SHORT).show();
                }
                else{
                    selected.setRecipeName(etRecipeName.getText().toString());
                    selected.setRecipeIngredients(etRecipeIngredients.getText().toString());
                    selected.setRecipeDescription(etRecipeDescription.getText().toString());
                    viewModel.updateRecipe(selected);
                }
                Navigation.findNavController(v).navigate(R.id.action_addRecipeFragment_to_recipesFragment);
            }
        });

        return view;
    }


}