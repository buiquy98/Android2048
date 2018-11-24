package com.example.buiqu.game2048;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Data {
    private static Data data;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int[][] matrix = new int[4][4];
    private int[] matrixColor;
    private Random r= new Random();
    static {
        data = new Data();
    }

    public static Data getData() {
        return data;
    }

    public void inIt(Context context) {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                matrix[i][j]=0;
                arrayList.add(0);
            }
        }
        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.num_bg_color);
        matrixColor= new int[typedArray.length()];
        for (int i=0;i<typedArray.length();i++)
        {
            matrixColor[i]=typedArray.getColor(i,0);
        }
        typedArray.recycle();
        ranNum();
        chuyenDoi();
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }
    public int numColor(int num)
    {
        if (num==0)
        {
            return Color.WHITE;
        }
        else
        {
            int n = (int) (Math.log(num)/Math.log(2));
            return n=matrixColor[n-1];
        }
    }

    public void ranNum()
    {
        int n = 0;
//        for (int i=0;i<16;i++)
//        {
//            if (arrayList.get(i)==0) {
//                n++;
//            }
//            int soOTao;
//            if(n>0)
//            {
//                soOTao = r.nextInt(2)+1;
//            }
//            else {
//                if (n == 1) {
//                    soOTao = 1;
//                } else {
//                    soOTao = 0;
//                }
//            }
//            while (soOTao==0)
//                {
//                    i  = r.nextInt(4);
//                    int j = r.nextInt(4);
//                    if (matrix[i][j]==0)
//                    {
//                        matrix[i][j]=16;
//                        soOTao--;
//                    }
//                }
//        }
         for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] == 0) {
                    n++;
                }
            }
        }
        int so = 2;
        if (n == 1) {
            so = 1;
        } else if (n == 0) {
            so = 0;
        } else {
            so = 1 + r.nextInt(2);
        }
        while (so != 0) {
            int x = r.nextInt(4), y = r.nextInt(4);
            if (matrix[x][y] == 0) {
                int k = r.nextInt(46) + 10;
                if (k % 10 == 0) {
                    matrix[x][y] = 4;
                } else {
                    matrix[x][y] = 2;
                }
                so--;
            }
        }
    }

    public void chuyenDoi()
    {
        arrayList.clear();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                arrayList.add(matrix[i][j]);
            }
        }
    }
}