package com.example.buiqu.game2048_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //một số biến có trong game
    private GridView gridViewGamePlay;
    private Tile_Adapter adapter;
    private View.OnTouchListener listener;
    private float x, y;
    private TextView txvPoint,txvMAX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setGridViewGamePlay();

        create();
        setData();

    }

    //set gridview,point, max
    private void setGridViewGamePlay() {
        gridViewGamePlay = (GridView) findViewById(R.id.gdvGamePlay);
        txvPoint =(TextView)findViewById(R.id.txvPoint);
        txvMAX =(TextView)findViewById(R.id.txvMax);
    }

    //khởi tạo data cho game
    private void create() {
        Data_Game.getDataGame().create(MainActivity.this);
        adapter = new Tile_Adapter(MainActivity.this, 0, Data_Game.getDataGame().getMangGame());
        listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = event.getX();
                        y = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (Math.abs(event.getX()-x)>Math.abs(event.getY()-y))
                        {
                            if (event.getX()>x)
                            {
                                Data_Game.getDataGame().vuotPhai();
                                adapter.notifyDataSetChanged();
                                //Toast.makeText(MainActivity.this,"VUOT PHAI",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Data_Game.getDataGame().vuotTrai();
                                adapter.notifyDataSetChanged();
                                //Toast.makeText(MainActivity.this,"VUOT TRAI",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            if (event.getY()>y)
                            {
                                Data_Game.getDataGame().vuotXuong();
                                adapter.notifyDataSetChanged();
                                //Toast.makeText(MainActivity.this,"VUOT XUONG",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Data_Game.getDataGame().vuotLen();
                                adapter.notifyDataSetChanged();
                                //Toast.makeText(MainActivity.this,"VUOT LEN",Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;
                }
                txvMAX.setText(""+Data_Game.getDataGame().getMax());
                txvPoint.setText(""+Data_Game.getDataGame().getPoint());
                return true;
            }
        };
    }

    //set data
    private void setData() {
        gridViewGamePlay.setAdapter(adapter);
        gridViewGamePlay.setOnTouchListener(listener);
    }

}
