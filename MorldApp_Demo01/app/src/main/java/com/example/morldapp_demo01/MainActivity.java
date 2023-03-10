package com.example.morldapp_demo01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.morldapp_demo01.fragmemt.HomeFragment;
import com.example.morldapp_demo01.fragmemt.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {

        //ActivityMainBinding binding;
       // @SuppressLint("NonConstantResourceId")
    BottomNavigationView BtnNavViewMain;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //binding=ActivityMainBinding.inflate(getLayoutInflater());
            //setContentView(binding.getRoot());
            setContentView(R.layout.activity_main);

            repleceFragment(new HomeFragment());
            BtnNavViewMain=(BottomNavigationView)findViewById(R.id.BtnNavView_Main);

            BtnNavViewMain.setOnItemSelectedListener(item -> {

                switch (item.getItemId()){

                    case R.id.BtnNavView_Main_BtnHome:
                        repleceFragment(new HomeFragment());
                        break;

                    case R.id.BtnNavView_Main_BtnEditor:
                        repleceFragment(new VideoFragment());
                        finish();
                        break;

                }

                return true;
            });


//            binding.BtnNavViewMain.setOnItemSelectedListener(item -> {
//
//                switch (item.getItemId()){
//
//                    case R.id.BtnNavView_Main_BtnHome:
//                        repleceFragment(new HomeFragment());
//                        break;
//
//                    case R.id.BtnNavView_Main_BtnEditor:
//                        repleceFragment(new VideoFragment());
//                        break;
//
//                }
//
//                return true;
//            });
        }

        private void repleceFragment(Fragment fragment) {
            FragmentManager fragmentManager;
            FragmentTransaction fragmentTransaction;
            fragmentManager = getSupportFragmentManager();//??????????????????????????????fragment????????????getChildFragmentManager()???????????????fragment????????????parent??????getParentFragmentManager()???
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.FrameLayout_Main,fragment);
            fragmentTransaction.commit();
        }

    }