package net.yxcoding.ktmvp.http

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference

/**
 * @author yaxiong.fang
 * @Description: ${}
 * @Date 2017/5/24
 * @Time 11:09
 */
object JsonAndObject {

    /**
     * 对象 ===>> json

     * @param object 待转换的对象
     * *
     * @return 类转换后的json数据
     * *
     * @throws IllegalAccessException 异常
     * *
     * @throws InstantiationException 异常
     */
    @Throws(InstantiationException::class, IllegalAccessException::class)
    fun object2Json(`object`: Any): String {
        return JSONArray.toJSONString(`object`)
    }

    /**
     * * json ===>> 对象

     * @param <T>   返回的泛型
     * *
     * @param json  json数据
     * *
     * @param clazz 对象的类全路径
     * *
     * @return 返回的对象
    </T> */
    fun <T> json2Object(json: String, clazz: Class<T>): T {
        return JSONObject.toJavaObject(JSON.parseObject(json), clazz)
    }

    /**
     * json ===>> 对象

     * @param json
     * *
     * @param type
     * *
     * @return
     */
    fun <T> json2Object(json: String, type: TypeReference<T>): T {
        return JSON.parseObject(json, type)
    }

    fun <T> json2Array(json: String, clazz: Class<T>): List<T> {
        return JSON.parseArray(json, clazz)
    }
}
