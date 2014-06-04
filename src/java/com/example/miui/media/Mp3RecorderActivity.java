/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */
package com.example.miui.media;

import miui.app.Activity;
import miui.media.Mp3Recorder;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import com.example.miui.R;

public class Mp3RecorderActivity extends Activity implements View.OnClickListener {
    private static String TAG = "Mp3Recorder";
    private Mp3Recorder mRecorder;
    private MediaPlayer mPlayer;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private TextView mTextView;

    private static final String OUT_FILE_PATH = "/sdcard/1.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp3recorder_activity);

        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mTextView = (TextView) findViewById(R.id.txt_v);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
    }

    private static final int MSG_LOOP = 1;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOOP:
                    if (mRecorder != null && !mRecorder.isPaused()) {
                        mTextView.setText("" + mRecorder.getMaxAmplitude());
                        mHandler.sendEmptyMessageDelayed(MSG_LOOP, 100);
                    }
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1: {
                if (mRecorder == null) {
                    mRecorder = new Mp3Recorder();
                    mRecorder.setOutputFile(OUT_FILE_PATH);
                    try {
                        mRecorder.prepare();
                        mRecorder.start();
                        mHandler.sendEmptyMessage(MSG_LOOP);
                    } catch (Exception e) {
                        Log.d(TAG, "mp3 recorder start failed", e);
                    }
                    mBtn1.setText(R.string.pause_record);
                } else if (mRecorder.isPaused()) {
                    mRecorder.resume();
                    mHandler.sendEmptyMessage(MSG_LOOP);
                    mBtn1.setText(R.string.pause_record);
                } else {
                    mRecorder.pause();
                    mBtn1.setText(R.string.resume_record);
                }
                break;
            }
            case R.id.btn_2: {
                if (mRecorder != null) {
                    mRecorder.stop();
                    mRecorder.release();
                    mRecorder = null;
                }

                if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer.release();
                    mPlayer = null;
                }
                mBtn1.setText(R.string.start_record);
                break;
            }
            case R.id.btn_3: {
                if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer.release();
                }
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(OUT_FILE_PATH);
                    mPlayer.prepare();
                    mPlayer.start();
                } catch (IOException e) {
                    Log.d(TAG, "Player exception", e);
                }
                break;
            }
        }
    }
}
