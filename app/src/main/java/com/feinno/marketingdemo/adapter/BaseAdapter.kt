package com.feinno.marketingdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feinno.marketingdemo.extend.ctx

/**
 * @project: KotlinMvpDemo
 * @description: //TODO(用一句话描述该文件做什么)
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 14:55
 * @updateUser zzy05
 * @update 2017/6/27 14:55
 * @version V1.0
 */
class BaseAdapter<T>(val layoutResourceId: Int, var items: List<T>, val init: (View, T) -> Unit) :
        RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val view = LayoutInflater.from(parent.ctx).inflate(layoutResourceId, parent, false)
        return ViewHolder(view, init)
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder<in T>(view: View, val init: (View, T) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindData(item: T) {
            with(item) {
                init(itemView, item)
            }
        }
    }
}