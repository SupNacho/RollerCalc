package ru.supernacho.rollercalc;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.server.converter.StringToIntConverter;

public class MainActivity extends AppCompatActivity {
    private TextView mResult;
    private EditText mInnerV;
    private EditText mOutV;
    private EditText mThickV;
    private SeekBar mThickB;
    private SeekBar mInnB;
    private SeekBar mOutB;
    private int lockFlag = 0;
    private ImageButton mRotateB;
    private static final String KEY_RESULT = "RESULT";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Calc calc = new Calc();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThickV = (EditText) findViewById(R.id.editThick);
        mInnerV = (EditText) findViewById(R.id.editInD);
        mOutV = (EditText) findViewById(R.id.editOut);
        mThickB = (SeekBar) findViewById(R.id.thickBar);
        mInnB = (SeekBar) findViewById(R.id.innerBar);
        mOutB = (SeekBar) findViewById(R.id.outBar);
        mResult = (TextView) findViewById(R.id.resultView);
        mRotateB = (ImageButton) findViewById(R.id.rotateBut);


        if ( savedInstanceState!=null){
            mResult.setText(savedInstanceState.getString(KEY_RESULT));
        }

        mThickV.setText(String.valueOf(mThickB.getProgress()));
        mInnerV.setText(String.valueOf(mInnB.getProgress()));
        mOutV.setText(String.valueOf(mOutB.getProgress()));
        calc.setdIn((mInnB.getProgress()));
        calc.setdOut((mOutB.getProgress()));
        calc.setH((mThickB.getProgress()));
        calc.proc();
        mResult.setText(String.format("%.2fm",calc.getLenR()));


        mThickV.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)&&(mThickV.getText().length()!=0)){
                    mThickB.setProgress(Integer.valueOf(mThickV.getText().toString()));
                }
                return false;
            }
        });

        mInnerV.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)&&(mInnerV.getText().length()!=0)){
                    mInnB.setProgress(Integer.valueOf(mInnerV.getText().toString()));
                }
                return false;
            }
        });

        mOutV.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)&&(mOutV.getText().length()!=0)){
                    mOutB.setProgress(Integer.valueOf(mOutV.getText().toString()));
                }
                return false;
            }
        });

        mThickB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mThickV.setText(String.valueOf(progress));
                calc.setH((progress));
                calc.proc();
                mResult.setText(String.format("%.2fm",calc.getLenR()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mInnB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mInnerV.setText(String.valueOf(progress));
                calc.setdIn((progress));
                calc.proc();
                mResult.setText(String.format("%.2fm",calc.getLenR()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mOutB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mOutV.setText(String.valueOf(progress));
                calc.setdOut((progress));
                calc.proc();
                mResult.setText(String.format("%.2fm",calc.getLenR()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mRotateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lockFlag == 0) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
                    lockFlag = 1;
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_RESULT,String.valueOf(mResult.getText()));
        super.onSaveInstanceState(outState);
    }






}
