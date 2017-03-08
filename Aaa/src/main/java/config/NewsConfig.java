package config;

/**
 * Created by xcdq on 2017/3/8.
 */

public class NewsConfig {
    public static String getUrl(String type){
        return "http://v.juhe.cn/toutiao/index?type="+type+
        "&key=7066afea2bde94d7edfcefda25966b3b";
    }
}
