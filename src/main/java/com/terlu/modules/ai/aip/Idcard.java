package com.terlu.modules.ai.aip;
import java.net.URLEncoder;

import com.terlu.modules.ai.aip.auth.AuthService;
import com.terlu.modules.ai.aip.utils.Base64Util;
import com.terlu.modules.ai.aip.utils.FileUtil;
import com.terlu.modules.ai.aip.utils.HttpUtil;
import com.terlu.modules.entity.TlDriverZj;
/**
* 身份证识别
*/
public class Idcard {
    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String idcard() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        try {
            // 本地文件路径
            String filePath = "d:/222.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "id_card_side=" + "front" + "&image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken = "UaGq0GWBaDOOPxvoyh39beek";
            AuthService auth = new AuthService();
            String accessToken = auth.getAuth("UaGq0GWBaDOOPxvoyh39beek","FbQOckuUCGkT2ysWNBG7qFB9XzxFLqpf");
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Idcard.idcard();
    }

}

