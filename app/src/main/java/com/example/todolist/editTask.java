package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class editTask extends AppCompatActivity {

    int noteId; // we need to know the task ID, different task different ID
    RadioGroup categoryRadioGroup, statusRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1 && noteId < MainActivity.notes.size()) {
            Task task = MainActivity.notes.get(noteId);

            EditText editTextTitle = findViewById(R.id.title_edit_text);
            EditText editTextDescription = findViewById(R.id.description);
            editTextTitle.setText(task.getTitle());
            editTextDescription.setText(task.getDescription());

            categoryRadioGroup = findViewById(R.id.category_radio_group);
            statusRadioGroup = findViewById(R.id.status_radio_group);
            setSelectedRadioButtons(task.getCategory(), categoryRadioGroup);
            setSelectedRadioButtons(task.getStatus(), statusRadioGroup);
        } else {
        }

        // Save button click listener
        Button saveButton = findViewById(R.id.save_task_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextTitle = findViewById(R.id.title_edit_text);
                EditText editTextDescription = findViewById(R.id.description);
                String updatedTitle = editTextTitle.getText().toString();
                String updatedDescription = editTextDescription.getText().toString();

                RadioButton selectedCategoryRadioButton = findViewById(categoryRadioGroup.getCheckedRadioButtonId());
                String updatedCategory = selectedCategoryRadioButton.getText().toString();
                RadioButton selectedStatusRadioButton = findViewById(statusRadioGroup.getCheckedRadioButtonId());
                String updatedStatus = selectedStatusRadioButton.getText().toString();

                // Update the corresponding task object in MainActivity.notes
                if (noteId != -1 && noteId < MainActivity.notes.size()) {
                    Task updatedTask = MainActivity.notes.get(noteId);
                    updatedTask.setTitle(updatedTitle);
                    updatedTask.setDescription(updatedDescription);
                    updatedTask.setCategory(updatedCategory);
                    updatedTask.setStatus(updatedStatus);
                }

                // Notify MainActivity to update ListView
                MainActivity.arrayAdapter.notifyDataSetChanged();

                // Finish the activity and return to MainActivity
                finish();
            }
        });
    }

    // Helper method to set the selected radio button based on its text
    private void setSelectedRadioButtons(String text, RadioGroup radioGroup) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            if (radioButton.getText().toString().equals(text)) {
                radioButton.setChecked(true);
                break;
            }
        }
    }
}
