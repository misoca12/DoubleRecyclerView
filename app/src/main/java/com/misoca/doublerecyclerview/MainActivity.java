package com.misoca.doublerecyclerview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<String> list1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list1.add("RecyclerView1の" + i + "行目");
		}
		SampleAdapter1 adapter1 = new SampleAdapter1(this, list1);
		RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view_1);
		recyclerView1.setLayoutManager(new LinearLayoutManager(this));
		recyclerView1.setNestedScrollingEnabled(false);
		recyclerView1.setAdapter(adapter1);

		ArrayList<String> list2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list2.add("RecyclerView2の" + i + "行目");
		}
		SampleAdapter2 adapter2 = new SampleAdapter2(this, list2);
		RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view_2);
		recyclerView2.setLayoutManager(new LinearLayoutManager(this));
		recyclerView2.setNestedScrollingEnabled(false);
		recyclerView2.setAdapter(adapter2);

		final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
		swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						swipeRefreshLayout.setRefreshing(false);
					}
				}, 1000);
			}
		});

	}
}
