package com.zwe.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zwe.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Student stu;
    ActivityMainBinding binding;
    //第一步：在xml文件最外层套一层<layout></layout>,android studio自动生成ActivityMainBinding
    //第二步，数据层写在xml文件，在<layout>下一层,和ui层同级,<data><variable name="" type="指定类文件"></variable></data>
    //第二步执行完毕系统自动生成binding.setXXX。详情看demo
    //避免：数据越界和空指针（空指针会自动检查）
    //binding中的id可以直接binding.id名字获取，在xml文件中可以直接"@{id名字}"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stu=new Student("zwe","lpm",false);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setStudent(stu);
        binding.setPresenter(new Presenter());
        binding.viewStub.getViewStub().inflate();
    }

    public class Presenter{
        //方法和自带方法一样（名字，参数）时，xml文件用@{name.方法名(不用加参数)}
        //方法和自带方法不同时，xml文件用@{ ()->name.方法名(参数)}
        public void onTextChanged(CharSequence s,int start,int before,int code){
            stu.setFirstName(s.toString());
            stu.setIsGone(!stu.isGone.get());
            //binding.setStudent(stu);
        }
        public void onClick(View view){
            Toast.makeText(MainActivity.this, "点到了"+stu.getFirstName(), Toast.LENGTH_SHORT).show();
        }
        public void onClickListenerBinding(Student stu){
            Toast.makeText(MainActivity.this, stu.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }
}
