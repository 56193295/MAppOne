package mnls.com.mappone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/*用户登陆后重置密码的Activity*/
public class ResetActivity extends AppCompatActivity{

    private Button resetBtn1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypwdmodify);

        resetBtn1 = (Button)findViewById(R.id.resetBtn1);
        resetBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResetActivity.this,MainFragment.class);
                startActivity(i);
            }
        });
    }

}
