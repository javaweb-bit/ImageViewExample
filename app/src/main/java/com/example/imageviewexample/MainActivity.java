package com.example.imageviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //  컨트롤 연결
    private TextView textView;
    private ImageView imageView;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        imageView = findViewById(R.id.imageView);
        //  이미지 뷰의 scaleType을 변경
        imageView.setScaleType(ImageView.ScaleType.values()[0]);
        //  현재 이미지 뷰의 scaleType 확인
        textView.setText(imageView.getScaleType().name());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "ImageView Click!",
                        Toast.LENGTH_LONG)
                        .show();
                index++;
                int length = ImageView.ScaleType.values().length;
                if (index >= ImageView.ScaleType.values().length) {
                    index = 0;
                }
                //  새로운 ScaleType으로 변경, 설정
                ImageView.ScaleType newType = ImageView.ScaleType.values()[index];
                imageView.setScaleType(newType);
                textView.setText(newType.name());
            }
        });
    }
}