package com.zwe.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Asus on 2017/7/23.
 */

public class Model extends BaseObservable{
    private String name;
    private String password;

    public Model(String name,String password){
        this.name=name;
        this.password=password;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.zwe.databindingdemo.BR.name);
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(com.zwe.databindingdemo.BR.password);
    }
    @Bindable
    public String getPassword() {
        return password;
    }
}
