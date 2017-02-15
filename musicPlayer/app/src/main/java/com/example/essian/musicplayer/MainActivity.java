package com.example.essian.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.essian.musicplayer.R.id.stop;

public class MainActivity extends AppCompatActivity {

  private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mediaPlayer = MediaPlayer.create(this, R.raw.sample);

        Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Log.i("player", "onClick: start");
            }
        });

        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mediaPlayer.pause();
                Log.i("sdsklaj", "onClick: pause");
            }
        });

        Button stop_player = (Button) findViewById(stop);
        stop_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    Log.i("asdjfkl", "onClick: stop");
                }
            }
        });

        TextView volumeUp = (TextView) findViewById(R.id.volumeup);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.setVolume(100, 100);
            }
        });
    }
}
