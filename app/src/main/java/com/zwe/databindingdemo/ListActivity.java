package com.zwe.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.zwe.databindingdemo.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2017/7/23.
 */

public class ListActivity extends AppCompatActivity{
    ActivityListBinding mBinding;
    StudentAdapter mAdapter;
    public class ListPresenter{
        public void onClickAddItem(View view){
            mAdapter.add(new Student("hehe","1",false));
        }
        public void onClickRemoveItem(View view){
            mAdapter.remove();
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_list);
        mBinding.setListPresenter(new ListPresenter());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new StudentAdapter(this);
        mBinding.recyclerView.setAdapter(mAdapter);
        mAdapter.setListener(new StudentAdapter.onItemClickListener() {
            @Override
            public void onStudentClick(Student student) {
                Toast.makeText(ListActivity.this, student.getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });
        List<Student> students=new ArrayList<>();
        students.add(new Student("aaa","ccc",false));
        students.add(new Student("aaa2","ccc2",false));
        students.add(new Student("aaa3","ccc3",true));
        students.add(new Student("aaa4","ccc4",false));
        mAdapter.addAll(students);
    }
}
