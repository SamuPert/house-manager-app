package it.univpm.mobile_programming_project.fragment.spese.recycler.view_holder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import it.univpm.mobile_programming_project.R;
import it.univpm.mobile_programming_project.fragment.spese.recycler.SpeseAdapter;
import it.univpm.mobile_programming_project.utils.recycler_view.RecyclerViewClickListener;

public class SpesaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final RecyclerViewClickListener listener;
    private final SpeseAdapter adapter;
    public TextView nomePlaceholder;
    public TextView descrizionePlaceholder;
    public TextView tipoPlaceholder;
    public TextView dataInserimentoPlaceholder;
    public TextView dataPagamentoPlaceholder;
    public TextView prezzoPlaceholder;

    public TextView txtPagata;
    public TextView txtNonPagata;
    public Button btnPaga;

    public SpesaViewHolder(View itemView, RecyclerViewClickListener listener, SpeseAdapter adapter) {
        super(itemView);
        this.listener = listener;
        this.adapter = adapter;

        nomePlaceholder = itemView.findViewById(R.id.txtNomeSpesa);
        descrizionePlaceholder = itemView.findViewById(R.id.txtDescrizioneSpesa);
        tipoPlaceholder = itemView.findViewById(R.id.txtTipoSpesa);
        prezzoPlaceholder = itemView.findViewById(R.id.txtPrezzoSpesa);
        dataInserimentoPlaceholder = itemView.findViewById(R.id.txtDataInserimentoSpesa);
        dataPagamentoPlaceholder = itemView.findViewById(R.id.txtDataPagamentoSpesa);

        txtPagata = itemView.findViewById(R.id.txtPagata);
        txtNonPagata = itemView.findViewById(R.id.txtNonPagata);
        btnPaga = itemView.findViewById(R.id.btnPaga);

        btnPaga.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.listener.onClick(view, this.adapter.getSpesa(getAdapterPosition()));
    }

}