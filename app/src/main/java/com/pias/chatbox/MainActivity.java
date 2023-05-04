package com.pias.chatbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView welcomeTextView;
    EditText smsEditeText;
    ImageButton sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycle_view);
        welcomeTextView= findViewById(R.id.welcome_text);
        smsEditeText= findViewById(R.id.sms_edit_text);
        sendBtn= findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener((v)->{
            String question= smsEditeText.getText().toString().trim();
            Toast.makeText(this, question, Toast.LENGTH_SHORT).show();
        });

    }
}