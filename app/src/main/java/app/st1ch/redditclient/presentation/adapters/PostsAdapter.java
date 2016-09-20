package app.st1ch.redditclient.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.st1ch.redditclient.R;
import app.st1ch.redditclient.domain.Post;
import app.st1ch.redditclient.utils.Utillity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by st1ch on 17.09.2016.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<Post> postsList;

    public PostsAdapter(List<Post> postsList) {
        this.postsList = postsList;
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_post, null);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {

        Post post = getItem(position);

        holder.ivPost.setImageResource(R.drawable.icon_reddit);
        holder.tvTitle.setText(post.getTitle());
        String date = Utillity.convertDate(post.getDate());
        holder.tvDate.setText(date);

    }

    public Post getItem(int position){
        return postsList.get(position);
    }

    @Override
    public int getItemCount() {
        if(postsList != null){
            return postsList.size();
        }
        return 0;
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.post_image_view)
        ImageView ivPost;
        @BindView(R.id.title_text_view)
        TextView tvTitle;
        @BindView(R.id.date_text_view)
        TextView tvDate;

        public PostsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
