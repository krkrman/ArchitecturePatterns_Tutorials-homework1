package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databases.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.models.NumberModel;

public class MainActivity extends AppCompatActivity implements DataView {

    NumberModel numberModel;
    DataBase dataBase;
    DataPresenter dataPresenter;
    ActivityMainBinding binding;

    NumbersViewModel numbersViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBase = new DataBase();
        numberModel = dataBase.getNumbers();
        dataPresenter = new DataPresenter(this);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        numbersViewModel = new ViewModelProvider(this).get(NumbersViewModel.class);
        numbersViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String result) {
                binding.mulResultTextView.setText(result);
            }
        });

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MVC_plusOperation();
            }
        });

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MVP_divOperation();
            }
        });

        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MVVM_mulOperation();
            }
        });
    }

    private void MVVM_mulOperation() {
        numbersViewModel.getResult();
    }

    private void MVP_divOperation() {
        dataPresenter.getResult();
    }

    private void MVC_plusOperation() {
        binding.plusResultTextView.setText(String.valueOf(numberModel.getFirstNum() + numberModel.getSecondNum()));
    }

    @Override
    public void onGetData(String result) {
        binding.divResultTextView.setText(result);
    }
}
