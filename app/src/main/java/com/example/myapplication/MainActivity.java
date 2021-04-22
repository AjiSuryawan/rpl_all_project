package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    // we user ArrayList to populate data in RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);

        addData();

        adapter = new MahasiswaAdapter(mahasiswaArrayList, new MahasiswaAdapter.Callback() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "click item "+position, Toast.LENGTH_SHORT).show();
                Intent move = new Intent(getApplicationContext(),DetailActivity.class);
                Mahasiswa mymahasiswa = mahasiswaArrayList.get(position);
                move.putExtra("nama", mymahasiswa.getNama());
                move.putExtra("nim", mymahasiswa.getNim());
                move.putExtra("hp", mymahasiswa.getNohp());
                move.putExtra("email", mymahasiswa.getEmail());
                startActivity(move);
            }
        });
        //selesai ngatur data dari adapter, kemudian di tempel ke Recyclerview nya
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Dimas Maulana", "999", "081222","email"));
        mahasiswaArrayList.add(new Mahasiswa("Budi", "000", "081222", "email"));
        mahasiswaArrayList.add(new Mahasiswa("Ani", "222", "083333", "email budi"));
        Mahasiswa Sari = new Mahasiswa("Sari", "xxx" , "000", "sari@gmail.com");
        mahasiswaArrayList.add(Sari);
    }
}