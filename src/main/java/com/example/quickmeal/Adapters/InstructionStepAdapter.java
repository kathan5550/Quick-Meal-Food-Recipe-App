package com.example.quickmeal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickmeal.Models.Step;
import com.example.quickmeal.R;

import java.util.List;

public class InstructionStepAdapter extends RecyclerView.Adapter<InstructionStepViewHolder> {
    Context context;
    List<Step> list;

    public InstructionStepAdapter(Context context, List<Step> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InstructionStepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionStepViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions_steps,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionStepViewHolder holder, int position) {

        holder.txtview_instruction_step_number.setText(String.valueOf(list.get(position).number));
        holder.txtview_instruction_step_title.setText(list.get(position).step);

        holder.recycler_instructions_ingredients.setHasFixedSize(true);
        holder.recycler_instructions_ingredients.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        InstructionIngredientAdapter instructionIngredientAdapter = new InstructionIngredientAdapter(context,list.get(position).ingredients);
        holder.recycler_instructions_ingredients.setAdapter(instructionIngredientAdapter);

        holder.recycler_instructions_euipments.setHasFixedSize(true);
        holder.recycler_instructions_euipments.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        InstructionequipmentAdapter instructionequipmentAdapter = new InstructionequipmentAdapter(context,list.get(position).equipment);
        holder.recycler_instructions_euipments.setAdapter(instructionequipmentAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class InstructionStepViewHolder extends RecyclerView.ViewHolder{

    TextView txtview_instruction_step_number,txtview_instruction_step_title;
    RecyclerView recycler_instructions_euipments,recycler_instructions_ingredients;


    public InstructionStepViewHolder(@NonNull View itemView) {
        super(itemView);

        txtview_instruction_step_number= itemView.findViewById(R.id.txtview_instruction_step_number);
        txtview_instruction_step_title = itemView.findViewById(R.id.txtview_instruction_step_title);
        recycler_instructions_euipments = itemView.findViewById(R.id.recycler_instructions_euipments);
        recycler_instructions_ingredients = itemView.findViewById(R.id.recycler_instructions_ingredients);
    }
}
