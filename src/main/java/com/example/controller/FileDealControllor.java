package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author WangRui
 */
@Controller
@RequestMapping("/file")
public class FileDealControllor {

    @RequestMapping("/singlefile")
    public String getSingleFile() {
            return "file";
    }

    @RequestMapping("/multifile")
    public String getMultifile() {
        return "multifile";
    }

    /**
     * 实现文件上传
     * */
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        String savePath = "F:/TestFileDeal";
        File dest = new File(savePath+"/Single/"+fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存文件
            file.transferTo(dest);
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 实现多文件上传
     * */
    @RequestMapping("multifileUpload")
    @ResponseBody
    public String multiFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("fileName");
        if (files.isEmpty()) {
            return "false";
        }
        String savePath = "F:/TestFileDeal";
        for (MultipartFile file : files
             ) {
            String fileName = file.getOriginalFilename();
            File saveFile = new File(savePath+"/Multifile/"+fileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.mkdirs();
            }
            try {
                // 保存文件
                file.transferTo(saveFile);
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "false";
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "false";
            }
        }
        return "true";
    }

    @RequestMapping("/fileDownload")
    public void fileDownLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String fileName = "表结构_标化工地(2)(1).xlsx";
        File file = new File("F:/TestFileDeal/Single/"+fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName="+new String(fileName.getBytes("GBK"), "ISO8859-1" ));
            byte[] bytes = new byte[1024];
            // 输入流
            FileInputStream fi = null;
            BufferedInputStream bi = null;

            // 输出流
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                fi = new FileInputStream(file);
                bi = new BufferedInputStream(fi);
                int i = bi.read(bytes);
                while (i != -1) {
                    os.write(bytes);
                    i = bi.read(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } finally {
                try {
                    fi.close();
                    bi.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
