package com.yemu.malladmin.controller;

import com.yemu.malladmin.common.QiNiuUtil;
import com.yemu.malladmin.common.Response;
import com.yemu.malladmin.service.ImgService;
import com.yemu.malladmin.entity.Img;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @Resource
    ImgService imgService;
    @PostMapping("/uploadImg")
    public Response uploadImg(@RequestParam MultipartFile img, HttpServletResponse response){
        if (img.isEmpty()){
            response.setStatus(400);//设置响应错误码
            return Response.error("文件为空");
        }
        Map<String,String> fileTypeMap = new HashMap<>();
        fileTypeMap.put("image/png",".png");
        fileTypeMap.put("image/jpeg",".jpg");
        String fileType = img.getContentType();
        boolean isImg=fileTypeMap.containsKey(fileType);//判断是否为图片
        if (!isImg){
            response.setStatus(400);//设置响应错误码
            return Response.error("只支持jpg、png格式");
        }
        try{
            FileInputStream inputStream= (FileInputStream) img.getInputStream();
            String suffix=fileTypeMap.get(fileType);
            String url=QiNiuUtil.upload(inputStream,suffix);
            if (null==url||url.isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                return Response.error("上传失败");
            }
            Img newimg=new Img();
            newimg.setUrl(url);
            newimg.setName(img.getOriginalFilename());
            imgService.getBaseMapper().insert(newimg);
            return Response.ok("成功","img",newimg);
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
            return Response.error(e.getMessage()) ;
        }
    }
}
