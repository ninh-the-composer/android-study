package fpt.gstpro.myapi.service;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import fpt.gstpro.myapi.HeroInfomation;
import fpt.gstpro.myapi.R;
import fpt.gstpro.myapi.model.Hero;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<Hero> heroes;

    public HeroAdapter(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView lbHeroName;
        public final ImageView imgAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
            lbHeroName = itemView.findViewById(R.id.lbHeroName);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
        }
    }

    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.marvel_hero_item, viewGroup, false);
        return new HeroAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HeroAdapter.ViewHolder viewHolder, int i) {
        Hero hero = heroes.get(i);

        viewHolder.lbHeroName.setText(hero.getName());
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher)
                .dontAnimate()
                .onlyRetrieveFromCache(true);
        Glide.with(viewHolder.itemView.getContext()).load(hero.getImageUrl()).apply(options).into(viewHolder.imgAvatar);

        viewHolder.lbHeroName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HeroInfomation.class);
                intent.putExtra("name", hero.getName());
                intent.putExtra("realName", hero.getRealName());
                intent.putExtra("team", hero.getTeam());
                intent.putExtra("createdBy", hero.getCreatedBy());
                intent.putExtra("firstAppearance", hero.getFirstAppearance());
                intent.putExtra("publisher", hero.getPublisher());
                intent.putExtra("imageUrl", hero.getImageUrl());
                intent.putExtra("bio", hero.getBio());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes != null ? heroes.size() : 0;
    }

}
