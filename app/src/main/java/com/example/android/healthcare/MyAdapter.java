package com.example.android.healthcare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myHolder> {
    private Context c;
    private ArrayList<Model> models;

    public MyAdapter(Context c,ArrayList<Model> models) {

        this.c=c;
        this.models = models;

    }

    @Override
    public myHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup, false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
       // holder.mtitle.setText(models.get(position).getTitle());
        holder.mImageView.setImageResource(models.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return models.size();

    }
   /*public interface SelectedUser
    {
        void selecteduserr(View v,int position);
    }*/
    public class myHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        ImageView mImageView;
        TextView mtitle;

        public myHolder(View itemView) {
            super(itemView);
            this.mImageView=itemView.findViewById(R.id.imageview);
            //this.mtitle=(TextView)itemView.findViewById(R.id.title);
            //itemView.setOnClickListener((View.OnClickListener) this);
           itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            if (position==0)
            {
                Intent intent=new Intent(c,absbeginner.class);
                c.startActivity(intent);
            }
            else if(position==1)
            {
                Intent intent=new Intent(c,chestbeginner.class);
                c.startActivity(intent);
            }
            else if(position==2)
            {
                Intent intent=new Intent(c,armbeginner.class);
                c.startActivity(intent);
            }
            else if(position==3)
            {
                Intent intent=new Intent(c,legbeginner.class);
                c.startActivity(intent);
            }
            else if(position==4)
            {
                Intent intent=new Intent(c,shoulderbeginner.class);
                c.startActivity(intent);
            }
            else if(position==5)
            {
                Intent intent=new Intent(c,absintermediate.class);
                c.startActivity(intent);
            }
            else if(position==6)
            {
                Intent intent=new Intent(c,chestintermediate.class);
                c.startActivity(intent);
            }
            else if(position==7)
            {
                Intent intent=new Intent(c,armintermediate.class);
                c.startActivity(intent);
            }
            else if(position==8)
            {
                Intent intent=new Intent(c,legintermediate.class);
                c.startActivity(intent);

            }
            else if(position==9)
            {
                Intent intent=new Intent(c,shoulderintermediate.class);
                c.startActivity(intent);
            }
            else if(position==10)
            {
                Intent intent=new Intent(c,absadvanced.class);
                c.startActivity(intent);
            }
            else if(position==11)
            {
                Intent intent=new Intent(c,chestadvanced.class);
                c.startActivity(intent);
            }
            else if(position==12)
            {
                Intent intent=new Intent(c,armadvanced.class);
                c.startActivity(intent);
            }
            else if(position==13)
            {
                Intent intent=new Intent(c,legadvanced.class);
                c.startActivity(intent);
            }
            else if(position==14)
            {
                Intent intent=new Intent(c,shoulderadvanced.class);
                c.startActivity(intent);
            }

        }
    }
}
