package com.hxx.graduate.test;


import com.hxx.graduate.utils.MD5Utils;
import org.junit.Test;

public class test {
    @Test
    public void md5Test() {
        System.out.println(MD5Utils.getMD5("123456"));
    }
}
