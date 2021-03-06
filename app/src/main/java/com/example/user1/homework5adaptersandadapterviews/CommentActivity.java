package com.example.user1.homework5adaptersandadapterviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CommentActivity extends AppCompatActivity {

    TextView txtComment;
    EditText edtComment;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        txtComment = (TextView) findViewById(R.id.txt_the_comments);
        edtComment = (EditText) findViewById(R.id.edt_send);
        btnSend = (Button) findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtComment.setText(String.valueOf(txtComment.getText()) + "\n" + String.valueOf(edtComment.getText()));
            }
        });
    }
}
