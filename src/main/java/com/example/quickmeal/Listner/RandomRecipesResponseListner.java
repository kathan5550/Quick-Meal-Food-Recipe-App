package com.example.quickmeal.Listner;

import com.example.quickmeal.Models.RandomRecipesApiResponse;

public interface RandomRecipesResponseListner {
    void didfetch(RandomRecipesApiResponse response, String message);

    void didError(String message);

}
