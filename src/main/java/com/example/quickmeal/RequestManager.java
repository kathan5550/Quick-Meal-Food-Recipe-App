package com.example.quickmeal;

import android.content.Context;

import com.example.quickmeal.Listner.InstructionListner;
import com.example.quickmeal.Listner.RandomRecipesResponseListner;
import com.example.quickmeal.Listner.RecipeDetailListner;
import com.example.quickmeal.Listner.SimilarRecipeListner;
import com.example.quickmeal.Models.InstructionsResponse;
import com.example.quickmeal.Models.RandomRecipesApiResponse;
import com.example.quickmeal.Models.RecipeDetailResponse;
import com.example.quickmeal.Models.SimilarRecipeResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {

    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getRandomRecipes(RandomRecipesResponseListner listner, List<String> tags) {
        CallRandomRecipes callRandomRecipes = retrofit.create(CallRandomRecipes.class);
        Call<RandomRecipesApiResponse> call = callRandomRecipes.callrandomrecipes(context.getString(R.string.apikey), "50", tags);
        call.enqueue(new Callback<RandomRecipesApiResponse>() {
            @Override
            public void onResponse(Call<RandomRecipesApiResponse> call, Response<RandomRecipesApiResponse> response) {
                if (!response.isSuccessful()) {
                    listner.didError(response.message());
                    return;
                }
                listner.didfetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RandomRecipesApiResponse> call, Throwable t) {
                listner.didError(t.getMessage());
            }
        });
    }

    public void getSimilarRecipes(SimilarRecipeListner listner, int id) {
        CallsimilarRecipes callsimilarRecipes = retrofit.create(CallsimilarRecipes.class);
        Call<List<SimilarRecipeResponse>> call = callsimilarRecipes.callSimilarRecipe(id, "15", context.getString(R.string.apikey));
        call.enqueue(new Callback<List<SimilarRecipeResponse>>() {
            @Override
            public void onResponse(Call<List<SimilarRecipeResponse>> call, Response<List<SimilarRecipeResponse>> response) {
                if (!response.isSuccessful()) {
                    listner.didError(response.message());
                    return;
                }
                listner.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<List<SimilarRecipeResponse>> call, Throwable t) {
                listner.didError(t.getMessage());
            }
        });
    }

    public void getRecipeDetails(RecipeDetailListner listner, int id) {
        CallRecipeDetails callRecipeDetails = retrofit.create(CallRecipeDetails.class);
        Call<RecipeDetailResponse> call = callRecipeDetails.callRecipeDetails(id, context.getString(R.string.apikey));
        call.enqueue(new Callback<RecipeDetailResponse>() {
            @Override
            public void onResponse(Call<RecipeDetailResponse> call, Response<RecipeDetailResponse> response) {
                if (!response.isSuccessful()) {
                    listner.didError(response.message());
                    return;
                }
                listner.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RecipeDetailResponse> call, Throwable t) {
                listner.didError(t.getMessage());
            }
        });
    }

    public void getInstructions(InstructionListner listner, int id) {
        System.out.println("hello");
        CallInstruction callInstruction = retrofit.create(CallInstruction.class);
        Call<List<InstructionsResponse>> call = callInstruction.callInstruction(id, context.getString(R.string.apikey));
        System.out.println("request urlk: " + call.request().url().toString());
        call.enqueue(new Callback<List<InstructionsResponse>>() {
            @Override
            public void onResponse(Call<List<InstructionsResponse>> call, Response<List<InstructionsResponse>> response) {
                if (!response.isSuccessful()) {
                    listner.didError(response.message());
                    System.out.println("welcome");
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(response.body());
                    return;
                }
                listner.didFetch(response.body(), response.message());
                System.out.println(response.body());
                System.out.println("RequestManager.onResponse" + response.body());
            }

            @Override
            public void onFailure(Call<List<InstructionsResponse>> call, Throwable t) {
                System.out.println("RequestManager.onResponse");
                listner.didError(t.getMessage());
            }
        });
    }

    private interface CallRandomRecipes {
        @GET("recipes/random")
        Call<RandomRecipesApiResponse> callrandomrecipes(
                @Query("apiKey") String apiKey,
                @Query("number") String number,
                @Query("tags") List<String> tags
        );
    }

    private interface CallRecipeDetails {

        @GET("recipes/{id}/information")
        Call<RecipeDetailResponse> callRecipeDetails(
                @Path("id") int id,
                @Query("apiKey") String apiKey
        );
    }

    private interface CallsimilarRecipes {
        @GET("recipes/{id}/similar")
        Call<List<SimilarRecipeResponse>> callSimilarRecipe(
                @Path("id") int id,
                @Query("number") String number,
                @Query("apiKey") String apikey
        );

    }

    private interface CallInstruction {
        @GET("recipes/{id}/analyzedInstructions")
        Call<List<InstructionsResponse>> callInstruction(
                @Path("id") int id,
                @Query("apiKey") String apikey

        );
    }
}
