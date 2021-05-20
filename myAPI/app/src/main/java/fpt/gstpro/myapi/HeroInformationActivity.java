package fpt.gstpro.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;

import fpt.gstpro.myapi.databinding.ActivityHeroInformationBinding;
import fpt.gstpro.myapi.model.Hero;


public class HeroInformationActivity extends AppCompatActivity {

    ActivityHeroInformationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hero_information);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hero_information);
        Intent parent = getIntent();
        Hero hero = (Hero) parent.getSerializableExtra("hero");
        binding.setHero(hero);
        ImageView img = findViewById(R.id.imageView);
        Glide.with(this)
                .load(hero.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(img);

    }
}