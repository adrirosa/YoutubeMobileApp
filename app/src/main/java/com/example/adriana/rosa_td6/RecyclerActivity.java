package com.example.adriana.rosa_td6;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;


public class RecyclerActivity extends AppCompatActivity {

    private final String apiKey = "AIzaSyCUt_rxw_OhNaeOcbC38A_d0ODo8DuE2D8";
    private String url = "https://www.googleapis.com/youtube/v3/search?";
    //https://www.googleapis.com/youtube/v3/search?part=snippet&q=truc&type=video&key=
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        String keyword = intent.getStringExtra("Keyword");


        //call method to search videos
        getVideos(keyword, apiKey);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //construct the request
    //call the api
    //catch the result (json) + deserialize
    private void getVideos(String keyword, String apiKey) {
        StringRequest contractsRequest = new StringRequest(url +"&part=snippet&q="+ keyword + "&type=video&maxResult=10&key="+ apiKey, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //gson return an object video with a list of video
                //need to parse them
                VideoItem video = new Gson().fromJson(response, VideoItem.class);

                setAdapter(video.getItems());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VideoItem", "Error");
            }
        });
        Volley.newRequestQueue(this).add(contractsRequest);
    }

    private void setAdapter(List<VideoItem.ItemsBean> video) {
        VideoAdapter adapter = new VideoAdapter(video);
        //adapter.setOnVideoSelectedListener();
        recyclerView.setAdapter(adapter);
    }

    /*
    @Override
    public void onVideoSelected(VideoItem v) {
        int position = v.getItems().indexOf(v);
       RecyclerActivity.start(this, v.getItems().get(position).getSnippet().getTitle());
    }

    private static void start(RecyclerActivity recyclerActivity, String title) {
        recyclerActivity.startActivity(new Intent());
    }
    */
}
