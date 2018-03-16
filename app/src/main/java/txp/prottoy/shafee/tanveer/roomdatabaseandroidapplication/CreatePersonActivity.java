package txp.prottoy.shafee.tanveer.roomdatabaseandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class CreatePersonActivity extends AppCompatActivity {
    public static final String REPLY = "reply";
    private EditText createEditText0, createEditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);
        initializeView();
    }

    private View.OnClickListener createButtonOcl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(createEditText0.getText()) || TextUtils.isEmpty(createEditText1.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            }
            else {
                String[] values = new String[2];
                values[0] = createEditText0.getText().toString();
                values[1] = createEditText1.getText().toString();
                replyIntent.putExtra(REPLY, values);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        }
    };

    private void initializeView() {
        createEditText0 = findViewById(R.id.create_edit_text0);
        createEditText1 = findViewById(R.id.create_edit_text1);
        findViewById(R.id.create_btn).setOnClickListener(createButtonOcl);
    }
}
