package com.example.kafkatech.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonInicar;
    private int i;
    private Handler handler = new Handler();
    private boolean pararExecucao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInicar = findViewById(R.id.buttonIniciar);
    }

    public void inicarThread(View view) throws InterruptedException {

        /*
        for(int i = 0; i <= 15; i++){
                  Log.d("Thread", "Contador: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        MyThread myThread = new MyThread();
        myThread.start();*/

        pararExecucao = false;
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();


    }

    public void pararThread(View view){
        pararExecucao = true;
    }

    public class MyRunnable implements Runnable{
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            // Não é possivel alterar a interface com uma thread criada pelo dev
            // É preciso usar a UI

            for(i = 0; i <= 15; i++){

                if (pararExecucao)
                    return;
                Log.d("Thread", "Contador: " + i);

                /*
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        buttonInicar.setText("Contador: " + i);
                    }
                });*/

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        buttonInicar.setText("Contador: " + i);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        }
    }

    public class MyThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i <= 15; i++){
                Log.d("Thread", "Contador: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}