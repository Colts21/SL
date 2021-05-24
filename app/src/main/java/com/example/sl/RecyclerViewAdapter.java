package com.example.sl;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sl.databinding.ItemDesignBinding;
import com.example.sl.model.AnnonceEntity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<AnnonceEntity> list;

    private Context context;

    public RecyclerViewAdapter(Context context, List<AnnonceEntity> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDesignBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_design, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imageView1.setImageDrawable(list.get(position).getImage());
        holder.binding.titleView.setText(list.get(position).getTitle());
        holder.binding.priceView.setText(list.get(position).getPrice() + " €");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, AnnoncesDetails.class );
                i.putExtra("titre",list.get(position).getTitle());
                i.putExtra("Prix",list.get(position).getPrice());
                i.putExtra("Description",list.get(position).getDescription());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ItemDesignBinding binding;

        public ViewHolder(@NonNull ItemDesignBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
