package fpt.gstpro.architecturestudy.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fpt.gstpro.architecturestudy.R;
import fpt.gstpro.architecturestudy.model.Country;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {

    private final List<Country> countries;
    private OnItemClickListener listener;
    public CountriesAdapter(){
        super();
        countries = new ArrayList<>();
    }

    public void updateCountries(List<Country> newCountries){
        countries.clear();
        countries.addAll(newCountries);
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.CountryViewHolder holder, int position) {
        holder.bind(countries.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        private final TextView lbName;
        private final TextView lbCapital;

        public CountryViewHolder(View itemView) {
            super(itemView);
            lbName = itemView.findViewById(R.id.lbName);
            lbCapital = itemView.findViewById(R.id.lbCapital);
        }

        public void bind(Country country, OnItemClickListener listener ){
            lbName.setText(country.getName());
            lbCapital.setText(country.getCapital());
            itemView.setOnClickListener(v -> listener.onItemClick(country));
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Country country);
    }
}
