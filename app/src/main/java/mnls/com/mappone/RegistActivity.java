package mnls.com.mappone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistActivity extends AppCompatActivity {

    private Button RegiBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        RegiBtn = (Button)findViewById(R.id.regiBtn);
        RegiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
