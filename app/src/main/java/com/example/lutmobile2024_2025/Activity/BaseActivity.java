package com.example.lutmobile2024_2025.Activity;

import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    Window w = getWindow();
        w.setFlags(
    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

}
