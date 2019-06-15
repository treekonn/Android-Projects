package by.yakivan.chuckjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://api.icndb.com/jokes/random";

    private OkHttpClient client = new OkHttpClient();
    private ProgressBar bar;
    private TextView textJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNextJoke(View view) {
        loadRandomFact();
    }

    private void loadRandomFact() {
        bar = findViewById(R.id.progressBar);
        textJoke = findViewById(R.id.factTv);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bar.setVisibility(View.VISIBLE);
            }
        });

        Request request = new Request.Builder().url(URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                try {
                    final String text = (new JSONObject(json).getJSONObject("value").get("joke")).toString();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textJoke.setText(text);
                            bar.setVisibility(View.GONE);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
