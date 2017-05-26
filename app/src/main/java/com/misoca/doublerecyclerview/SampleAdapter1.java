package com.misoca.doublerecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static com.misoca.doublerecyclerview.R.id.parent;

/**
 * Created by ta-kimura on 2017/05/25.
 */

public class SampleAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private ArrayList<String> mList;
	private Context mContext;

	public static class ItemViewHolder extends RecyclerView.ViewHolder {

		public ItemViewHolder(View v) {
			super(v);
		}
	}

	/**
	 * コンストラクタ
	 * @param context
	 */
	public SampleAdapter1(Context context, ArrayList<String> textList) {
		mContext = context;
		mList = textList;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample, parent, false);
		return new ItemViewHolder(v);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		TextView textView = (TextView) holder.itemView.findViewById(R.id.text_sample);
		textView.setText(mList.get(position));
		textView.setBackgroundColor(Color.CYAN);
	}

	@Override
	public int getItemCount() {
		return mList == null ? 0 : mList.size();
	}
}
