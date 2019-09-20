package common.utils.otherUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.redis.JedisTemplate;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;;

/**
 * @program: Wxplatform
 * @description:
 * @author: zhijie
 * @create: 2019-04-03 13:15
 **/
@Data
@Component
public class RedisPageHelper<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<T> redisData;
    private Long dataTotal;   //数据总条数
    private Long pageTotal;   //总页数
    private Long pageSize; //每页记录
    private int pageNum; //当前页
    private int firstPage;
    private int lastPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasNextPage;
    private boolean hasPrePage;
    @Autowired
    JedisTemplate jedisTemplate;


    @Autowired
    Map map;

    JSON json = new JSONObject();


    public Map findRedisDateByPage(String key, Long pageSize, int pageNum, Class<T> tClass) {
        dataTotal = jedisTemplate.zcard(key);    //缓存的总条数
        setPageSize(pageSize);
        //如果查找出来的总条数小于所设置的每页记录
        if (dataTotal <= this.pageSize) {
            pageTotal = 1L;
            pageNum = 1;
            isFirstPage = true;
            isLastPage = true;
            hasNextPage = false;
            hasPrePage = false;
            firstPage = 1;
            lastPage = 1;
            redisData = json.parseArray(jedisTemplate.zrange(key, 0, -1).toString(), tClass);
            map.put("pageNum", pageNum);
            map.put("pageSize", pageSize);
            map.put("pageTotal", pageTotal);
            map.put("dataTotal", dataTotal);
            map.put("list", redisData);
            map.put("isFirstPage", isFirstPage);
            map.put("isLastPage", isLastPage);
            map.put("hasNextPage", hasNextPage);
            map.put("hasPrepage", hasPrePage);
            map.put("firstPage", firstPage);
            map.put("lastPage", lastPage);
            return map;
        }
        //如果总的数据数量 >当前的每页记录
        else if (dataTotal > this.pageSize) {
            if (dataTotal % pageSize != 0) {
                pageTotal = dataTotal / this.pageSize + 1; //总页数 = 总的数据数量/每页记录 + 1
            } else {
                pageTotal = dataTotal / this.pageSize;
            }
            //如果是第一页
            if (pageNum <= 1) {
                pageNum = 1;
                isFirstPage = true;
                isLastPage = false;
                hasNextPage = true;
                hasPrePage = false;
                firstPage = 1;
                lastPage = pageTotal.intValue();
                redisData = json.parseArray(jedisTemplate.zrange(key, 0, pageSize - 1).toString(), tClass);
            }
            //如果是最后一页
            else if (pageNum >= pageTotal) {
                pageNum = pageTotal.intValue();
                isFirstPage = false;
                isLastPage = true;
                hasNextPage = false;
                hasPrePage = true;
                firstPage = 1;
                lastPage = pageTotal.intValue();
                if (dataTotal % pageSize != 0) {
                    Long result = dataTotal % pageSize;
                    redisData = json.parseArray(jedisTemplate.zrange(key, (pageNum - 1) * pageSize, ((pageNum - 1) * pageSize) + result - 1).toString(), tClass);
                } else {
                    redisData = json.parseArray(jedisTemplate.zrange(key, (pageNum - 1) * pageSize, pageNum * pageSize - 1).toString(), tClass);

                }
            }
            //第二页到最后一页之前
            else {
                isFirstPage = false;
                isLastPage = false;
                hasNextPage = true;
                hasPrePage = true;
                firstPage = 1;
                lastPage = pageTotal.intValue();
                redisData = json.parseArray(jedisTemplate.zrange(key, (pageNum - 1) * pageSize, pageNum * pageSize - 1).toString(), tClass);
            }

            map.put("pageNum", pageNum);
            map.put("pageSize", pageSize);
            map.put("pageTotal", pageTotal);
            map.put("dataTotal", dataTotal);
            map.put("list", redisData);
            map.put("isFirstPage", isFirstPage);
            map.put("isLastPage", isLastPage);
            map.put("hasNextPage", hasNextPage);
            map.put("hasPrepage", hasPrePage);
            map.put("firstPage", firstPage);
            map.put("lastPage", lastPage);
            return map;
        }
        return map;
    }
}
