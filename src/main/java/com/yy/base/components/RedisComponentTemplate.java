package com.yy.base.components;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * Redis封装的功能功能组件实现如下
 * redis当中的所有的方法都是原子的
 */
public class RedisComponentTemplate {


    @Autowired
    private Jedis jedis;


    /**
     * 增加方法
     */
    public <T> Boolean add(String key,T value){
        try{
            String beanJson=beanToJson(value);
            if(beanJson==null||beanJson.length()<=0){
                return false;
            }
            jedis.set(key,beanJson);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);
        }
    }


    /**
     * 修改方法
     */
    public <T> Boolean set(String key,T value){
        try{
            String beanJson=beanToJson(value);

            if(beanJson==null||beanJson.length()<=0){
                return false;
            }


            jedis.set(key,beanJson);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }


    /**
     * 删除方法
     */
    public <T> Boolean del(String key){
        try{

            if(key==null||key.length()<=0){
                return false;
            }
            jedis.del(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }


    /**
     * 查询方法
     */
    public <T> T get(String key,Class<T> resultValue){
        try{

            if(key==null||key.length()<=0){
                return null;
            }
            String result=jedis.get(key);
            return jsonToBean(result,resultValue);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }





    /**
     * 设置过期时间方法
     */
    public Boolean expire(String key,Integer second){
        try{

            if(key==null||key.length()<=0){
                return false;
            }
            jedis.expire(key, second);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }





    /**
     * Key加1方法
     */
    public Boolean icre(String key){
        try{

            if(key==null||key.length()<=0){
                return false;
            }
            jedis.incr(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }




    /**
     * Key减1方法
     */
    public Boolean decr(String key){
        try{

            if(key==null||key.length()<=0){
                return false;
            }
            jedis.decr(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }


    /**
     * 进行判断Key是否存在
     */
    public Boolean exists(String key){
        try{

            if(key==null||key.length()<=0){
                return false;
            }
            Boolean exists = jedis.exists(key);
            return exists;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            //放加到Jedis池当中
            returnPool(jedis);

        }

    }


    /**
     * 组合Key的方法
     */


    /**
     * 把Json串转换成javaBean对象
     */
    private <T> T jsonToBean(String jsonStr,Class<T> clz){
        if(jsonStr==null||jsonStr.length()<=0||clz==null){
            return null;
        }
        else if(clz==Integer.class||clz==int.class){
                return (T)Integer.valueOf(jsonStr);
        }else if(clz==String.class){
            return (T)jsonStr;
        }else if(clz==Long.class||clz==long.class){
            return (T)Long.valueOf(jsonStr);

        }else {
            T t = JSONObject.parseObject(jsonStr, clz);
            return t;
        }
    }


    /**
     * 把javaBean对象转换成Json字符串
     */
    private <T> String beanToJson(T t){
        if(t==null){
            return null;
        }

        Class<?> valueClass = t.getClass();
        if(valueClass==Integer.class||valueClass==int.class){
            return ""+t;
        }else if(valueClass==Long.class||valueClass==long.class){
            return ""+t;
        }else if(valueClass==String.class){
            return (String)t;
        }else{
            return JSON.toJSONString(t);
        }
    }


    /**
     * 把jedis连接放回连接池当中
     */
    public void returnPool(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }


}
