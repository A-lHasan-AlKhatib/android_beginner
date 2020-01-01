package com.example.tsc;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    ArrayList<Item> items;

    public ItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name, desc, price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.card_icon);
            name = itemView.findViewById(R.id.card_name);
            desc = itemView.findViewById(R.id.card_desc);
            price = itemView.findViewById(R.id.card_price);
            desc.setMovementMethod(new ScrollingMovementMethod());
        }

        public void bind(Item item) {
            name.setText(item.getName());
            if (item.getImg() != null) {
                String url = item.getImg();
             //   Picasso.get().load(url).into(img);
            } else
                img.setImageResource(R.drawable.lap_icon);

            //desc.setText(item.getDesc());
            price.setText(item.getPrice());
        }


    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}