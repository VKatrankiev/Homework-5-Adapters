package com.example.user1.homework5adaptersandadapterviews.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user1.homework5adaptersandadapterviews.CommentActivity;
import com.example.user1.homework5adaptersandadapterviews.MainActivity;
import com.example.user1.homework5adaptersandadapterviews.R;
import com.example.user1.homework5adaptersandadapterviews.cmn.Post;

import java.util.ArrayList;

/**
 * Created by user1 on 20.7.2016 г..
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    ArrayList<Post> posts;
    private Context context;

    public PostAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtHeadline;
        private ImageView imgPost;
        private Button btnUp;
        private Button btnDown;
        private Button btnMore;
        private Button btnComment;
        private Button btnShare;
        private TextView txtComments;
        private TextView txtPoints;

        public ViewHolder(View v) {
            super(v);
            txtHeadline = (TextView) v.findViewById(R.id.headline);
            txtComments = (TextView) v.findViewById(R.id.txt_comments);
            txtPoints = (TextView) v.findViewById(R.id.txt_points);
            btnComment = (Button) v.findViewById(R.id.btn_comments);
            btnUp = (Button) v.findViewById(R.id.btn_up);
            btnDown = (Button) v.findViewById(R.id.btn_down);
            btnMore = (Button) v.findViewById(R.id.btn_more);
            btnShare = (Button) v.findViewById(R.id.btn_share);
            imgPost = (ImageView) v.findViewById(R.id.imageview);
        }

    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_post, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Post currentPost = posts.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.imgPost.setBackground(currentPost.getPostPicture());
        }
        holder.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPost.isBtnUp()) {
                    currentPost.setBtnUp(false);
                    currentPost.setBtnDown(true);
                    //holder.btnDown.setBackgroundResource(R.drawable.down_button);
                    holder.btnUp.setBackgroundResource(R.drawable.btn_up_no);
                }
                holder.btnDown.setBackgroundResource(R.drawable.down_button);

            }
        });
        holder.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPost.isBtnDown()) {
                    currentPost.setBtnDown(false);
                    currentPost.setBtnUp(true);
                    //holder.btnUp.setBackgroundResource(R.drawable.Up_Button);
                    holder.btnDown.setBackgroundResource(R.drawable.btn_down_no);
                }
                holder.btnUp.setBackgroundResource(R.drawable.Up_Button);

            }
        });
        holder.txtHeadline.setText(currentPost.getHeadline());
        holder.txtComments.setText(String.valueOf(currentPost.getNumComments()));
        holder.txtPoints.setText(String.valueOf(currentPost.getNumPoints()));
        holder.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, CommentActivity.class));
            }
        });

    }


    @Override
    public int getItemCount() {
        return posts.size();
    }
}
