package com.myapis;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by geet-pc on 16/4/18.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.MyViewHolder> {
    private List<Topic> topicdata;
    private ActionListItem<Topic> mListner;
    private int selected_item;


    public TopicAdapter(ActionListItem<Topic> mListner, List<Topic> arrayList) {
        this.mListner = mListner;
        this.topicdata = arrayList;
    }

    public void updateAdapter(List<Topic> topicdata) {
        this.topicdata = topicdata;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.id.setText(topicdata.get(position).getId());
        holder.name.setText(topicdata.get(position).getName());
        holder.des.setText(topicdata.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
//        return topicdata.size();
        return topicdata.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, des;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            des = itemView.findViewById(R.id.description);
            // viewStub.inflate();
//              job_date =itemView.findViewById(R.id.job_date);
        }
    }
}
