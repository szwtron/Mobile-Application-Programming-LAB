package id.ac.umn.uts_36396;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {
    RecyclerView rvDaftarLagu;
    DaftarLaguAdapter mAdapter;
    LinkedList<SongSource> daftarLagu = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(username);

        Context context = getApplicationContext();
        CharSequence text = "Selamat datang, "+username;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        isiDaftarLagu();
        rvDaftarLagu = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarLaguAdapter(daftarLagu, this);
        rvDaftarLagu.setAdapter(mAdapter);
        rvDaftarLagu.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiDaftarLagu(){
        daftarLagu.add(new SongSource("Insect Buzz", "Insect", "android.resource://" +getPackageName() + "/"+ R.raw.insectbuzz));
        daftarLagu.add(new SongSource("Insect Buzz Laugh", "Insect", "android.resource://" +getPackageName() + "/"+ R.raw.insectbuzzlaugh));
        daftarLagu.add(new SongSource("Lion Roar", "Lion", "android.resource://" +getPackageName() + "/"+ R.raw.lionroar));
        daftarLagu.add(new SongSource("Wolf Howling", "Wolf", "android.resource://" +getPackageName() + "/"+ R.raw.wolfhowling));
        daftarLagu.add(new SongSource("Absolutely Perfect", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.absolutelyperfect));
        daftarLagu.add(new SongSource("CEEEEEEEEEEEEEEEEEB", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.ceeb));
        daftarLagu.add(new SongSource("Ding Ding", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.dingdingding));
        daftarLagu.add(new SongSource("Lakaad", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.lakaad));
        daftarLagu.add(new SongSource("The Next Level Play", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.nextlevelple));
        daftarLagu.add(new SongSource("Ni qi bu qi", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.niqibuqi));
        daftarLagu.add(new SongSource("Oy oy oy oy", "Dota", "android.resource://" +getPackageName() + "/"+ R.raw.oyoyoy));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profileMenu:
                Intent profileActivity = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(profileActivity);
                return true;
            case R.id.homeMenu:
                Intent mainActivity = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(mainActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}