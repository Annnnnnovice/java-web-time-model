package com.inet.timemodel.utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
/**
 * JSON工具类
 * @author HCY
 * @since 2021/1/26 上午9:29
*/
public class JsonUtils {
    /**
     * 定义jackson对象
     * @author HCY
     * @since 2021/1/26 上午9:30
    */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * @author HCY
     * @since 2021/1/26 下午5:21
     * @param data:
     * @return java.lang.String
    */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * @author HCY
     * @since 2021/1/26 下午5:21
     * @param jsonData:
     * @param beanType:
     * @return T
    */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * @author HCY
     * @since 2021/1/26 下午5:21
     * @param jsonData:
     * @param beanType:
     * @return java.util.List<T>
    */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
