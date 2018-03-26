package mnls.com.mappone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/*登录的主页面*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registBtn; //定义注册信息按钮
    private Button loginBtn;  //定义登陆按钮
    private Button forgetBtn; //定义忘记密码按钮

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registBtn = (Button)findViewById(R.id.registBtn);
        registBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,RegistActivity.class);
                startActivity(i1);
            }
        }); //按钮跳转到注册界面



        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this,MainFragment.class);
                startActivity(i2);

            }
        });//按钮跳转到登录后的界面

        forgetBtn = (Button)findViewById(R.id.forgetBtn);
        forgetBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this,ForgetActivity.class);
                startActivity(i3);
            }
        });//按钮跳转到重置密码界面



    }


    @Override
    public void onClick(View view) {

    }
}
