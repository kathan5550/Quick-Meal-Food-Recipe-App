package com.example.quickmeal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickmeal.Listner.RecipeClickListner;
import com.example.quickmeal.Models.Recipe;
import com.example.quickmeal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipesAdapter extends RecyclerView.Adapter<RandomRecipesViewHolder>{

   Context context;
   List<Recipe> list;
   RecipeClickListner listner;

    public RandomRecipesAdapter(Context context, List<Recipe> list,RecipeClickListner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    @NonNull
    @Override
    public RandomRecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipesViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipesViewHolder holder, int position) {

        holder.textview_title.setText(list.get(position).title);
        holder.textview_title.setSelected(true);
        holder.textview_likes.setText(list.get(position).aggregateLikes+" Likes");
        holder.textview_serving.setText(list.get(position).servings+" Servings");
        holder.textview_time.setText(list.get(position).readyInMinutes+" Minutes");
        Picasso.get().load(list.get(position).image).into(holder.imageview_food);

        holder.Random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onRecipeClicked(String.valueOf(list.get(holder.getAdapterPosition()).id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomRecipesViewHolder extends RecyclerView.ViewHolder{

    CardView Random_list_container;
    TextView textview_title,textview_serving,textview_likes,textview_time;
    ImageView imageview_food;

    public RandomRecipesViewHolder(@NonNull View itemView) {
        super(itemView);

        Random_list_container=itemView.findViewById(R.id.Random_list_container);
        textview_title=itemView.findViewById(R.id.textview_title);
        textview_serving=itemView.findViewById(R.id.textview_serving);
        textview_likes=itemView.findViewById(R.id.textview_likes);
        textview_time=itemView.findViewById(R.id.textview_time);
        imageview_food=itemView.findViewById(R.id.imageview_food);

    }
}
