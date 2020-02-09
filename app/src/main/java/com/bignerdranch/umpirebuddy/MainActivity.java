package com.bignerdranch.umpirebuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBallButton;
    private Button mStrikeButton;
    private Button mResetButton;
    private Button mExitButton;
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

        mExitButton = (Button) findViewById(R.id.exit_button);
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        resetCountView();
        }

        private void updateCountView() {

            if (mBallCount == 4) {
                alertDialog("Ball!", "Advance the runner and scoff at the pitcher!");
                resetCountView();
            } else if (mStrikeCount == 3) {
                alertDialog("Strike!", "Strikeout! Praise the pitcher!");
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

        private void alertDialog(String title, String message) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

        public void aboutActivity(View view) {
            alertDialog("About", "Umpire Buddy 2.0\nDeveloper: Alex Banning");
        }
}
