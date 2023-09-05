package jp.ac.meijou.android.s221205070;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import jp.ac.meijou.android.s221205070.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private  PrefDataStore prefDataStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);

       binding.button.setOnClickListener(view -> {
           var text = binding.editTextText2.getText().toString();
           prefDataStore.setString("name", text);
       } );

        Log.d("Appmsg", "onCreate text: "+ binding.text.getText());
    }
    @Override
    protected void onStart(){
        super.onStart();
        prefDataStore.getString("name")
                .ifPresent(name -> binding.text.setText(name));
        Log.d("Appmsg", "onStart text: "+ binding.text.getText());

    }
}