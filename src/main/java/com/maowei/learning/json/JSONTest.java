package com.maowei.learning.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: JSONTest.java, v 0.1 2017年12月21日 上午11:21:21 alexsong Exp $
 */
public class JSONTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.setName("Alex");
        p1.setAge(21);
        p1.setMarried(false);

        String[] phoneNums1 = {"11111","22222"};
        p1.setPhoneNums(phoneNums1);

        List<String> address1 = new ArrayList<String>();
        address1.add("aaaaa");
        address1.add("bbbbb");
        p1.setAddress(address1);

        Person p2 = new Person();
        p2.setName("Bob");
        p2.setAge(22);
        p2.setMarried(true);

        String[] phoneNums2 = {"33333","44444"};
        p2.setPhoneNums(phoneNums2);

        List<String> address2 = new ArrayList<String>();
        address2.add("ccccc");
        address2.add("ddddd");
        p2.setAddress(address2);

        Person p3 = new Person();
        p3.setName("Cathy");
        p3.setAge(23);
        p3.setMarried(false);

        String[] phoneNums3 = {"55555","66666"};
        p3.setPhoneNums(phoneNums2);

        List<String> address3 = new ArrayList<String>();
        address3.add("eeeee");
        address3.add("fffff");
        p3.setAddress(address3);

        p1.getFriends().add(p2);
        p1.getFriends().add(p3);

        String p1JsonStr = JSON.toJSONString(p1, true);

        System.out.println(p1JsonStr);

        Map<String,Object> map = JSON.parseObject(p1JsonStr, new TypeReference<Map<String, Object>>(){});
    }
}
