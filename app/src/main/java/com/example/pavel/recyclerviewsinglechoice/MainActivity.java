package com.example.pavel.recyclerviewsinglechoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> items = new ArrayList();
    SingleChoiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 30; i++) {
            items.add("item " + i);
        }

        RecyclerView rv = findViewById(R.id.list);
        Button btn = findViewById(R.id.button);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        adapter = new SingleChoiceAdapter(items);
        adapter.setCheckedPosition(3);
        rv.setAdapter(adapter);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int position = adapter.getChecedPosition();
        Toast toast = Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT );
        toast.show();
    }
}
