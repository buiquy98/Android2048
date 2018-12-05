package com.example.buiqu.game2048_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class Tile_Adapter extends ArrayAdapter {

    private Context ct;
    private ArrayList<Integer> arr;

    public Tile_Adapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.item_tiles,null  );
        }
        if (arr.size()>0)
        {
            Tiles tiles = (Tiles)convertView.findViewById(R.id.txvTiles);
            tiles.setSizeSo(arr.get(position));
        }
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        arr=Data_Game.getDataGame().getMangGame();
        super.notifyDataSetChanged();
    }
}
