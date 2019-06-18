package com.function.luo.mvvm;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.function.luo.mvvm.bean.CommonInterface;
import com.function.luo.mvvm.bean.User;
import com.function.luo.mvvm.utils.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        btn1 = findViewById(R.id.btn1);
        init();
    }

    private void init() {
        List<String> list = new ArrayList<>();
        list.add("JAVA");
        list.add("Android");
        list.add("IOS");
        list.add(".NET");
        list.add("PHP");
        list.add("C");
        list.add("C++");
        MyAdapter myAdapter = new MyAdapter(this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
        //设置Adapter
        recyclerView.setAdapter(myAdapter);


        /**
         * 点击整个条目
         */
        myAdapter.setOnItemListener(new CommonInterface.OnItemListener() {
            @Override
            public void onItemClick(int points, String msg) {
                Toast.makeText(MainActivity.this,points+msg,Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 点击 Button
         */
        myAdapter.setOnButtonListener(new CommonInterface.OnButtonListener() {
            @Override
            public void OnButtonclick(int points, String msg) {
                Toast.makeText(MainActivity.this,points+msg,Toast.LENGTH_SHORT).show();

            }
        });


        /**
         * Java普通类回调
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new User().setName("赵敏", new CommonInterface.OnChangeNameLister() {
                    @Override
                    public void onChangeName(String name) {
                        Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
