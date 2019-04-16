package com.mystudydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayDeque;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    View imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageView = findViewById(R.id.aaa);
//        MaterialEditText editText = findViewById(R.id.testview);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        Log.i(".getWidth()", imageView.getWidth() + "getWidth");
//        Log.i(".getWidth()", imageView.getLeft() + "getLeft");
//        Log.i(".getWidth()", imageView.getRight() + "getRight");
//        Log.i(".getWidth()", imageView.getTop() + "getTop");
//        Log.i(".getWidth()", imageView.getBottom() + "getBottom");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    //    private void sort() {
//        for (int i = j.length - 1; i >= 0; i--) {
//            if (i != 0) {
//                int index = new Random().nextInt(i);
//                int temp = j[index];
//                j[index] = j[i];
//                j[i] = temp;
//                Log.i("as", temp + "");
//            } else {
//                Log.i("as", j[0] + "");
//            }
//        }
//    }
}
