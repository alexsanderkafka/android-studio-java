package com.example.kafkatech.slider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        /*
        //forma simples de criar um slide
        addSlide(new SimpleSlide.Builder()
                        .title("Titulo")
                        .description("Descricao")
                        .image(R.drawable.um)
                        .background(android.R.color.holo_orange_dark)
                        .build()
        );

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 2")
                .description("Descricao 2")
                .image(R.drawable.dois)
                .background(android.R.color.holo_orange_light)
                .build()
        );

        addSlide(new SimpleSlide.Builder()
                .title("Titulo 3")
                .description("Descricao 3")
                .image(R.drawable.tres)
                .background(android.R.color.holo_orange_light)
                .build()
        );*/

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_orange_dark)
                .backgroundDark(android.R.color.holo_orange_light)
                .fragment(R.layout.intro_1)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_orange_dark)
                .backgroundDark(android.R.color.holo_orange_light)
                .fragment(R.layout.intro_2)
                .build()
        );
    }
}