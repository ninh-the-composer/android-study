package fpt.gstpro.logintrainee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;

    /**
     * Anonymous implementation of TextWatcher
     */
    private TextWatcher onChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            btnLogin.setEnabled(txtUsername.getText().toString().trim().length() != 0
                    && txtPassword.getText().toString().trim().length() != 0);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void onClick(View v) {
        if (txtUsername.getText().toString().trim().equals("NinhTBM")
                && txtPassword.getText().toString().trim().equals("1234")) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.putExtra("username", txtUsername.getText().toString() );
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        txtUsername.addTextChangedListener(onChangedListener);
        txtPassword.addTextChangedListener(onChangedListener);
    }
}