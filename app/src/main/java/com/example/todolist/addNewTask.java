package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class addNewTask extends AppCompatActivity {

    EditText titleEditText, descriptionEditText;
    RadioGroup categoryRadioGroup;
    RadioGroup statusRadioGroup;
    Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);



        titleEditText = findViewById(R.id.title_edit_text);
        descriptionEditText = findViewById(R.id.description);
        categoryRadioGroup = findViewById(R.id.category_radio_group);
        statusRadioGroup = findViewById(R.id.status_radio_group);
        addTaskButton = findViewById(R.id.add_task_button);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                int selectedCategoryRadioButtonId = categoryRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedCategoryRadioButton = findViewById(selectedCategoryRadioButtonId);
                String category = selectedCategoryRadioButton.getText().toString();

                int selectedStatusRadioButtonId = statusRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedStatusRadioButton = findViewById(selectedStatusRadioButtonId);
                String status = selectedStatusRadioButton.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                intent.putExtra("category", category);
                intent.putExtra("status", status);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}