package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * redis相关测试
 *
 * @author hejq
 * @date 2018-10-18 11:20
 */
public class RedisTest {

    private Jedis jedis;

    /**
     * redis连接属性
     */
    @Before
    public void step() {
        String ip = "127.0.0.1";
        int port = 6379;
        jedis = new Jedis(ip, port);
    }

    @Test
    public void stringTest() {
        // 设置默认key值
        String key = "user";

        // 插入
        // 命令 set key value
        jedis.set(key, "hejq, 26, M, singleDog");
        System.out.println("insert value： " + jedis.get(key) + "\n");

        // 拼接
        // 命令 append key value
        jedis.append(key, " -extra");
        System.out.println("append value: " + jedis.get(key) + "\n");

        // 删除
        // del key
        jedis.del(key);
        System.out.println("delete value: " + jedis.get(key) + "\n");

        // 插入多个值
        jedis.mset(key, "hejq", "26", "M", "singleDog");
        System.out.println("mset value: " + jedis.get(key) + "\n");

    }

    /**
     * map 测试
     */
    @Test
    public void mapTest() {
        String key = "userInfo";
        Map<String, String> map = new HashMap<>();
        map.put("name", "hejq");
        map.put("age", "26");
        map.put("sex", "M");
        map.put("descr", "singleDog");
        jedis.hmset(key, map);

        // hget key field
        System.out.println("insert Map: " + jedis.hmget(key, "name", "age", "sex") + "\n");

        // hdel key field
        jedis.hdel(key, "descr");
        System.out.println("delete key field: " + key + "-" + "descr " + jedis.hget(key, "descr") + "\n");

        // hlen key
        System.out.println("len: " + jedis.hlen(key) + "\n");

        // hkeys key
        System.out.println("hkeys: " + jedis.hkeys(key) + "\n");

        // 遍历循环
        Iterator<String> iterator = jedis.hkeys(key).iterator();
        while (iterator.hasNext()) {
            String field = iterator.next();
            System.out.println("Iterator field: " + field + "->" + jedis.hmget(key, field) + "\n");
        }
    }

    /**
     * list 测试
     */
    @Test
    public void listTest() {

        String key = "userInfo";

        jedis.del(key);

        System.out.println("after delete userInfo: " + jedis.lrange(key, 0, -1) + "\n");

        // add to list
        jedis.lpush(key, "name");
        jedis.lpush(key, "age");
        jedis.lpush(key, "sex");
        jedis.lpush(key, "tel");

        System.out.println("after add to list: " + jedis.lrange(key, 0, -1) + "\n");
    }

    /**
     * set 测试
     */
    @Test
    public void setTest() {
        String key = "userInfo";
        jedis.del(key);

        // add element
        jedis.sadd(key, "name");
        jedis.sadd(key, "sex");
        jedis.sadd(key, "age");
        System.out.println("before delete " + jedis.smembers(key) + "\n");

        // delete element
        jedis.srem(key, "name");
        System.out.println("after delete name: " + jedis.smembers(key) + "\n");
        // 所有元素的value()
        System.out.println("Key的value值[删除后]:" + jedis.smembers(key) + "\n");
        // 判断值是否存在
        System.out.println("判断值是否存在:" + jedis.sismember(key, "age") + "\n");
        // 返回集合元素的个数
        System.out.println("返回集合元素的个数:" + jedis.scard(key) + "\n");
        // 返回随机元素
        System.out.println("返回随机元素:" + jedis.srandmember(key) + "\n");
    }

    /**
     * delete
     *
     * @param key
     */
    public void delKey(String key) {
        jedis.del(key);
    }
    /**
     * sort 排序测试
     */
    @Test
    public void sortTest() {
        String key = "sort";

        // add element
        jedis.rpush(key, "1");
        jedis.rpush(key, "3");
        jedis.rpush(key, "4");
        jedis.rpush(key, "5");
        jedis.rpush(key, "2");
        System.out.println(" after sort " + jedis.sort(key) + "\n");
    }

    /**
     * Chinese 测试
     */
    @Test
    public void  chineseTest() {
        String key = "name";
        jedis.set(key, "何建清");
        System.out.println(jedis.get(key));
    }
}
