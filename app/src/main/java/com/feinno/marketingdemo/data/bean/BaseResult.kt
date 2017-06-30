package com.feinno.marketingdemo.data.bean

/**
 * @project: KotlinMvpDemo
 * @description: // 数据返回超类
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 11:14
 * @updateUser zzy05
 * @update 2017/6/27 11:14
 * @version V1.0
 */
open class BaseResult<T>(val code: Int = 10001, val desc: String = "", val data: T? = null)