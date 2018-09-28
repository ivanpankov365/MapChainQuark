package com.example.franck.mapchain;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franck.mapchain.models.ContractModel;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{
    List<ContractModel> persons;
    private Context context;

    public RVAdapter(Context context) {
        this.context = context;
    }

    RVAdapter(List<ContractModel> persons, Context context){
        this.context = context;
        this.persons = persons;
    }
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_vide, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText("Quest - " + persons.get(i).getId()+"");
        personViewHolder.personAge.setText("Description: " + persons.get(i).getDescription() + "; ");
        personViewHolder.price.setText("Price - " + persons.get(i).getPrice());

        personViewHolder.setOnClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean bool) {
                Log.d("tah",position+"");
                Intent intent = new Intent(context, MapActivity.class);
                intent.putExtra("MyClass", persons.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cv;
        TextView personName;
        TextView personAge;
        TextView price;
        ItemClickListener itemClickListener;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            price = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        public void setOnClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

}
