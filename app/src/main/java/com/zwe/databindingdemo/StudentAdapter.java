package com.zwe.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Asus on 2017/7/23.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.BindingViewHolder>{
    private static final int ITEM_VIEW_TYPE_ON=1;
    private static final int ITEM_VIEW_TYPE_OFF=2;
    private final LayoutInflater mLayoutInflater;
    private onItemClickListener mListener;
    private List<Student> mStudents;

    public interface onItemClickListener{
        void onStudentClick(Student student);
    }

    public void setListener(onItemClickListener listener) {
        mListener = listener;
    }

    public void addAll(List<Student> students){
        mStudents.addAll(students);
    }

    Random mRandom=new Random(System.currentTimeMillis());

    public void add(Student student){
        int position=mRandom.nextInt(mStudents.size()+1);
        mStudents.add(position,student);
        notifyItemInserted(position);
    }

    public void remove(){
        if (mStudents.size()==0){
            return;
        }
        int position=mRandom.nextInt(mStudents.size());
        mStudents.remove(position);
        notifyItemRemoved(position);
    }

    public StudentAdapter(Context context){
        mLayoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mStudents=new ArrayList<>();
    }
    @Override
    public StudentAdapter.BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding;
        if (viewType==ITEM_VIEW_TYPE_ON){
            dataBinding= DataBindingUtil.inflate(mLayoutInflater,R.layout.item_student_on,parent,false);
        }else {
            dataBinding= DataBindingUtil.inflate(mLayoutInflater,R.layout.item_student_off,parent,false);
        }
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.BindingViewHolder holder, int position) {
        final Student student=mStudents.get(position);
        holder.getBinding().setVariable(com.zwe.databindingdemo.BR.item,student);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener!=null){
                    mListener.onStudentClick(student);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        Student student=mStudents.get(position);
        if (student.isGone.get()){
            return ITEM_VIEW_TYPE_OFF;
        }else {
            return ITEM_VIEW_TYPE_ON;
        }
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }
    static class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
        private T mBinding;
        public BindingViewHolder(T binding) {
            super(binding.getRoot());
            mBinding=binding;
        }

        public T getBinding() {
            return mBinding;
        }
    }
}
