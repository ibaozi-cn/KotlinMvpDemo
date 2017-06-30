package com.feinno.marketingdemo.data.bean

import com.feinno.marketingdemo.BuildConfig

/**
 * @project: KotlinMvpDemo
 * @description: //请求参数
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 15:13
 * @updateUser zzy05
 * @update 2017/6/27 15:13
 * @version V1.0
 */
/*
 * userid: int	//用户或机构id
 * status: int		//登录身份标识 1用户 2机构
 * browser:string	//浏览器标识
 * clientType: int	//客户端标识1Android 2Ios 3H5 4Web
 * version: string	//客户端版本
 * token: string	//鉴权token
 * logoutTime: string	  //超时时间
 * url:String     //请求的url  例 marketPlat/activity/add
 * identity:int    //用户身份
 */
data class Authinfo(
        val userid: Int = 1,
        val status: Int = 1,
        val browser: String = "android",
        val clientType: Int = 1,
        val version: String = BuildConfig.VERSION_NAME,
        val token: String = "",
        val logoutTime: String = "50000",
        val url: String = "",
        val identity: Int = 1)

/**
 * 活动专区列表查询参数
 * agenid: int     //机构ID
 * chid：int       //渠道id
 * cmid：int     //客户id
 *
 */
data class ParamActivityList(
        val authinfo: Authinfo,
        val agenid: Int = 1001,
        val chid: Int = 1,
        val cmid: Int,
        val pagination: Pagination = Pagination())

/**
 *  //运营位查询实体类
 */
data class ParamOperationQuery(
        val authinfo: Authinfo,
        var operationId: Int = 123,
        var userId: Int = 123,
        var channel: Int = 1)

/**
 * agenid: int     //机构ID
 * chid：int       //渠道id
 * busid: int      //业务id
 * bcode:String   //业务编号
 * bname:String  //业务名称
 */
data class ParamBusinessRespond(
        val authinfo: Authinfo,
        val agenid: Int = 1001,
        val chid: Int = 1,
        val bcode: String,
        val bvalue: String,
        val pagination: Pagination = Pagination())

/**
 * 	 String bname;     //业务名称
 int chid;       //渠道id
 int  btyid;     //业务类型id
 String  bcode;      //业务编号
 int agenid;      //机构ID
 */
data class ParamBusiness(
        val authinfo: Authinfo,
        val agenid: Int = 1001,
        val chid: Int = 1,
        val btyid: Int,
        val bcode: String,
        val bname: String,
        val pagination: Pagination = Pagination()
)