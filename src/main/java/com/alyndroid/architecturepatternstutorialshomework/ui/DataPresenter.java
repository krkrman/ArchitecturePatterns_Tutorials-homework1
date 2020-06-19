package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.databases.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;

public class DataPresenter {
    DataView dataView;
    DataBase dataBase;

    DataPresenter(DataView dataView){
        this.dataView = dataView;
        dataBase = new DataBase();
    }

    NumberModel getDataNumbers(){
        return dataBase.getNumbers();
    }

    void getResult(){
        int result = getDataNumbers().getFirstNum() / getDataNumbers().getSecondNum();
        dataView.onGetData(String.valueOf(result));
    }

}
