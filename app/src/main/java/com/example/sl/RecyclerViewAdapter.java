package com.example.sl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sl.databinding.ItemDesignBinding;
import com.example.sl.model.AnnonceEntity;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<AnnonceEntity> list;

    public RecyclerViewAdapter(List<AnnonceEntity> list){
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
        holder.binding.priceView.setText(list.get(position).getPrice());
        //holder.binding.dateView.setText(list.get(position).getDate());
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
