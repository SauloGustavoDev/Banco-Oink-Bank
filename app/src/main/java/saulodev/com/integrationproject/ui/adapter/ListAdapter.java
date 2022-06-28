package saulodev.com.integrationproject.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.model.CardOffers;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context context;
    private ArrayList<CardOffers> listOffers;

    public ListAdapter(Context context, ArrayList<CardOffers> listOffers){
        this.context = context;
        this.listOffers = listOffers;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_card, parent, false);
        return new ListViewHolder(viewInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        CardOffers cardOffers = listOffers.get(position);
        holder.binds(cardOffers);
    }

    @Override
    public int getItemCount() {
        return listOffers.size();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    public class ListViewHolder extends RecyclerView.ViewHolder{

        public final ImageView imageCard;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCard = itemView.findViewById(R.id.imageView_btn);
        }

        public void binds(CardOffers cardOffers) {
            fillField(cardOffers);
        }

        private void fillField(CardOffers cardOffers) {
            imageCard.setImageResource(cardOffers.getOffer());
        }
    }
}
