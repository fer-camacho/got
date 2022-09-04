package com.example.got;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {
    private List<Personaje> personajes;
    private OnItemClickListener onItemClickListener;

    public PersonajeAdapter(List<Personaje> personajes, OnItemClickListener onItemClickListener) {
        this.personajes = personajes;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //retornar una instancia de ExamenViewHolder
        View itemPersonaje = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(itemPersonaje);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        //darle funcionalidad a partir de la posicion, trae info del item
        holder.imgItem.setImageResource(personajes.get(position).getImgResource());
        holder.tvFullName.setText(personajes.get(position).getFullName());
        holder.tvFamily.setText(personajes.get(position).getFamily());
        holder.tvFirstName.setText(personajes.get(position).getFirstName());
        holder.tvLastName.setText(personajes.get(position).getLastName());
        holder.tvTitle.setText(personajes.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(personajes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de items que se trajeron
        return personajes.size();
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView tvFullName;
        private TextView tvFamily;
        private TextView tvFirstName;
        private TextView tvLastName;
        private TextView tvTitle;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgItem = itemView.findViewById(R.id.imgItem);
            this.tvFullName = itemView.findViewById(R.id.tvFullName);
            this.tvFamily = itemView.findViewById(R.id.tvFamily);
            this.tvFirstName = itemView.findViewById(R.id.tvFirstName);
            this.tvLastName = itemView.findViewById(R.id.tvLastName);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

    interface OnItemClickListener {
        void onItemClick(Personaje personaje); //al hacer click recibe un personaje
    }
}
