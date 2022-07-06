package com.example.postretrofitcallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.postretrofitcallapi.api.ApiService;
import com.example.postretrofitcallapi.model.Post;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.postretrofitcallapi.utils.Config.*;

public class MainActivity extends AppCompatActivity {
    private TextView tvTerm, tvSource, tvUSD;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTerm = findViewById(R.id.tv_terms);
        tvSource = findViewById(R.id.tv_source);
        tvUSD = findViewById(R.id.tv_usd);
        btnClick = findViewById(R.id.btn_click);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senPost();
            }
        });

    }

    private void senPost() {
        Post post = new Post(10, 101, "FhamThoai", "DDDDD");
        ApiService.apiService.sendPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                Post postResult = response.body();
                if (post != null) {
                    tvUSD.setText(postResult.toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }


}