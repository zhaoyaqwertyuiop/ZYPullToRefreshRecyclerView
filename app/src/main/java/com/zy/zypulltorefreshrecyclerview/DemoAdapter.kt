package com.zy.zypulltorefreshrecyclerview

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zy.pulltorefreshrecyclerview.PullToRefreshRecyclerView
import kotlinx.android.synthetic.main.item_demo_recyclerview.view.*

/**
 * Created by zhaoya on 2017/11/2.
 */
open class DemoAdapter constructor(dataList:ArrayList<HashMap<String, String>>): PullToRefreshRecyclerView.IRecyclerViewAdapter {

    val dataList:ArrayList<HashMap<String, String>>
    init {
        this.dataList = dataList
    }
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    override fun getViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_demo_recyclerview, null, false)
        return ItemViewHolder(view)
    }

    override fun setViewHolder(adapter: RecyclerView.Adapter<*>?, holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bindData(dataList.get(position))
        }
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(item: HashMap<String, String>) {
            when (item["messageType"]) {
                "news" -> {
                    itemView.labelTV.text = "新闻"
                    itemView.labelTV.setBackgroundResource(R.drawable.shape_news_bg)
                }
                "debt",
                "notice" -> {
                    itemView.labelTV.text = "通知"
                    itemView.labelTV.setBackgroundResource(R.drawable.shape_news_bg)
                }
                "announcement" -> {
                    itemView.labelTV.text = "公告"
                    itemView.labelTV.setBackgroundResource(R.drawable.shape_news_bg)
                }
                else -> {
                    itemView.labelTV.text = "其他"
                    itemView.labelTV.setBackgroundResource(R.drawable.shape_news_bg)
                }
            }

            itemView.titleTV.text = item.get("msgTitle")
            itemView.dateTV.text = item.get("receiveTime")
            itemView.contentTV.text = item.get("msgContent")
        }
    }
}