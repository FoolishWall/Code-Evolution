package com.njupt.zookeeperlock.zkclient;


import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * @author wall
 * @date 2019/5/17  10:06
 * @description zookeeper序列化
 */
public class MyZkSerializer implements ZkSerializer {

    private String charset = "UTF-8";

    //序列化
    @Override
    public byte[] serialize(Object o) throws ZkMarshallingError {

        try {
            return String.valueOf(o).getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    //反序列化
    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {

        try {
            return new String(bytes,charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
