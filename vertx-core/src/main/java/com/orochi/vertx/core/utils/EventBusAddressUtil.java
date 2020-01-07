package com.orochi.vertx.core.utils;

import java.util.Objects;

/**
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_
 * //                         o8888888o
 * //                         88" . "88
 * //                         (| ^_^ |)
 * //                         O\  =  /O
 * //                      ____/`---'\____
 * //                    .'  \\|     |//  `.
 * //                   /  \\|||  :  |||//  \
 * //                  /  _||||| -:- |||||-  \
 * //                  |   | \\\  -  /// |   |
 * //                  | \_|  ''\---/''  |   |
 * //                  \  .-\__  `-`  ___/-. /
 * //                ___`. .'  /--.--\  `. . ___
 * //              ."" '<  `.___\_<|>_/___.'  >'"".
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /
 * //      ========`-.____`-.___\_____/___.-`____.-'========
 * //                           `=---='
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * //         佛祖保佑       永无BUG     永不修改
 * ////////////////////////////////////////////////////////////////////
 *@Description: 地址处理工具
 *
 *@author  Orochi-Yzh
 *@dateTime  1/4/2020 3:34 PM
*/
public final class EventBusAddressUtil {

    /**
     * 地址正向编,解决集群中“/”的问题,默认是以点的形式
     */
    public static String positiveFormate(Class<?> clazz) {
        Objects.requireNonNull(clazz, "clazz must not be null.");
        return clazz.getName();
    }

    /**
     * 地址正向编,解决集群中“/”的问题,默认是以点的形式 (适用于集群，将自定义的router api中“/” 转换成“.”)
     */
    public static String positiveFormate(String address) {
        Objects.requireNonNull(address, "address must not be null.");
        if (address.startsWith("/")) {
            address = address.substring(1);
        }
        return address.trim().replace("/", ".");
    }

    /**
     * 反向解析,还原地址 适用于根据api router去寻址对应的class
     */
    public static String negativeFormate(String address) {
        Objects.requireNonNull(address, "address must not be null.");
        return address.trim().replace(".", "/");
    }
}