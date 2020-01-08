package com.apsara.foodmanduassignment.ui.More;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apsara.foodmanduassignment.R;
import com.apsara.foodmanduassignment.api.UserAPI;
import com.apsara.foodmanduassignment.model.User;
import com.apsara.foodmanduassignment.serverresponse.SignUpResponse;
import com.apsara.foodmanduassignment.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText etFirst, etLast, etPhoneNo, etUsername, etPassword, etConfirmPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etFirst = findViewById(R.id.etFirst);
        etLast = findViewById(R.id.etLast);
        etPhoneNo = findViewById(R.id.etPhoneNo);
        etUsername=findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                if (etPassword.getText().toString().equals((etPassword.getText().toString()))) {
//                    saveImageOnly();
                    signup();
                } else {
                    Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    return;
                }
            }
        });
    }
    private void signup() {

        String firstname = etFirst.getText().toString();
        String lastname = etLast.getText().toString();
        String username = etUsername.getText().toString();
//        String email = etEmail.getText().toString();
        String phoneno= etPhoneNo.getText().toString();
        String password = etPassword.getText().toString();


        User user = new User(firstname, lastname, username, phoneno, password);
        UserAPI userapi = Url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> signupResponseCall = userapi.registerUser(user);
        signupResponseCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Code" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
