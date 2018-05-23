package com.example.claudio.myapplication.model;

import android.text.TextUtils;

import com.example.claudio.myapplication.presenter.ILoginPresenter;
import com.example.claudio.myapplication.view.ILoginView;

/**
 * Created by claudio on 23/05/18.
 */

public class PresenterImpl implements ILoginPresenter{

    ILoginView loginView;

    public PresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String username, String password) {

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            loginView.loginValidations();
        }else {
            if (username.equals("user") && password.equals("password")){
                loginView.loginSuccess();
            }else {
                loginView.loginError();
            }
        }
    }
}
