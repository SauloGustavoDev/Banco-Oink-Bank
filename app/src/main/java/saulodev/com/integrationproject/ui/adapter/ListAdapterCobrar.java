package saulodev.com.integrationproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.model.CardOffers;
import saulodev.com.integrationproject.model.KeyModel;

public class ListAdapterCobrar extends RecyclerView.Adapter<ListAdapterCobrar.ListViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(KeyModel keyModel);
    }

    private int globalPosition;

    private final Context context;
    private final ArrayList<KeyModel> keyList;

    private final OnItemClickListener listener;

    public ListAdapterCobrar(Context context, ArrayList<KeyModel> keyList, OnItemClickListener listener){
        this.context = context;
        this.keyList = keyList;

        this.listener = listener;
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
        holder.binds(keyModel, listener);

        /////////////////MARCAR SELECIONADO////////////////
        if(position==globalPosition)
        {
            holder.marcarSelecionado();
        }
        else
        {
            holder.desmarcarSelecionado();
        }
        /////////////////////////////////////////////////////
    }

    @Override
    public int getItemCount() {
        return keyList.size();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    public class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView type, description;
        private final ImageView checkImg;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.tipo_da_chave_txt);
            description = itemView.findViewById(R.id.conteudo_chave_txt);
            checkImg = itemView.findViewById(R.id.check_img);
        }

        public void binds(final KeyModel keyModel, final OnItemClickListener listener) {
            fillField(keyModel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(keyModel);

                    ///////////MARCAR SELECIONADO//////////
                    globalPosition = getAdapterPosition();
                    notifyDataSetChanged();
                    ////////////////////////////////////////
                }
            });
        }

        private void fillField(KeyModel keyModel) {
            type.setText(keyModel.getType());
            description.setText(keyModel.getDescription());
        }

        private void marcarSelecionado(){
            checkImg.setImageResource(R.drawable.ic_check);
        }

        private void desmarcarSelecionado(){
            checkImg.setImageResource(0);
        }
    }
}

