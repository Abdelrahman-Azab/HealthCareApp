package com.example.android.healthcare;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class WorkOut extends AppCompatActivity  {
RecyclerView mRecyclerView;
MyAdapter myAdapterr;
    ArrayList<Model> models =new ArrayList<>();
    private  static  final  String TAG="NOTE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapterr =new MyAdapter(this,getMyList());
        mRecyclerView.setAdapter(myAdapterr);
    }



    private ArrayList<Model> getMyList(){

        Model m =new Model();
       // m.setTitle("");
        m.setImage(R.drawable.absbeginner);
        models.add(m);

        m =new Model();
        //m.setTitle("");
        m.setImage(R.drawable.chestbeginner);
        models.add(m);

        m =new Model();
        //m.setTitle("");
        m.setImage(R.drawable.armbeginner);
        models.add(m);

        m =new Model();
      //  m.setTitle("");
        m.setImage(R.drawable.legbeginner);
        models.add(m);


        m =new Model();
        //m.setTitle("");
        m.setImage(R.drawable.shoulderbeginner);
        models.add(m);

        m =new Model();
     //   m.setTitle("Intermediate");
        m.setImage(R.drawable.absintermediate);
        models.add(m);

        m =new Model();
      //  m.setTitle("");
        m.setImage(R.drawable.chestintermediate);
        models.add(m);


        m =new Model();
      //  m.setTitle("");
        m.setImage(R.drawable.armintermediate);
        models.add(m);

        m =new Model();
       // m.setTitle("");
        m.setImage(R.drawable.legintermediate);
        models.add(m);

        m =new Model();
       // m.setTitle("");
        m.setImage(R.drawable.shoulderintermediate);
        models.add(m);

        m =new Model();
      //  m.setTitle("Advanced");
        m.setImage(R.drawable.absadvanced);
        models.add(m);

        m =new Model();
       // m.setTitle("");
        m.setImage(R.drawable.chestadvanced);
        models.add(m);

        m =new Model();
       // m.setTitle("");
        m.setImage(R.drawable.armadvanced);
        models.add(m);

        m =new Model();
      //  m.setTitle("");
        m.setImage(R.drawable.legadvanced);
        models.add(m);

        m =new Model();
       // m.setTitle("");
        m.setImage(R.drawable.shoulderadvanced);
        models.add(m);
        return models;
    }
}