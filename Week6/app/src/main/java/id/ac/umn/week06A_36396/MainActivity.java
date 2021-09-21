package id.ac.umn.week06A_36396;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnProperty = findViewById(R.id.property);
        Button btnDrawables = findViewById(R.id.drawables);
        Button btnFisika = findViewById(R.id.fisika);

        btnProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProperty = new Intent(MainActivity.this, property.class);
                startActivity(intentProperty);
            }
        });

        btnDrawables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProperty = new Intent(MainActivity.this, drawables.class);
                startActivity(intentProperty);
            }
        });

        btnFisika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProperty = new Intent(MainActivity.this, fisika.class);
                startActivity(intentProperty);
            }
        });
    }
}