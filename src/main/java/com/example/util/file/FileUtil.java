package com.example.util.file;

import com.example.constant.Constant;
import com.example.util.properties.StaticProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @ClassName: FileUtil
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 9:55
 */
@Component
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger("tools");

    /**
     * 获取可预览的URL
     *
     * @param filePath 文件路径
     * @return 可预览的文件路径
     * @Description: 获取完整的URL
     */
    public static String getFullUrl(String filePath) {

        return StaticProperties.remoteUploadPath + filePath;
    }

    /**
     * 获取文件真实路径
     *
     * @param filePath 文件路径
     * @return 真实的文件路径
     * @Description: 获取文件真实路径
     */
    public static String getActualUrl(String filePath) {

        if (filePath.contains(StaticProperties.rootPath)) {
            return filePath;
        }

        return StaticProperties.rootPath + filePath;
    }

    /**
     * 删除文件
     *
     * @param path 文件路径
     * @throws IOException
     */
    public static void deleteFile(String path) {
        String filePath = getActualUrl(path.replace("\\", "/"));

        //删除源文件
        deleteFile(new File(filePath));

    }

    /**
     * 删除文件
     * @param file
     */
    public static void deleteFile(File file) {
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    /**
     * 文件按照创建时间排序
     *
     * @param path 文件目录
     * @return 排序后的文件列表
     */
    public static List<File> getFileSort(String path) {

        List<File> list = getFiles(path, new ArrayList<File>());

        if (list.size() > 0) {
            list.sort(Comparator.comparingLong(File::lastModified));
        }

        return list;
    }

    /**
     * 获取文件下的所有文件
     *
     * @param realpath 文件夹地址
     * @param files    文件集合
     * @return 新的文件集合
     */
    public static List<File> getFiles(String realpath, List<File> files) {

        File realFile = new File(realpath);

        //文件下读取文件
        if (realFile.isDirectory()) {

            File[] subFiles = realFile.listFiles();

            assert subFiles != null;
            for (File file : subFiles) {
                if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath(), files);
                } else {
                    files.add(file);
                }
            }
        }

        return files;
    }
}
