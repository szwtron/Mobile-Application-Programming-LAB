package id.ac.umn.uts_36396;

import android.net.Uri;

import java.io.Serializable;

public class SongSource implements Serializable {
    private String judul;
    private String kategori;
    private String songUri;

    public SongSource(String judul, String kategori, String songUri) {
        this.judul = judul;
        this.kategori = kategori;
        this.songUri = songUri;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getSongUri() {
        return songUri;
    }

    public void setSongUri(String songUri) {
        this.songUri = songUri;
    }
}
