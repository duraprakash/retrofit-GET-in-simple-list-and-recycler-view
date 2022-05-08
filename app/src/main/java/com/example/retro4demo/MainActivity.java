package com.example.retro4demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 4.6 single row list and recycler view adapter
    // 4.0 initialize recycle view
    RecyclerView recview;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 4.1 connect with xml id
        recview = findViewById(R.id.recview);
        tv = findViewById(R.id.tv);

        // 4.2
        recview.setLayoutManager(new LinearLayoutManager(this));

        // 4.3 call method
        processdata();
    }

    // 4.4 processdata method
    private void processdata() {
//        TODO: 4. change responsemodel
        // create a call if model enque for processing [5]
        Call<List<postsmodal>> call = apicontroller
                // method from apicontroller
                .getInstance()
                .getapi()
                // method from apiset interface
                .getdata();

        // 4.5 execute call
        // rvc response data in simple model type list [6]
        call.enqueue(new Callback<List<postsmodal>>() {
            @Override
//            TODO: 5. change responsemodel
            public void onResponse(Call<List<postsmodal>> call, Response<List<postsmodal>> response) {
                List<postsmodal> data = response.body();

                // checking in recycler view comment this section to remove recycler view
                // 4.7 call myadapter (ADAPTER)
                myadapter adapter = new myadapter(data);
                recview.setAdapter(adapter);

                // just a checking in simple list view comment this section to remove list view
                // for loop to get the data
                for (int i=0; i<data.size();i++){
                    tv.append(
                    "\n\nid: " +data.get(i).getId()
                    + "\ntitle: " +data.get(i).getTitle()
                    + "\nbody: " +data.get(i).getBody()
                    );
                }

            }

            @Override
//            TODO: 6. change responsemodel
            public void onFailure(Call<List<postsmodal>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Sorry! " +t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}