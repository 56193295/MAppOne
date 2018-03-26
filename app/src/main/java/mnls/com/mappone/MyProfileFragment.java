package mnls.com.mappone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/*在底部菜单中我的资料所展示的Fragment*/
public class MyProfileFragment extends Fragment{

    private Button modifyBtn;
    private Button forgetBtn1;
    private Button exitBtn;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        @SuppressLint("ResourceType")
        View view = inflater.inflate(R.layout.myprofile,container,false);

        modifyBtn = (Button)view.findViewById(R.id.modifyPro);
        modifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ModifyMe.class);//跳转到忘记密码界面的按钮
                getActivity().startActivity(i);
            }
        });

        forgetBtn1 = (Button)view.findViewById(R.id.forgetBtn1);
        forgetBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(),ResetActivity.class);//跳转到重置密码的界面的按钮
                getActivity().startActivity(i1);
            }
        });

        exitBtn = (Button)view.findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(i);    //个人信息登出按钮
            }
        });

        return view;
    }
}
