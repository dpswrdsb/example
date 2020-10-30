package com.example.core.controller;

import com.example.util.file.FileUtil;
import com.example.util.properties.MyProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName: FileController
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:51
 */
@RestController
@RequestMapping("/download")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    MyProperties myProperties;


    /**
     * 临时文件下载
     */
    @GetMapping(path = "/temp/fileDownload/{fileName:.+}")
    public void fileDownLoad(@PathVariable String fileName, HttpServletResponse response) {

        String filePath = myProperties.getPathsProperties().getTempPath();
        filePath = filePath.concat(File.separator).concat(fileName);
        try {
            download(response, filePath);
            FileUtil.deleteFile(filePath);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 永久文件下载
     */
    @GetMapping(path = "/permanent/fileDownload/{fileName:.+}")
    public void permanentFileDownLoad(@PathVariable String fileName, HttpServletResponse response) {

        try {
            fileName = URLDecoder.decode(fileName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        //去除文件名中包含的"../"字符串信息
        fileName = StringUtils.replace(fileName, "../", "");

        String filePath =  myProperties.getPathsProperties().getPermanentPath();
        filePath = filePath.concat(File.separator).concat(fileName);
        //File file = new File(filePath);
        try {
            // path是指欲下载的文件的路径。
            download(response, filePath);
        } catch (IOException e) {
            logger.error("文件下载失败", e);
        }
    }

    /**
     * 文件下载。流的方式
     * @param response HttpServletResponse
     * @param filePath 路径
     * @throws IOException IO异常
     */
    private void download(HttpServletResponse response, String filePath) throws IOException {
        // path是指欲下载的文件的路径。
        File file = new File(filePath);
        if (!file.exists()) {
            logger.error("文件不存在");
        } else {
            // 取得文件名。
            String filename = file.getName();

            //以流的形式下载文件
            InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }
    }
}
