package com.zwe.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zwe.databindingdemo.databinding.ActivityAllBinding;

/**
 * Created by Asus on 2017/7/23.
 */

public class AllActivity extends AppCompatActivity{
    ActivityAllBinding mBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_all);
        mBinding.setStart(new Start());
    }

    public class Start{
        public void goToMain(){
            Intent intent=new Intent(AllActivity.this,MainActivity.class);
            startActivity(intent);
        }
        public void goToList(){
            Intent intent=new Intent(AllActivity.this,ListActivity.class);
            startActivity(intent);
        }
        public void goToExpression(){
            Intent intent=new Intent(AllActivity.this,ExpressionActivity.class);
            startActivity(intent);
        }
        public void goToLogin(){
            Intent intent=new Intent(AllActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
