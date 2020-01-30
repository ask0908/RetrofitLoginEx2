package com.example.retrofitloginex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListener {

    // 커밋 테스트
    public static PrefConfig prefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefConfig = new PrefConfig(this);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            if (prefConfig.readLoginStatus()) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new WelcomeFragment()).commit();
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();
            } // 여기까지 코딩했고 집 가서 핸드폰 연결하고 어떻게 되는지 확인하기(영상 42:47~부터 보면 됨)

        }
    }

    @Override
    public void performRegister()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                                               new RegistrationFragment())
                .addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name)
    {

    }
}
