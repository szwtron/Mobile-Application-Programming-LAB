package id.ac.umn.uts_36396;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetilLagu extends AppCompatActivity {
    private TextView etJudul, etKategori;
    private Button btnPlay;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_lagu);

        etJudul = (TextView) findViewById(R.id.etJudul);
        etKategori = (TextView) findViewById(R.id.etKategori);
        btnPlay = findViewById(R.id.playBtn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SongSource ss = (SongSource) bundle.getSerializable("DetilLagu");
        etJudul.setText(ss.getJudul());
        etKategori.setText(ss.getKategori());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(ss.getJudul());

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, Uri.parse(ss.getSongUri()));
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
    }

    public void releaseSFX() {
        mediaPlayer.stop();
        mediaPlayer.release();
        this.finish();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        mediaPlayer.release();
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                releaseSFX();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}