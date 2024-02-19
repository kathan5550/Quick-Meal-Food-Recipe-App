package com.example.quickmeal.Listner;

import com.example.quickmeal.Models.RecipeDetailResponse;

public interface RecipeDetailListner {

        void didFetch(RecipeDetailResponse response,String message);
        void didError(String message);

}
