package com.lisbeth.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private LinkedList<String> mWordList;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
         this.button = findViewById(R.id.button);
         this.mWordList = new LinkedList<>();
    initializeList();
         mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View v) {
                mWordList.add("Card" +mAdapter.getItemCount());
                mAdapter.notifyDataSetChanged();
            }
        });

    }


    public void initializeList(){
        for (int i = 0; i < 30; i++) {
            this.mWordList.add("Card "+i);
        }
    }
}