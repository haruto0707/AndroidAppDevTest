package jp.ac.meijou.android.s221205070;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.Optional;

import jp.ac.meijou.android.s221205070.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    private ActivityMain4Binding binding;

    private final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()) {
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result:" + text)
                                .ifPresent(text -> binding.textView5.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.textView5.setText("Result: Canceled");
                        break;
                    default:
                        binding.textView5.setText("Result: Unknown(" + result.getResultCode() + ")");
                        break;
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button10.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

        binding.button11.setOnClickListener(view-> {
            var intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.yahoo.co.jp"));
            startActivity(intent);
        });

        binding.button12.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity.class);
            intent.putExtra("text", binding.editTextText.getText().toString());
            startActivity(intent);
        });

        binding.button15.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity.class);
            getActivityResult.launch(intent);
        });
    }
}