package mnls.com.mappone;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * fragment底部导航栏
 */
public class MainFragment extends FragmentActivity{
    private FragmentTabHost fragmentTabHost;
    private String texts[] = { "发运预约", "发运消息", "我的资料" };
    private int imageButton[] =
            {       //R.drawable.bt_home_selector,
                    //R.drawable.tab_menu_setting,
                    R.drawable.tab_menu_setting,
                    R.drawable.tab_menu_message,
                    R.drawable.tab_menu_channel
            };
    private Class fragmentArray[] =
            {       FragmentPage1.class,
                    FragmentPage2.class,
                    MyProfileFragment.class
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        // 实例化tabhost
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.maincontent);

        for (int i = 0; i < texts.length; i++) {
            TabHost.TabSpec spec=fragmentTabHost.newTabSpec(texts[i]).setIndicator(getView(i));

            fragmentTabHost.addTab(spec, fragmentArray[i], null);

            //设置背景(必须在addTab之后，由于需要子节点（底部菜单按钮）否则会出现空指针异常)
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.bt_selector);
        }

    }

    private View getView(int i) {
        //取得布局实例
        View view=View.inflate(MainFragment.this, R.layout.tabcontent, null);

        //取得布局对象
        ImageView imageView=(ImageView) view.findViewById(R.id.image);
        TextView textView=(TextView) view.findViewById(R.id.text);

        //设置图标
        imageView.setImageResource(imageButton[i]);
        //设置标题
        textView.setText(texts[i]);
        return view;
    }
}
