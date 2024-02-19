package com.example.quickmeal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickmeal.Models.Equipment;
import com.example.quickmeal.Models.Ingredient;
import com.example.quickmeal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstructionequipmentAdapter extends RecyclerView.Adapter<InstructionequipmentViewHolder> {

    Context context;
    List<Equipment> list;

    public InstructionequipmentAdapter(Context context, List<Equipment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InstructionequipmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionequipmentViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instruction_step_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionequipmentViewHolder holder, int position) {

        holder.textview_instructions_step_items.setText(list.get(position).name);
        holder.textview_instructions_step_items.setSelected(true);
        Picasso.get().load("https://spoonacular.com/cdn/equipment_100x100/" + list.get(position).image).into(holder.imageview_instructions_step_items);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class InstructionequipmentViewHolder extends RecyclerView.ViewHolder {

    ImageView imageview_instructions_step_items;
    TextView textview_instructions_step_items;

    public InstructionequipmentViewHolder(@NonNull View itemView) {
        super(itemView);

        imageview_instructions_step_items = itemView.findViewById(R.id.imageview_instructions_step_items);
        textview_instructions_step_items = itemView.findViewById(R.id.textview_instructions_step_items);

    }
}
