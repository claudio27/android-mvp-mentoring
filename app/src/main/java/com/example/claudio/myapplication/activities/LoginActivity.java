package com.example.claudio.myapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.claudio.myapplication.R;
import com.example.claudio.myapplication.model.PresenterImpl;
import com.example.claudio.myapplication.presenter.ILoginPresenter;
import com.example.claudio.myapplication.view.ILoginView;

public class LoginActivity extends Activity implements View.OnClickListener, ILoginView {

    EditText etUserName, etPassword;
    TextView tvLogin;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = findViewById(R.id.etPassword);
        etUserName = findViewById(R.id.etUserName);
        tvLogin = findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(this);

        presenter = new PresenterImpl(LoginActivity.this);
    }

    @Override
    public void onClick(View view) {

        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        presenter.performLogin(userName, password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "Ingresa Username o Password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Login Ok", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login Fallo", Toast.LENGTH_LONG).show();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = etUserName;
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
