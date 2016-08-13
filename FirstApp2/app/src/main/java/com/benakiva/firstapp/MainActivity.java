package com.benakiva.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTextMessage;
    private Button  mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (EditText) findViewById(R.id.message);
        mShare = (Button) findViewById(R.id.btn_share);
        mShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String message = mTextMessage.getText().toString();

        if (!TextUtils.isEmpty(message)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setType("text/plain");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(intent, "Share"));
            }
        } else {
            mTextMessage.setError("Required.");
        }
    }
}
