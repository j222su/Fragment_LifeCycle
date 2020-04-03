package com.example.fragment_lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG="프레그먼트메인엑티비티";
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

//        처음 실행시작하자마자 프레그먼트1이 보이게 하는 명령.
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        Fragment fragmentActivity=null;
//        fragmentActivity = new Fragment1();
//        ft.replace(R.id.frameLayout, fragmentActivity);
//        ft.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        Fragment fragmentActivity=null;
        switch (view.getId()) {
            case R.id.btn1: fragmentActivity =  new Fragment1(); break;
            case R.id.btn2: fragmentActivity =  new Fragment2(); break;
            default:
        }
        ft.replace(R.id.frameLayout, fragmentActivity);
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
