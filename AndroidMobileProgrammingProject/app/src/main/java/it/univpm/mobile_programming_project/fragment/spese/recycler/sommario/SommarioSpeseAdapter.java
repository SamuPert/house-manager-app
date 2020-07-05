package it.univpm.mobile_programming_project.fragment.spese.recycler.sommario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Locale;

import it.univpm.mobile_programming_project.R;
import it.univpm.mobile_programming_project.fragment.spese.recycler.SpeseAdapter;
import it.univpm.mobile_programming_project.fragment.spese.recycler.view_holder.SpesaViewHolder;
import it.univpm.mobile_programming_project.models.Spesa;
import it.univpm.mobile_programming_project.utils.Helper;
import it.univpm.mobile_programming_project.utils.recycler_view.RecyclerViewClickListener;

public class SommarioSpeseAdapter extends SpeseAdapter {


    public SommarioSpeseAdapter(List<Spesa> listaSpese, RecyclerViewClickListener listener) {
        super(listaSpese, listener);
    }

    @NonNull
    @Override
    public SpesaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_spesa, parent, false);
        return new SpesaViewHolder(view, this.listener, this);
    }

    @Override
    public void onBindViewHolder(SpesaViewHolder holder, int position) {
        Spesa spesa = this.getSpesa(position);

        holder.nomePlaceholder.setText( spesa.getNome() );
        holder.descrizionePlaceholder.setText( spesa.getDescrizione() );
        holder.tipoPlaceholder.setText( spesa.getTipo() );
        holder.dataInserimentoPlaceholder.setText(Helper.formatDateToString(spesa.getDataInserimento()) );
        holder.dataPagamentoPlaceholder.setText(Helper.formatDateToString(spesa.getDataPagamento()) );
        holder.prezzoPlaceholder.setText( String.format(Locale.ITALIAN, "%f€", spesa.getPrezzo()) );

        if( spesa.getDataPagamento() == null ) {
            // NON PAGATA
            holder.txtPagata.setVisibility(View.GONE);
            holder.txtNonPagata.setVisibility(View.VISIBLE);
            holder.btnPaga.setVisibility(View.VISIBLE);
        }else{
            //PAGATA
            holder.txtPagata.setVisibility(View.VISIBLE);
            holder.txtNonPagata.setVisibility(View.GONE);
            holder.btnPaga.setVisibility(View.GONE);
        }
    }


}
