package com.example.user1.homework5adaptersandadapterviews;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user1.homework5adaptersandadapterviews.Adapters.PostAdapter;
import com.example.user1.homework5adaptersandadapterviews.cmn.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    protected PostAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<Post> posts = new ArrayList<>();
        initPosts(posts);
        mAdapter = new PostAdapter(posts);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initPosts(ArrayList<Post> posts) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Post post1 = new Post( "Headline1", getDrawable(R.drawable.btn_down_no),false,false,15,220 );
            posts.add(post1);
            Post post2 = new Post( "Headline2", getDrawable(R.drawable.btn_down_no),false,false,154,220 );
            posts.add(post2);
            Post post3 = new Post( "Headline3", getDrawable(R.drawable.btn_down_no),false,false,164,2012 );
            posts.add(post3);
            Post post4 = new Post( "Headline4", getDrawable(R.drawable.btn_down_no),false,false,1462,2350 );
            posts.add(post4);
            Post post5 = new Post( "Headline5", getDrawable(R.drawable.btn_down_no),false,false,1414,204134 );
            posts.add(post5);
        }

    }
}
