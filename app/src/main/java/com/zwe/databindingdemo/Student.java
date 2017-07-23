package com.zwe.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;


/**
 * Created by Asus on 2017/7/22.
 */

public class Student extends BaseObservable{
    private String firstName;
    private String lastName;
    private String gender;
    private String number;
    private String url;

    public ObservableBoolean isGone=new ObservableBoolean();

    public ObservableArrayMap<String,String> mMap=new ObservableArrayMap<>();

    public Student(String firstName,String lastName,boolean gone){
        this.firstName=firstName;
        this.lastName=lastName;
        isGone.set(gone);
        mMap.put("hello","zwe");
        mMap.put("hi","lpm");
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(com.zwe.databindingdemo.BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(com.zwe.databindingdemo.BR.lastName);//这里要写完整的包名
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIsGone(boolean gone){
        isGone.set(gone);
        notifyChange();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
