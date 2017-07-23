package com.zwe.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zwe.databindingdemo.databinding.ActivityExpressionBinding;


/**
 * Created by Asus on 2017/7/23.
 */
//https://avatars1.githubusercontent.com/u/25889027?v=4&u=61b4a3c28e3aea037cedd0585d7d42ad601532dd&s=400
public class ExpressionActivity extends AppCompatActivity{
    ActivityExpressionBinding mBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Student student=new Student("zwe","lin",false);
        student.setUrl("https://avatars1.githubusercontent.com/u/25889027?v=4&u=61b4a3c28e3aea037cedd0585d7d42ad601532dd&s=400");
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_expression);
        mBinding.setStudent(student);
    }
}
