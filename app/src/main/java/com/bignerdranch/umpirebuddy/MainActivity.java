package com.bignerdranch.umpirebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBallButton;
    private Button mStrikeButton;
    private Button mResetButton;
    private TextView mBallCountView;
    private TextView mStrikeCountView;
    private int mBallCount;
    private int mStrikeCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBallCountView = (TextView) findViewById(R.id.ball_count);
        mStrikeCountView = (TextView) findViewById(R.id.strike_count);

        mBallButton = (Button) findViewById(R.id.ball_button);
        mBallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBallCount++;
                updateCountView();
            }
        });

        mStrikeButton = (Button) findViewById(R.id.strike_button);
        mStrikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStrikeCount++;
                updateCountView();
            }
        });

        mResetButton = (Button) findViewById(R.id.reset_button);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCountView();
            }
        });

            resetCountView();
        }

        private void updateCountView() {

            if (mBallCount == 4 || mStrikeCount == 3) {
                resetCountView();
            }
            mStrikeCountView.setText(getString(R.string.strikes_label, mStrikeCount));
            mBallCountView.setText(getString(R.string.balls_label, mBallCount));
        }

        private void resetCountView() {
            mBallCount = 0;
            mStrikeCount = 0;
            updateCountView();
        }
}
