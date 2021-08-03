package be.ehb.myrecipe.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Recipe implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long Id;
    @ColumnInfo(name = "recipe_name")
    private String recipeName;
    @ColumnInfo(name = "recipe_ingredients")
    private String recipeIngredients;
    @ColumnInfo(name = "recipe_description")
    private String recipeDescription;
    @ColumnInfo(name = "recipe_image")
    private long recipeImage;

    public Recipe() {
    }

    @Ignore
    public Recipe(long id, String recipeName, String recipeIngredients, String recipeDescription, long recipeImage) {
        Id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeDescription = recipeDescription;
        this.recipeImage = recipeImage;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public long getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(long recipeImage) {
        this.recipeImage = recipeImage;
    }
}


