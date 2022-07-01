package saulodev.com.integrationproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import saulodev.com.integrationproject.R;
import saulodev.com.integrationproject.model.Contato;

public class ContatosPixAdapter extends RecyclerView.Adapter<ContatosPixAdapter.MyViewHolder> {

    private List<Contato> listaContato;

    public ContatosPixAdapter(List<Contato> lista){
        this.listaContato = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contatoLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contatos_pix, parent, false);
        return new MyViewHolder(contatoLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contato contato = listaContato.get(position);
        holder.nome.setText(contato.getNome());
        holder.chave.setText(contato.getChave());
    }

    @Override
    public int getItemCount() {
        return listaContato.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView chave;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome_txt);
            chave = itemView.findViewById(R.id.chave_txt);
        }
    }

}
