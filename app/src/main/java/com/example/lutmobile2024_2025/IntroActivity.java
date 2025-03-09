package com.example.lutmobile2024_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutmobile2024_2025.databinding.ActivityIntroBinding;

public class IntroActivity extends HomeActivity {
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
