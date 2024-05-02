package com.example.todolist;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Task> notes = new ArrayList<>();
    static ArrayAdapter<Task> arrayAdapter;
    private static final int ADD_TASK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.itemlist);
        Button addButton = findViewById(R.id.addnew_button);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);

        // click to edit task

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick
            (AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),
                        editTask.class);
                intent.putExtra("noteId", i);
                startActivity(intent);
            }
        });

        // long click to remove task
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                notes.remove(position);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Task removed", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addNewTask.class);
                startActivityForResult(intent, ADD_TASK_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == ADD_TASK_REQUEST && data != null) {
            String title = data.getStringExtra("title");
            String description = data.getStringExtra("description");
            String category = data.getStringExtra("category");
            String status = data.getStringExtra("status");

            Task newTask = new Task(title, description, category, status);
            notes.add(newTask);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}