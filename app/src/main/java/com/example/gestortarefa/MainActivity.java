package com.example.gestortarefa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private ArrayList<String> listaTarefa = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        listaTarefa = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTarefa);

        listView.setAdapter(adapter);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    addTask();
                    return true;
                }
                return false;
            }
        });
    }

    private void addTask() {
        String task = editText.getText().toString().trim();
        if (!task.isEmpty()) {
            listaTarefa.add(0, task);
            adapter.notifyDataSetChanged();
            editText.setText("");
        }
    }
}