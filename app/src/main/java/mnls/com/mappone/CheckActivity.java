package mnls.com.mappone;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import mnls.com.mappone.adapter.RecyclerAdapter;
import mnls.com.mappone.po.Cp1pInfo;
import mnls.com.mappone.po.Kh91Info;
import mnls.com.mappone.po.UserInfo;
import mnls.com.mappone.tool.BigDecimalUtil;

/*发运计划信息的多选信息界面*/
public class CheckActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private CheckBox checkBox;
    private TextView textView_ggs;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<Kh91Info> kh91InfoList;
    private List  cp1pInfoList;
    private double weight = 0;


    int mYear, mMonth, mDay;
    Button btn;
    TextView dateDisplay;
    final int DATE_DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordersubmit);

        init();
        initData();
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        checkBox = (CheckBox) findViewById(R.id.shop_checkbox);
        textView_ggs = (TextView) findViewById(R.id.amount_ggs);
        UserInfo ui = new UserInfo();
        ui.setPhone("13928600040");
        Cp1pInfoListBean(ui);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
//优化性能
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(kh91InfoList);
        recyclerView.setAdapter(adapter);
//全选CheckBox监听
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    for (int i = 0;i < kh91InfoList.size();i++){
//选择店铺
                        if (!kh91InfoList.get(i).ischeck()){
                            kh91InfoList.get(i).setIscheck(true);
                        }
                        for (int j = 0;j < kh91InfoList.get(i).getList().size();j++){
//选择店铺的商品
                            if (!kh91InfoList.get(i).getList().get(j).ischeck()){
                                kh91InfoList.get(i).getList().get(j).setIscheck(true);
                            }
                        }
                    }
                }else {
//只有当点击全不选时才执行
// 解决点击取消选择店铺或商品时，
// 全选按钮取消选择状态，不会不变成全不选
                    if (allSelect() == kh91InfoList.size()){
                        for (int i = 0;i < kh91InfoList.size();i++){
                            if (kh91InfoList.get(i).ischeck()){
                                kh91InfoList.get(i).setIscheck(false);
                            }
                            for (int j = 0;j < kh91InfoList.get(i).getList().size();j++){
                                if (kh91InfoList.get(i).getList().get(j).ischeck()){
                                    kh91InfoList.get(i).getList().get(j).setIscheck(false);
                                }
                            }
                        }
                    }
                }
