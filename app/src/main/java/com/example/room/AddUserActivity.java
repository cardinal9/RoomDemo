package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.room.userlistsql.REPLY";

    private EditText addUserText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addUserText = findViewById(R.id.add_user);

        Button button = findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (TextUtils.isEmpty(addUserText.getText())) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    String user = addUserText.getText().toString();
                    intent.putExtra(EXTRA_REPLY, user);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}
