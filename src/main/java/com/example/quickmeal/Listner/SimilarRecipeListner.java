package com.example.quickmeal.Listner;

import com.example.quickmeal.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipeListner {
    void didFetch(List<SimilarRecipeResponse> response,String message);
    void didError(String message);

}
