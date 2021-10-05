package id.ac.umn.uts_36396;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button profileBtn, libraryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profileBtn = findViewById(R.id.profileBtn);
        libraryBtn = findViewById(R.id.libraryBtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileActivity = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileActivity);
            }
        });

        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inputActivity = new Intent(MainActivity.this, InputForm.class);
                startActivity(inputActivity);
            }
        });
    }
}