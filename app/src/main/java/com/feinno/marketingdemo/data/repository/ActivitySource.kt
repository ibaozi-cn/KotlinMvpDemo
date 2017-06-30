package com.feinno.marketingdemo.data.repository

import com.feinno.marketingdemo.data.bean.*
import com.feinno.marketingdemo.data.net.ServiceFactory
import retrofit2.Call
import retrofit2.Response

/**
 * @project: KotlinMvpDemo
 * @description: //活动查询管理
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 15:44
 * @updateUser zzy05
 * @update 2017/6/27 15:44
 * @version V1.0
 */
object ActivitySource {
    /**
     * 活动专区查询
     */
    fun getActivityList(paramActivityList: ParamActivityList, success: (ResultActivityList?, retry: () -> Unit) -> Unit, fail: (Throwable?, retry: () -> Unit) -> Unit) {

        val call = ServiceFactory.serviceActivity.getActivityList(paramActivityList)

        call.enqueue(object : retrofit2.Callback<ResultActivityList> {

            override fun onFailure(call: Call<ResultActivityList>?, t: Throwable?) {
                fail(t, {
                    getActivityList(paramActivityList, success, fail)
                })
            }

            override fun onResponse(call: Call<ResultActivityList>?, response: Response<ResultActivityList>?) {
                success(response?.body(),{
                    getActivityList(paramActivityList, success, fail)
                })
            }
        })
    }

    /**
     * 业务响应查询
     */
    fun getBusinessRes(paramBusinessRespond: ParamBusinessRespond, success: (ResultActivityList?) -> Unit, fail: (Throwable?) -> Unit) {
        val call = ServiceFactory.serviceActivity.getBusinessRes(paramBusinessRespond)

        call.enqueue(object : retrofit2. Callback <ResultActivityList> {

            override fun onFailure(call: Call<ResultActivityList>?, t: Throwable?) {
                fail(t)
            }

            override fun onResponse(call: Call<ResultActivityList>?, response: Response<ResultActivityList>?) {
                success(response?.body())
            }
        })
    }

    /**
     * 业务查询
     */
    fun getBusiness(paramBusiness: ParamBusiness, success: (ResultBusiness?) -> Unit, fail: (Throwable?) -> Unit) {

        val call = ServiceFactory.serviceActivity.getBusiness(paramBusiness)

        call.enqueue(object : retrofit2. Callback <ResultBusiness> {

            override fun onFailure(call: Call<ResultBusiness>?, t: Throwable?) {
                fail(t)
            }

            override fun onResponse(call: Call<ResultBusiness>?, response: Response<ResultBusiness>?) {
                success(response?.body())
            }
        })
    }

}

