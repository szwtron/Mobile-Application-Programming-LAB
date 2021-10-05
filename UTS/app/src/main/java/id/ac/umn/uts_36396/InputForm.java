package id.ac.umn.uts_36396;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputForm extends AppCompatActivity {
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_form);
        getSupportActionBar().hide();
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputLogin = (EditText) findViewById(R.id.inputLogin);
                String username = inputLogin.getText().toString();

                if(username.isEmpty()){
                    inputLogin.setError("Harap Di-isi");
                } else {
                    Intent libraryActivity = new Intent(InputForm.this, LibraryActivity.class);
                    libraryActivity.putExtra("username", username);
                    startActivity(libraryActivity);
                }
            }
        });

    }
}