package jp.ac.meijou.android.s221205070;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import jp.ac.meijou.android.s221205070.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView2.setVisibility(View.GONE);
    }
}