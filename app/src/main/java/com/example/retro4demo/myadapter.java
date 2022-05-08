package com.example.retro4demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import java.util.List;

// 5.4 extend recyclerview and implement all methods
public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    // 5.0 create myadapter class (ADAPTER)

//  TODO: 7. change responsemodel
    // 5.5 list and create constructor
    List<postsmodal> data;

    // constructor
    public myadapter(List<postsmodal> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 5.7 inflate singlerowdesign layout in recycler view
//        TODO: 8. change singlerowdesign with your list layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postrowdesign, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
//        TODO: 10. change holder.t1,t2 glide with list layout
        // 5.8 get data and tell where to assign/locate them
        holder.tvid.setText(data.get(position).getId());
        holder.tvtitle.setText(data.get(position).getTitle());
        holder.tvbody.setText(data.get(position).getBody());
//        Glide.with(holder.t1.getContext()).load("http://192.168.1.11/api/images/" +data.get(position).getImage()).into(holder.img);
        // 5.9 go to main
    }

    @Override
    public int getItemCount() {

        // 5.6 data size *array | length *other
        return data.size();
    }





    //5.2 create super constructor
    class myviewholder extends RecyclerView.ViewHolder{
//        TODO: 9 change t1,t2,img with list layout
        // 5.1 variables related with singlerowdesign
//        ImageView img;
        TextView tvid, tvtitle, tvbody;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            // 5.3 connect with xml id
            tvid = itemView.findViewById(R.id.tvid);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvbody = itemView.findViewById(R.id.tvbody);
        }
    }

}
