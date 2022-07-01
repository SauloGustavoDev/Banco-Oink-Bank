package saulodev.com.integrationproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import saulodev.com.integrationproject.R;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historico_adapter,parent,false);
        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomepagamento.setText("pix - pagamento");
        holder.valorpagamento.setText("25,99");
        holder.datapagamento.setText("21/08/2020");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomepagamento;
        TextView valorpagamento;
        TextView datapagamento;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomepagamento = itemView.findViewById(R.id.nomepagamento_txt);
            valorpagamento = itemView.findViewById(R.id.valorpagamento_txt);
            datapagamento = itemView.findViewById(R.id.datapagamento_txt);
        }
    }

}
