package com.example.buiqu.game2048_2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Data_Game {
    // các biến có trong game

    private static Data_Game dataGame;

    //constructor
    static {
        dataGame = new Data_Game();
    }

    private int soO = 14, score = 100, point;
    private ArrayList<Integer> mangGame = new ArrayList<>();
    private int[][] array = new int[4][4];
    private int[] arrayColor;
    private Random r = new Random();

    public static Data_Game getDataGame() {
        return dataGame;
    }

    //khởi tạo phần tử cho mảng 2 chiều
    public void create(Context context) {
        soO=16;
        score=0;
        this.point=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = 0;
                mangGame.add(0);
            }
        }
        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.colorTiles);
        arrayColor = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            arrayColor[i] = typedArray.getColor(i, 0);
        }
        typedArray.recycle();
        createRandomNumber();
        setArray_To_mangGame();
    }

    public ArrayList<Integer> getMangGame() {
        return mangGame;
    }

    //set color cho các ô số
    //set color lỗi chỗ này
    // khi n!=0 xuống ra index sai
    // tao text thử n>=0 để k chạy khúc dưới
    public int setColor(int n) {
        if (n ==0) {
            return Color.WHITE;
        } else {
            int i = (int) (Math.log(n) / Math.log(2));
            return i = arrayColor[i - 1];
        }
    }

    //tạo số ngẫu nhiên
    public void createRandomNumber()
    {
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] == 0) {
                    n++;
                }
            }
        }
        int so = 1;
        if (n == 0) {
            so = 0;
        }
        while (so != 0) {
            int x = r.nextInt(2), y = r.nextInt(2);
            if (array[x][y] == 0) {
                array[x][y] = 2;
                --so;
            }
        }
    }

    //gáng các phần tử đã tạo trong array vào mangGame
    public void setArray_To_mangGame() {
        mangGame.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mangGame.add(array[i][j]);
            }
        }
    }

    public void vuotTrai() {
        soO = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = array[i][j];
                if (h == 0)
                {
                    continue;
                } else {
                    int st = j + 1;
                    for (int k = st; k < 4; k++) {
                        int g = array[i][k];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            array[i][j] = 2 * h;
                            array[i][k] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = array[i][j];
                if (h != 0) {
                    continue;
                } else {
                    for (int k = j + 1; k < 4; k++) {
                        if (array[i][k] == 0) {
                            continue;
                        } else {
                            array[i][j] = array[i][k];
                            this.point+=(int) array[i][k];
                            array[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        createRandomNumber();
        setArray_To_mangGame();

    }

    public void vuotPhai() {
        soO = 0;
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                int h = array[i][j];
                if (h == 0) {

                    continue;
                } else {
                    int st = j - 1;
                    for (int k = st; k >= 0; k--) {
                        int g = array[i][k];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            array[i][j] = 2 * h;
                            array[i][k] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                int h = array[i][j];
                if (h != 0) {
                    continue;
                } else {
                    for (int k = j - 1; k >= 0; k--) {
                        if (array[i][k] == 0) {
                            continue;
                        } else {
                            array[i][j] = array[i][k];
                            this.point+=(int) array[i][k];
                            array[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }


        createRandomNumber();
        setArray_To_mangGame();

    }

    public void vuotLen() {
        soO = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = array[j][i];
                if (h == 0) {

                    continue;
                } else {
                    int st = j + 1;
                    for (int k = st; k < 4; k++) {
                        int g = array[k][i];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            array[j][i] = 2 * h;
                            array[k][i] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int h = array[j][i];
                if (h != 0) {
                    continue;
                } else {
                    for (int k = j + 1; k < 4; k++) {
                        if (array[k][i] == 0) {
                            continue;
                        } else {
                            array[j][i] = array[k][i];
                            this.point+=(int) array[k][i];
                            array[k][i] = 0;
                            break;
                        }
                    }
                }

            }
        }


        createRandomNumber();
        setArray_To_mangGame();

    }

    public void vuotXuong() {
        soO = 0;

        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                int h = array[j][i];
                if (h == 0) {

                    continue;
                } else {
                    int st = j - 1;
                    for (int k = st; k >= 0; k--) {
                        int g = array[k][i];
                        if (g == 0) {
                            continue;
                        } else if (g == h) {
                            array[j][i] = 2 * h;
                            array[k][i] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                int h = array[j][i];
                if (h != 0) {
                    continue;
                } else {
                    for (int k = j - 1; k >= 0; k--) {
                        if (array[k][i] == 0) {
                            continue;
                        } else {
                            array[j][i] = array[k][i];
                            this.point+=(int) array[k][i];
                            array[k][i] = 0;
                            break;
                        }
                    }
                }

            }
        }

        createRandomNumber();
        setArray_To_mangGame();

    }

    //POINT
    public int setPoint()
    {
        return point;

    }


    public int getPoint()
    {
        return this.point;
    }

    //MAX
    public int getMax() {
        this.score=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] == 0) {
                    soO++;
                }
                if(this.score<array[i][j]){
                    this.score=array[i][j];
                }
            }
        }
        return score;
    }
    public void setMax(int score) {
        this.score = score;
    }


}
