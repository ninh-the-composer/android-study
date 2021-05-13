package fpt.gstpro.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goJSONPlaceholderPosts(View v){
        Intent intent = new Intent(this, JSONPlaceholderPostsActivity.class);
        startActivity(intent);
    }

    public void goHeroesMarvel(View v){
        Intent intent = new Intent(this, HeroesMarvelActivity.class);
        startActivity(intent);
    }


}