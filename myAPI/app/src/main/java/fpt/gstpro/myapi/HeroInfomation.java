package fpt.gstpro.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


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

        TextView lbName = findViewById(R.id.lbName);
        TextView lbRealName = findViewById(R.id.lbRealName);
        TextView lbTeam = findViewById(R.id.lbTeam);
        TextView lbCreatedBy = findViewById(R.id.lbCreatedBy);
        TextView lbFirstAppearance = findViewById(R.id.lbFirstAppearance);
        TextView lbPublisher = findViewById(R.id.lbPublisher);
        ImageView img = findViewById(R.id.imageView);
        TextView lbBio = findViewById(R.id.lbBio);

        lbName.setText(name);
        lbRealName.setText(realName);
        lbTeam.setText(team);
        lbCreatedBy.setText(createdBy);
        lbFirstAppearance.setText(Integer.toString(firstAppearance));
        lbPublisher.setText(publisher);
        lbBio.setText(bio);
        Glide.with(this)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(img);

    }
}