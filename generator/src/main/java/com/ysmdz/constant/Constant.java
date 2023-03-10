package com.ysmdz.constant;

import lombok.Data;

/*
数据库账号密码
数据库名
 */
public enum Constant {
    DATA_SOURCE_URL("192.168.233.128:3307"),
    DATA_SOURCE_USER_NAME("root"),
    DATA_SOURCE_PASSWORD("Amorww2121"),
    content("xcplus_content"),
    learning("xcplus_learning"),
    media("xcplus_media"),
    orders("xcplus_orders"),
    system("xcplus_system"),
    users("xcplus_users"),
    messageHistory("mq_message_history"),
    message("mq_message");

    public String name;

    Constant(String name) {
        this.name=name;
    }
}
