package com.atguigu.juc.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
class User
{
    private Integer id;
    private String  userName;
    private int     age;
}

/**
 * @auther zzyy
 * @create 2019-02-26 22:24
 *
 * 题目：请按照给出数据，找出
 *      偶数ID
 *      年龄大于24
 *      用户名转为大写
 *      用户名字母倒排序
 *      只输出一个
 *
 *      用户名字
 */
public class StreamDemo
{
    public static void main(String[] args)
    {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list1 = new ArrayList<>();
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        for (User user : list) {
			new Thread(() -> {
				if(true) {
					
				}
			},String.valueOf(user.getUserName())).start();
		}

    }
}
