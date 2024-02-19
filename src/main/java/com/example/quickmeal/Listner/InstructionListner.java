package com.example.quickmeal.Listner;

import com.example.quickmeal.Models.InstructionsResponse;

import java.util.List;

public interface InstructionListner {

    void didFetch(List<InstructionsResponse> response, String message);

    void didError(String message);
}
