package com.example.mehboob.hunzabikeyarider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mehboob.hunzabikeyarider.adapter.ViewPagerAdapter;
import com.example.mehboob.hunzabikeyarider.databinding.ActivityMainBinding;
import com.example.mehboob.hunzabikeyarider.models.ViewPagerClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ViewPagerClass> list ;
    ActivityMainBinding binding;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnStart.setOnClickListener(view -> {
            binding.imageview.setVisibility(View.GONE);

            binding.textView2.setVisibility(View.GONE);
            binding.btnStart.setVisibility(View.INVISIBLE);
            binding.btnNext.setVisibility(View.VISIBLE);
            binding.dotsIndicator.setVisibility(View.VISIBLE);
            binding.viewpager2.setVisibility(View.VISIBLE);


            viewPagerAdapter = new ViewPagerAdapter(MainActivity.this);
            binding.viewpager2.setAdapter(viewPagerAdapter);
            binding.dotsIndicator.attachTo(binding.viewpager2);

        });

        binding.viewpager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        controlButtons();
                        break;
                    case 1:
                        controlButtons();
                        break;
                    case 2:
                        binding.btnNext.setVisibility(View.INVISIBLE);
                        binding.btnStart.setVisibility(View.VISIBLE);

                        binding.btnStart.setOnClickListener(v -> {
                            // Intent intent = new Intent(BoardingActivity.this, LoginActivity.class);
                            startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        });
                }


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(BoardingActivity.this, "Clicked successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(BoardingActivity.this, LoginActivity.class);
//                startActivity(intent);
                binding.viewpager2.setCurrentItem(binding.viewpager2.getCurrentItem() + 1, true);
            }
        });
    }

    private void controlButtons() {

        binding.btnNext.setVisibility(View.VISIBLE);
        binding.btnStart.setVisibility(View.INVISIBLE);

    }
}