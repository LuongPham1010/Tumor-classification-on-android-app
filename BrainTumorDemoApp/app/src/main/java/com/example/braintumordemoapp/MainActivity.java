package com.example.braintumordemoapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.braintumordemoapp.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;




public class MainActivity extends AppCompatActivity {
    private Button select, predict;
    private ImageView imageView;
    private TextView output;
    private Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        select = findViewById(R.id.select);
        predict = findViewById(R.id.predict);
        imageView = findViewById(R.id.imageView);
        output = findViewById(R.id.output);

        select.setOnClickListener((new View.OnClickListener() {


            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);


            }


        }));
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (img != null) {
                    img = Bitmap.createScaledBitmap(img, 150, 150, true);
                    try {
                        Model model = Model.newInstance(getApplicationContext());

                        // Creates inputs for reference.
                        TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 150, 150, 3}, DataType.FLOAT32);

                        TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                        tensorImage.load(img);
                        ByteBuffer byteBuffer = tensorImage.getBuffer();

                        inputFeature0.loadBuffer(byteBuffer);

                        // Runs model inference and gets result.
                        Model.Outputs outputs = model.process(inputFeature0);
                        TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                        // Use argmax to get the index of the maximum value
                        int predictedClass = argmax(outputFeature0.getFloatArray());

                        // Map index to class label
                        String[] classLabels = {"glioma", "meningioma", "no tumor", "pituitary"};
                        String resultLabel = classLabels[predictedClass];

                        // Display the result
                        output.setText(resultLabel);

                        // Releases model resources if no longer used.
                        model.close();
                    } catch (IOException e) {
                        // Handle the exception
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Please Select Image First", Toast.LENGTH_SHORT).show();
                }
            }

            // Function to find the index of the maximum value in an array
            private int argmax(float[] array) {
                int maxIndex = 0;
                float max = array[0];
                for (int i = 1; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                        maxIndex = i;
                    }
                }
                return maxIndex;
            }
        });


    }

    ;


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            if (uri != null) {
                try {
                    img = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    imageView.setImageBitmap(img);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "Failed to retrieve image URI", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

      /*protected  void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==100 && resultCode == RESULT_OK && data != null){
                imageView.setImageURI(data.getData());

                Uri uri = data.getData();

                try {
                    img=MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/






