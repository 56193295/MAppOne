package mnls.com.mappone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/*用户点击忘记密码后跳转的界面*/
public class ForgetActivity extends AppCompatActivity {
    private Button regiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypwdrest);

        regiBtn = (Button)findViewById(R.id.regiBtn);
        regiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ForgetActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }


}