//更新
                UpdateRecyclerView();
            }
        });
        adapter.setCallBack(new RecyclerAdapter.allCheck() {
            @Override
            public void OnCheckListener(boolean isSelected, int position) {
//保存店铺点击状态
                kh91InfoList.get(position).setIscheck(isSelected);
//通知全选CheckBox的选择状态
                if (allSelect() == kh91InfoList.size()){
                    checkBox.setChecked(true);
                }else {
                    checkBox.setChecked(false);
                }
                if (isSelected){
                    for (int i = 0;i < kh91InfoList.get(position).getList().size();i++){
                        if (!kh91InfoList.get(position).getList().get(i).ischeck()){
                            kh91InfoList.get(position).getList().get(i).setIscheck(true);
                        }
                    }
                }else {
// 解决点击取消选择商品时，
// 店铺全选按钮取消选择状态，不会不变成全不选
                    if (allChildSelect(position) == kh91InfoList.get(position).getList().size()){
                        for (int i = 0;i < kh91InfoList.get(position).getList().size();i++){
                            if (kh91InfoList.get(position).getList().get(i).ischeck()){
                                kh91InfoList.get(position).getList().get(i).setIscheck(false);
                            }
                        }
                    }
                }
//更新
                UpdateRecyclerView();
            }
            @Override
            public void OnItemCheckListener(boolean isSelected, int parentposition, int chaildposition) {
//保存商品点击状态
                kh91InfoList.get(parentposition).getList().get(chaildposition).setIscheck(isSelected);
//通知店铺选择的状态
                if (allChildSelect(parentposition) == kh91InfoList.get(parentposition).getList().size()){
                    kh91InfoList.get(parentposition).setIscheck(true);
                }else {
                    kh91InfoList.get(parentposition).setIscheck(false);
                }
                UpdateRecyclerView();
            }
        });
    }
    private List UserInfoList(String phoneCode){

        return null;
    }
    //获取发运计划所有资料，根据手机号码信息去匹配所有未关闭的发运计划资料信息
    private List Cp1pInfoListBean(UserInfo userInfo){
        List cplist =  new Cp1pInfo().getCp1pInfoByPhoneCode(userInfo);
        if(cplist.size()>0){
            List<Cp1pInfo> l   = (List) cplist.get(0);
            kh91InfoList = new ArrayList<Kh91Info>();
            Set<Kh91Info> k = (Set)cplist.get(1);
            if(k.size()>0){
                for (Kh91Info kh : k) {
                    Kh91Info s = new Kh91Info();
                    s.setKhhm(kh.getKhhm());
                    s.setKhmc(kh.getKhmc());
                    s.setIscheck(false);
                    cp1pInfoList = new ArrayList<Cp1pInfo>();
                    for(int e = 0 ; e<l.size(); e++){
                        if(s.getKhhm().equals(l.get(e).getKhhm())){
                            Cp1pInfo p = new Cp1pInfo();
                            p.setPzhm(l.get(e).getPzhm());
                            p.setCpcm(l.get(e).getCpcm());
                            p.setGgs(l.get(e).getGgs());
                            p.setCarno(l.get(e).getCarno());
                            p.setIscheck(false);
                            cp1pInfoList.add(p);
                        }
                    }
                    s.setList(cp1pInfoList);
                    kh91InfoList.add(s);
                }
            }
        }


        return kh91InfoList;
    }
    /*
     *解决Recycleyview刷新报错问题
     */
    private void UpdateRecyclerView() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
        weightValue();
    }
    //计算店铺的选择数量
    private int allSelect(){
        int sum = 0;
        for (int i = 0; i < kh91InfoList.size(); i++) {
            if (kh91InfoList.get(i).ischeck()){
                sum++;
            }
        }
        System.out.println(sum);
//        weightValue();
        return sum;
    }
    //计算每个店铺商品的选择数量
    private int allChildSelect(int position){
        int sum = 0;
        for (int i = 0; i < kh91InfoList.get(position).getList().size(); i++) {
            if (kh91InfoList.get(position).getList().get(i).ischeck()){
                sum++;
                weight = BigDecimalUtil.add(weight,kh91InfoList.get(position).getList().get(i).getGgs());
                System.out.println(position+":"+i+":"+kh91InfoList.get(position).getList().get(i).ischeck());
            }
        }
//        weightValue();
        return sum;
    }
    private double weightValue(){
        weight = 0;
        if(kh91InfoList.size()>0){
            for(int i=0;i< kh91InfoList.size(); i++){
                Kh91Info k = kh91InfoList.get(i);
                for(int j = 0 ; j < k.getList().size(); j++){
                    Cp1pInfo cp = k.getList().get(j);
                    if(cp.ischeck()){
                        weight = BigDecimalUtil.add(weight,cp.getGgs());
                    }
                }
            }
            System.out.println( "  总选择重量》》" + weight);
        }else{
            weight = 0;
        }
        textView_ggs.setText(weight+"");
        return weight ;
    }
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(CheckActivity.this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }
    DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
        /**
         * 设置日期 利用StringBuffer追加
         */
        private void display() {
            dateDisplay.setText(new StringBuffer().append(mYear).append("年").append(mMonth + 1).append("月").append(mDay).append("日"));
        }
    };
    private void initData() {

        //监听事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG);
            }
        });


    }

    private void init() {

        btn = (Button) findViewById(R.id.dateChoose);
        dateDisplay = (TextView) findViewById(R.id.dateDisplay);
    }
}