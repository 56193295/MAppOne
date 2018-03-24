package mnls.com.mappone.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import mnls.com.mappone.R;
import mnls.com.mappone.po.Kh91Info;


/**第一个Adapater*/
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder>{

    private List<Kh91Info> list;
    public RecyclerAdapter(List<Kh91Info> list){
        this.list = list;
    }
    public static class MyHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        private TextView textView;
        private CheckBox checkBox;
        private RecyclerAdapter1 adapter;
        private RecyclerView.LayoutManager manager;
        public CheckBox getCheckBox() {
            return checkBox;
        }
        public RecyclerView getRecyclerView() {
            return recyclerView;
        }
        public TextView getTextView() {
            return textView;
        }
        public MyHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.list_items);
            textView = (TextView) itemView.findViewById(R.id.tv_name);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox0);
            manager = new LinearLayoutManager(itemView.getContext());
            recyclerView.setLayoutManager(manager);
        }
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cp1p_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.adapter = new RecyclerAdapter1(list.get(position).getList());
        holder.recyclerView.setAdapter(holder.adapter);
        holder.getTextView().setText(list.get(position).getKhhm());
        holder.getCheckBox().setChecked(list.get(position).ischeck());
        holder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//将店铺的checkbox的点击变化事件进行回调
                if (mCallBack!=null){
                    mCallBack.OnCheckListener(isChecked,position);
                }
            }
        });
//实现第二层RecyclerView的回调接口
        holder.adapter.setCallBack(new RecyclerAdapter1.allCheck() {
            @Override
            public void OnCheckListener(boolean isChecked, int childpostion) {
//将店铺商品的checkbox的点击变化事件进行回调
                if (mCallBack!=null){
                    mCallBack.OnItemCheckListener(isChecked,position,childpostion);
                }
            }
        });
        holder.itemView.setTag(list.get(position));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    private allCheck mCallBack;
    public void setCallBack(allCheck callBack) {
        mCallBack = callBack;
    }
    public interface allCheck{
        //回调函数 将店铺的checkbox的点击变化事件进行回调
        public void OnCheckListener(boolean isSelected,int position);
        //回调函数 将店铺商品的checkbox的点击变化事件进行回调
        public void OnItemCheckListener(boolean isSelected,int parentposition,int chaildposition);
    }
}
