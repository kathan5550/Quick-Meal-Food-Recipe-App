package com.example.quickmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quickmeal.Adapters.IngredientsAdapter;
import com.example.quickmeal.Adapters.InstructionsAdapter;
import com.example.quickmeal.Adapters.SimilarRecipeAdapter;
import com.example.quickmeal.Listner.InstructionListner;
import com.example.quickmeal.Listner.RecipeClickListner;
import com.example.quickmeal.Listner.RecipeDetailListner;
import com.example.quickmeal.Listner.SimilarRecipeListner;
import com.example.quickmeal.Models.InstructionsResponse;
import com.example.quickmeal.Models.RecipeDetailResponse;
import com.example.quickmeal.Models.SimilarRecipeResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    int id;
    TextView txtview_meal_name, txtview_meal_source, txtview_meal_summary, txtview_meal_ingredients;
    ImageView imageview_meal_image;
    RecyclerView recycler_meal_ingredients, recycler_meal_similar, recycler_meal_instruction;
    RequestManager manager;
    ProgressDialog dialog;
    IngredientsAdapter ingredientsAdapter;
    InstructionsAdapter instructionsAdapter;
    SimilarRecipeAdapter similarRecipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        findView();

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailListner, id);
        manager.getSimilarRecipes(similarRecipeListner, id);
        manager.getInstructions(instructionListner, id);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Deatails");
        dialog.show();

    }

    private void findView() {
        txtview_meal_name = findViewById(R.id.txtview_meal_name);
        txtview_meal_source = findViewById(R.id.txtview_meal_source);
        txtview_meal_summary = findViewById(R.id.txtview_meal_summary);
        imageview_meal_image = findViewById(R.id.imageview_meal_image);
        recycler_meal_ingredients = findViewById(R.id.recycler_meal_ingredients);
        recycler_meal_similar = findViewById(R.id.recycler_meal_similar);
        recycler_meal_instruction = findViewById(R.id.recycler_meal_instruction);

    }

    private final RecipeDetailListner recipeDetailListner = new RecipeDetailListner() {
        @Override
        public void didFetch(RecipeDetailResponse response, String message) {
            dialog.dismiss();
            txtview_meal_name.setText(response.title);
            txtview_meal_source.setText(response.sourceName);
            txtview_meal_summary.setText(response.summary);
            Picasso.get().load(response.image).into(imageview_meal_image);

            recycler_meal_ingredients.setHasFixedSize(true);
            recycler_meal_ingredients.setLayoutManager(new LinearLayoutManager(RecipeDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
            ingredientsAdapter = new IngredientsAdapter(RecipeDetailActivity.this, response.extendedIngredients);
            recycler_meal_ingredients.setAdapter(ingredientsAdapter);

        }

        @Override
        public void didError(String message) {

        }
    };


    private final SimilarRecipeListner similarRecipeListner = new SimilarRecipeListner() {
        @Override
        public void didFetch(List<SimilarRecipeResponse> response, String message) {

            recycler_meal_similar.setHasFixedSize(true);
            recycler_meal_similar.setLayoutManager(new LinearLayoutManager(RecipeDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
            similarRecipeAdapter = new SimilarRecipeAdapter(RecipeDetailActivity.this, response, recipeClickListner);
            recycler_meal_similar.setAdapter(similarRecipeAdapter);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private final RecipeClickListner recipeClickListner = new RecipeClickListner() {
        @Override
        public void onRecipeClicked(String id) {
            startActivity(new Intent(RecipeDetailActivity.this, RecipeDetailActivity.class)
                    .putExtra("id", id));

        }
    };

    private final InstructionListner instructionListner = new InstructionListner() {
        @Override
        public void didFetch(List<InstructionsResponse> response, String message) {

            recycler_meal_instruction.setHasFixedSize(true);
            recycler_meal_instruction.setLayoutManager(new LinearLayoutManager(RecipeDetailActivity.this, LinearLayoutManager.VERTICAL, false));
            instructionsAdapter = new InstructionsAdapter(RecipeDetailActivity.this, response);
            Log.d("Instructions", response.get(0).steps.get(0).toString());
            recycler_meal_instruction.setAdapter(instructionsAdapter);
        }

        @Override
        public void didError(String message) {
            Log.d("Instructions", message);

        }
    };

}
