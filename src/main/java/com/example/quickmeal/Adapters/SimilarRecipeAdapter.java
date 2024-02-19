package com.example.quickmeal.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickmeal.Listner.RecipeClickListner;
import com.example.quickmeal.Models.SimilarRecipeResponse;
import com.example.quickmeal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SimilarRecipeAdapter extends  RecyclerView.Adapter<SimilarRecipeViewHolder>{

    Context context;
    List<SimilarRecipeResponse> list;
    RecipeClickListner listner;

    public SimilarRecipeAdapter(Context context, List<SimilarRecipeResponse> list, RecipeClickListner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    @NonNull
    @Override
    public SimilarRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimilarRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_similar_recipe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarRecipeViewHolder holder, int position) {

        holder.txtview_similar_title.setText(list.get(position).title);
        holder.txtview_similar_title.setSelected(true);
        holder.txtview_similar_serving.setText(list.get(position).servings+"Persons");
        Picasso.get().load("https://spoonacular.com/recipeImages/"+list.get(position).id+"-556x370."+list.get(position).imageType).into(holder.imageview_similar);

        holder.similar_recipe_holder.setOnClickListener(new View.OnClickListener() {
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
class SimilarRecipeViewHolder extends RecyclerView.ViewHolder {

    CardView similar_recipe_holder;
    TextView txtview_similar_title,txtview_similar_serving;
    ImageView imageview_similar;

    public SimilarRecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        similar_recipe_holder = itemView.findViewById(R.id.similar_recipe_holder);
        txtview_similar_title = itemView.findViewById(R.id.txtview_similar_title);
        txtview_similar_serving = itemView.findViewById(R.id.txtview_similar_serving);
        imageview_similar = itemView.findViewById(R.id.imageview_similar);
    }
}

