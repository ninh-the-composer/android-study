package fpt.gstpro.myapi.service;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.gstpro.myapi.R;
import fpt.gstpro.myapi.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView lbUserId;
        public final TextView lbTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.lbUserId = itemView.findViewById(R.id.lbUserId);
            this.lbTitle = itemView.findViewById(R.id.lbTitle);
        }
    }

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }
 @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Post post = posts.get(i);

        viewHolder.lbUserId.setText(Integer.toString(post.getUserId()));
        viewHolder.lbTitle.setText(post.getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setCancelable(true);
                builder.setTitle(post.getTitle());
                builder.setMessage(post.getBody());

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.setPositiveButton("Like", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "Thanks", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (posts != null) {
            return posts.size();
        } else {
            return 0;
        }
    }

    private List<Post> posts;

}
