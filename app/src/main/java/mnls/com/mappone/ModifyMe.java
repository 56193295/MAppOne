package mnls.com.mappone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*修改个人资料*/
public class ModifyMe extends AppCompatActivity{

    private Button regiBtn1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfomodify);

        regiBtn1 = (Button)findViewById(R.id.regiBtn1);
        regiBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModifyMe.this,MainFragment.class);
                startActivity(i);
            }
        });
    }

}
