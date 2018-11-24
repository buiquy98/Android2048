package com.example.buiqu.game2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
private GridView gridViewGamePlay;
private OSoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        khoiTao();
        setData();
    }
    private void anhXa()
    {
        gridViewGamePlay = (GridView)findViewById(R.id.gVGamePlay);
    }
    private void khoiTao()
    {
        Data.getData().inIt(MainActivity.this);
        adapter = new OSoAdapter(MainActivity.this,0,Data.getData().getArrayList());
    }
    private void  setData()
    {
        gridViewGamePlay.setAdapter(adapter);
    }
}
