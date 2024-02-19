package com.example.quickmeal.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickmeal.Models.Ingredient;
import com.example.quickmeal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstructionIngredientAdapter extends RecyclerView.Adapter<InstructionIngredientViewHolder>{

    Context context;
    List<Ingredient> list;

    public InstructionIngredientAdapter(Context context, List<Ingredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InstructionIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionIngredientViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instruction_step_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionIngredientViewHolder holder, int position) {

        holder.textview_instructions_step_items.setText(list.get(position).name);
        holder.textview_instructions_step_items.setSelected(true);
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/"+list.get(position).image).into(holder.imageview_instructions_step_items);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class InstructionIngredientViewHolder extends RecyclerView.ViewHolder{

    ImageView imageview_instructions_step_items;
    TextView  textview_instructions_step_items;

    public InstructionIngredientViewHolder(@NonNull View itemView) {
        super(itemView);

        imageview_instructions_step_items = itemView.findViewById(R.id.imageview_instructions_step_items);
        textview_instructions_step_items = itemView.findViewById(R.id.textview_instructions_step_items);

    }
}
