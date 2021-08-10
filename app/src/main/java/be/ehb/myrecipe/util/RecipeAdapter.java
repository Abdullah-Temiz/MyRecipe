package be.ehb.myrecipe.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.myrecipe.R;
import be.ehb.myrecipe.model.Recipe;
import be.ehb.myrecipe.model.RecipeViewModel;


public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    private List<Recipe> allRecipes;
    private List<Recipe> selectedRecipes;
    private FragmentActivity fragmentActivity;

    class RecipeViewHolder extends RecyclerView.ViewHolder{
        final TextView r_name;
        //r_ingredients, r_description;
        final CardView card;
        final Button btnDetails, btnDelete;

            RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            r_name = itemView.findViewById(R.id.tv_recipe_name);
            //r_ingredients = itemView.findViewById(R.id.et_recipe_ingredients);
            //r_description = itemView.findViewById(R.id.et_recipe_description);
            card = itemView.findViewById(R.id.recipe_card);
            btnDetails = itemView.findViewById(R.id.btn_recipe_detail);
            btnDetails.setOnClickListener(getDetailListener);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnDelete.setOnClickListener(deleteListener);
        }

        private View.OnClickListener deleteListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Recipe delete = selectedRecipes.get(position);

                RecipeViewModel model = new ViewModelProvider(fragmentActivity).get(RecipeViewModel.class);
                model.deleteRecipe(delete);
                notifyDataSetChanged();

            }
        };

        private View.OnClickListener getDetailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Recipe toGet = selectedRecipes.get(position);

                Bundle data = new Bundle();
                data.putSerializable("InsertedRecipe", toGet);
                Navigation.findNavController(itemView).navigate(R.id.action_to_new_recipe_fragment, data);
            }
        };

    }

    public RecipeAdapter(FragmentActivity fragmentActivity){
        this.allRecipes = new ArrayList<>();
        this.selectedRecipes = new ArrayList<>();
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cv_recipe, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = selectedRecipes.get(position);

        holder.r_name.setText(recipe.getRecipeName());
        //holder.r_ingredients.setText(recipe.getRecipeIngredients());
        //holder.r_description.setText(recipe.getRecipeDescription());
    }

    @Override
    public int getItemCount() {
        return selectedRecipes.size();
    }

    public void addRecipes(List<Recipe> recipes){
        selectedRecipes.clear();
        allRecipes.clear();
        selectedRecipes.addAll(recipes);
        allRecipes.addAll(recipes);

    }






}
