package saulodev.com.integrationproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.model.CardOffers;
import saulodev.com.integrationproject.model.KeyModel;

public class ListAdapterCobrar extends RecyclerView.Adapter<ListAdapterCobrar.ListViewHolder>{
    private Context context;
    private ArrayList<KeyModel> keyList;

    public ListAdapterCobrar(Context context, ArrayList<KeyModel> keyList){
        this.context = context;
        this.keyList = keyList;
    }

    @NonNull
    @Override
    public ListAdapterCobrar.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_card_cobrar, parent, false);
        return new ListAdapterCobrar.ListViewHolder(viewInflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterCobrar.ListViewHolder holder, int position) {
        KeyModel keyModel = keyList.get(position);
        holder.binds(keyModel);
    }

    @Override
    public int getItemCount() {
        return keyList.size();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    public class ListViewHolder extends RecyclerView.ViewHolder{

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void binds(KeyModel keyModel) {
            fillField(keyModel);
        }

        private void fillField(KeyModel keyModel) {

        }
    }
}

