package com.zwe.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zwe.databindingdemo.databinding.ActivityLoginBinding;

/**
 * Created by Asus on 2017/7/23.
 */

public class LoginActivity extends AppCompatActivity{
    //使用双向绑定
    ActivityLoginBinding mBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        Model model=new Model("zwe","123");
        mBinding.setModel(model);
    }
}
