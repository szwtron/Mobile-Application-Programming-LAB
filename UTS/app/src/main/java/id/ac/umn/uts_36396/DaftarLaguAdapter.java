package id.ac.umn.uts_36396;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarLaguAdapter extends RecyclerView.Adapter<DaftarLaguAdapter.ItemSongViewHolder> {
    private LinkedList<SongSource> mDaftarLagu;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarLaguAdapter(LinkedList<SongSource> mDaftarLagu, Context mContext) {
        this.mDaftarLagu = mDaftarLagu;
        this.mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    public DaftarLaguAdapter.ItemSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.sfx_item_layout, parent, false);
        return new ItemSongViewHolder(view, this);
    }

    public void onBindViewHolder(@NonNull DaftarLaguAdapter.ItemSongViewHolder holder, int position) {
        SongSource mSongSource = mDaftarLagu.get(position);
        holder.tvJudul.setText(mSongSource.getJudul());
        holder.tvKategori.setText(mSongSource.getKategori());
        holder.deleteSFX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarLagu.remove(mSongSource);
                notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return mDaftarLagu.size();
    }

    public class ItemSongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvJudul, tvKategori;
        private DaftarLaguAdapter mAdapter;
        private SongSource mSumberLagu;
        private int mPosisi;
        private ImageButton deleteSFX;

        public ItemSongViewHolder(@NonNull View itemView, DaftarLaguAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKategori = (TextView) itemView.findViewById(R.id.tvKategori);
            deleteSFX = itemView.findViewById(R.id.deleteSFX);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSumberLagu = mDaftarLagu.get(mPosisi);
            Intent detilInten = new Intent(mContext, DetilLagu.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetilLagu", mSumberLagu);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }
    }
}
