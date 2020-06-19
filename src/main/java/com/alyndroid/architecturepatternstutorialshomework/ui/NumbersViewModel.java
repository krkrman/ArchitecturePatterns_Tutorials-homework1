package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.databases.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;

public class NumbersViewModel extends ViewModel {
    DataBase dataBase = new DataBase();
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    NumberModel getDataNumbers(){
        return dataBase.getNumbers();
    }

    void getResult(){
        int result = getDataNumbers().getFirstNum() * getDataNumbers().getSecondNum();
        mutableLiveData.setValue(String.valueOf(result));
    }
}
