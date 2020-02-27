package com.yemu.malladmin.common;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.FileInputStream;
import java.util.UUID;

/*
 上传文件到七牛云工具
  */
public class QiNiuUtil {
    //AK
    private static final String ACCESS_KEY = "YysdaBadxSVx5PIKAT-8YzbMQPidS7ax-B_D7B9F";
    //SK
    private static final String SECRET_KEY = "ck4mwTFK0hAXLrvC4IWFJcd_1B4ZfJ4Ms4DUJMSp";
    //空间名
    private static final String BUCKET = "yemumall";
    //密钥
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //图片上传路径
    private static final String DOMAIN = "http://img.yemuc.xyz";

    //获取上传凭证
    public static String getUpToken(){
        StringMap putPolicy = new StringMap();//定义返回参数
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        return auth.uploadToken(BUCKET,null,3600,putPolicy);
    }

    //流式上传
    public static String upload(FileInputStream file, String suffix){
        Configuration cfg=new Configuration(Region.region0());
        UploadManager uploadManager = new UploadManager(cfg);
        try{
            String token = getUpToken();
            //检查是否获取到token
            if (token.isEmpty()){
                return null;
            }
            String name=getUUID()+suffix;
            Response res = uploadManager.put(file,name,token,null,null);
            if (res.isOK()){
                Img img = res.jsonToObject(Img.class);
                return DOMAIN+"/"+img.key;
            }


        }
        catch (QiniuException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }
    //获取uuid
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-","");
        return str;
    }
    class Img {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
    }
}
