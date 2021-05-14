package fpt.gstpro.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class HeroInfomation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_infomation);
        Intent parent = getIntent();

        String name = parent.getStringExtra("name");
        String realName = parent.getStringExtra("realName");
        String team = parent.getStringExtra("team");
        String createdBy = parent.getStringExtra("createdBy");
        int firstAppearance = parent.getIntExtra("firstAppearance", 0);
        String publisher = parent.getStringExtra("publisher") ;
        String imageUrl = parent.getStringExtra("imageUrl") ;
        String bio = parent.getStringExtra("bio");
        ImageView img = findViewById(R.id.imgAvatar);
//        Glide.with(this)
//                .load(imageUrl)
//                .centerCrop()
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(img);
    }
}