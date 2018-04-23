/**
 * @ProjectName b2b-data-web
 * @FileName Snippet.java
 * @PackageName com.xe.b2b.data.web.common
 * @Date 2017年1月12日下午11:44:34
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.web.common;

import com.xe.b2b.data.business.service.conf.AppConfigHolder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UploadUtils
 * @Description TODO
 * @Date 2017年1月12日 下午11:44:34
 * @author towen
 * @version v1.0
 */

public class UploadUtils {
    private static final Logger logger = LogManager.getLogger(UploadUtils.class);
    public static String imageHandle(MultipartFile myfile, String realPath) {
        // 处理上传图片
        String imgPath = "";
        if (myfile.isEmpty()) {
            logger.error("文件未上传");
        } else {
            // 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
            try {
                // 重置文件名
                long time = System.currentTimeMillis();
                String timeStr = String.valueOf(time);
                String[] originalFileName = myfile.getOriginalFilename().split("\\.");
                String fileName = timeStr + "." + originalFileName[1];
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, fileName));
                // 配置图片访问路径
                String ip = AppConfigHolder.appConfig.getUploadUrl();
                imgPath = ip + "/" + fileName;
                logger.info(imgPath);
            } catch (IOException e) {
                logger.error(e.getMessage());
                return null;
            }
        }

        return imgPath;
    }

    /**
     * 处理图片
     * 
     * @param myfiles
     * @return
     */
    public static List<String> imageHandle(MultipartFile[] myfiles, String realPath) {
        // 处理上传图片
        List<String> imgPathList = new ArrayList<String>();
        for (MultipartFile myfile : myfiles) {
            String result = imageHandle(myfile, realPath);
            if (StringUtils.isNotBlank(result)) {
                imgPathList.add(result);
            }
        }

        return imgPathList;
    }
}
