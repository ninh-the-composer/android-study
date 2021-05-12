package fpt.gstpro.logintrainee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent parent = getIntent();
        String welcome = "Welcome, " + parent.getStringExtra("username");
        TextView lbWelcome = findViewById(R.id.lbWelcome);
        lbWelcome.setText(welcome);
    }

    public void onClick(View v){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        Toast.makeText(getBaseContext(), "Congratulation! u gei.", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}