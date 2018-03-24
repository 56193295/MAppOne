package mnls.com.mappone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/*底部菜单导航栏第一个fragment：发送预约*/
public class FragmentPage1 extends Fragment {

    private Button addBtn;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.orderinfo,container,false);
        addBtn = (Button)view.findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),CheckActivity.class);//跳转到发运计划信息的按钮
                getActivity().startActivity(i);
            }
        });
        return view;
    }
}
