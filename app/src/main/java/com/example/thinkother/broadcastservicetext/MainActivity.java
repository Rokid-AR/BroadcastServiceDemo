package com.example.thinkother.broadcastservicetext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.android.Utils;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView1, imageView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.loadLibrary("opencv_java3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.mario);
        imageView1 = (ImageView) findViewById(R.id.image_view);
        button = (Button) findViewById(R.id.button);
        imageView1.setImageBitmap(img);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.mario);
        Mat source = new Mat();
        Mat dest = new Mat();
        Utils.bitmapToMat(img, source);

        Imgproc.cvtColor(source, dest, Imgproc.COLOR_RGB2GRAY);
        Bitmap btmp = Bitmap.createBitmap(dest.width(), dest.height(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(dest, btmp);
        imageView1.setImageBitmap(btmp);
    }
}
