package com.feinno.marketingdemo.data.net

import com.feinno.marketingdemo.data.bean.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @project: KotlinMvpDemo
 * @description: //活动接口
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 b:38
 * @updateUser zzy05
 * @update 2017/6/27 b:38
 * @version V1.0
 */
interface ServiceActivity {

    /**
     * H5活动专区接口
     */
    @POST("marketPlat/activity/h5list")
    fun getActivityList(@Body paramActivityList: ParamActivityList): Call<ResultActivityList>


    @POST("marketPlat/activity/getBusResp")
    fun getBusinessRes(@Body paramBusinessRespond: ParamBusinessRespond):Call<ResultActivityList>


    @POST("marketPlat/activity/getBus")
    fun  getBusiness(@Body paramBusiness: ParamBusiness):Call<ResultBusiness>
}