package mnls.com.mappone.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import mnls.com.mappone.R;
import mnls.com.mappone.po.Cp1pInfo;

/*第二个Adapter*/
public class RecyclerAdapter1 extends  RecyclerView.Adapter<RecyclerAdapter1.MyHolder> {
    private List<Cp1pInfo> lbeanList;
    public RecyclerAdapter1(List<Cp1pInfo> lbeanList) {
        this.lbeanList = lbeanList;
    }
    public static class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView_pzhm;
        private TextView textView_cpcm;
        private TextView textView_ggs;
        private TextView textView_carno;
        private CheckBox checkBox;
        public TextView getTextView_carno() {
            return textView_carno;
        }
        public TextView getTextView_cpcm() {
            return textView_cpcm;
        }
        public TextView getTextView_ggs() {
            return textView_ggs;
        }
        public TextView getTextView_pzhm() {
            return textView_pzhm;
        }
        public CheckBox getCheckBox() {
            return checkBox;
        }
        public MyHolder(View itemView) {
            super(itemView);
            textView_pzhm = (TextView) itemView.findViewById(R.id.checkbox_pzhm);
            textView_cpcm = (TextView) itemView.findViewById(R.id.checkbox_cpcm);
            textView_ggs = (TextView) itemView.findViewById(R.id.checkbox_ggs);
            textView_carno = (TextView) itemView.findViewById(R.id.checkbox_carno);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox1);

        }
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cp1pdetail_item, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cp1pdetail_item, parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

//    @Override
//    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.getTextView_pzhm().setText(lbeanList.get(position).getPzhm());
        holder.getTextView_cpcm().setText(lbeanList.get(position).getCpcm());
        holder.getTextView_ggs().setText(lbeanList.get(position).getGgs()+"");
        holder.getTextView_carno().setText(lbeanList.get(position).getCarno()+"");
        holder.getCheckBox().setChecked(lbeanList.get(position).ischeck());
        holder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//将商品的checkbox的点击变化事件进行回调给第一个Recyclerview
                if (mCallBack != null) {
                    mCallBack.OnCheckListener(isChecked, position);
                }
            }
        });
        holder.itemView.setId(position);
    }
    @Override
    public int getItemCount() {
        return lbeanList.size();
    }
    private allCheck mCallBack;
    public void setCallBack(allCheck callBack) {
        mCallBack = callBack;
    }
    public interface allCheck {
        //回调函数 将店铺商品的checkbox的点击变化事件进行回调
        public void OnCheckListener(boolean isChecked, int childpostion);
    }
}
