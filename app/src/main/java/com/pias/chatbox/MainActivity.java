package com.pias.chatbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView welcomeTextView;
    EditText smsEditeText;
    ImageButton sendBtn;
    List<Message> messageList;
    MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        messageList= new ArrayList<>();

        recyclerView= findViewById(R.id.recycle_view);
        welcomeTextView= findViewById(R.id.welcome_text);
        smsEditeText= findViewById(R.id.sms_edit_text);
        sendBtn= findViewById(R.id.sendBtn);

        //setup recycle view
        messageAdapter= new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        sendBtn.setOnClickListener((v)->{
            String question= smsEditeText.getText().toString().trim();
            addToChat(question, Message.SENT_BY_ME);
            smsEditeText.setText("");
            welcomeTextView.setVisibility(View.GONE);
        });

    }

    void addToChat(String message, String sentBy){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message,sentBy));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());

            }
        });
    }
}