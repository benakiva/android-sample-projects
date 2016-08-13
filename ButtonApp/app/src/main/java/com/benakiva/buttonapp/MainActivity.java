package com.benakiva.buttonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mMessage;
    private Button mSend;
    private Button mSendIcon;
    private ImageButton mImgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = (TextView) findViewById(R.id.message);
        mSend = (Button) findViewById(R.id.button_send);
        mSendIcon = (Button) findViewById(R.id.button_send_icon);
        mImgButton = (ImageButton) findViewById(R.id.imageButton_send);

        mSend.setOnClickListener(this);

        mSendIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence msg = mMessage.getText();

                Toast.makeText(MainActivity.this, "Icon Button: " + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        CharSequence msg = mMessage.getText();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void sendMessage(View view) {
        CharSequence msg = mMessage.getText();

        Toast.makeText(this, "ImageButton " + msg, Toast.LENGTH_SHORT).show();
    }
}
