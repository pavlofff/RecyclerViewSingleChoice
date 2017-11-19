package com.example.pavel.recyclerviewsinglechoice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class SingleChoiceAdapter extends RecyclerView.Adapter<SingleChoiceAdapter.ItemHolder> {

    ArrayList<String> items;
    int checkedPosition = -1;

    public SingleChoiceAdapter (ArrayList<String> items){
        this.items = items;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ItemHolder holder = new ItemHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {
        holder.text.setText(items.get(position));
        holder.checkBox.setChecked(position == checkedPosition);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setCheckedPosition (int position){
        checkedPosition = position;
        notifyDataSetChanged();
    }

    public int getChecedPosition (){
        return checkedPosition;
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text;
        CheckBox checkBox;

        ItemHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            checkBox = itemView.findViewById(R.id.checkBox);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

                checkedPosition = checkBox.isChecked() ? -1: getAdapterPosition();
                notifyDataSetChanged();

        }
    }
}
