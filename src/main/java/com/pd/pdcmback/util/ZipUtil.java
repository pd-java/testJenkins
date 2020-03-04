package com.pd.pdcmback.util;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author pengdong
 * @date 2020/2/24 9:17
 * @function
 * @describe
 */
public class ZipUtil {

    static Log log = LogFactory.getLog(ZipUtil.class);

    public static void unZip(String sourceFilename, String targetDir, String uuidFilename) throws IOException {
        unZip(new File(sourceFilename), targetDir, uuidFilename);
    }

    /**
     * 将sourceFile解压到targetDir
     * @param sourceFile
     * @param targetDir
     * @throws RuntimeException
     */
    public static void unZip(File sourceFile, String targetDir, String uuidFilename) throws IOException {
        long start = System.currentTimeMillis();
        if (!sourceFile.exists()) {
            throw new FileNotFoundException("cannot find the file = " + sourceFile.getPath());
        }
        ZipFile zipFile = null;
        try{
            //zipFile = new ZipFile(sourceFile);
            zipFile = new ZipFile(sourceFile, Charset.forName("GBK"));
            Enumeration<?> entries = zipFile.entries();
            int fileDepth = -1;
            String fileDirectoryname = "";
            while (entries.hasMoreElements()) {
                ++fileDepth;
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (entry.isDirectory()) {
                    String dirPath = targetDir + "/" + entry.getName();
                    if(fileDepth == 0){
                        fileDirectoryname = dirPath;
                    }
                    createDirIfNotExist(dirPath);
                } else {
                    File targetFile = new File(targetDir + "/" + entry.getName());
                    createFileIfNotExist(targetFile);
                    InputStream is = null;
                    FileOutputStream fos = null;
                    try {
                        is = zipFile.getInputStream(entry);
                        fos = new FileOutputStream(targetFile);
                        int len;
                        byte[] buf = new byte[1024];
                        while ((len = is.read(buf)) != -1) {
                            fos.write(buf, 0, len);
                        }
                    }finally {
                        try{
                            fos.close();
                        }catch (Exception e){
                            log.warn("close FileOutputStream exception", e);
                        }
                        try{
                            is.close();
                        }catch (Exception e){
                            log.warn("close InputStream exception", e);
                        }
                    }
                }
            }
            FixFileName(fileDirectoryname,uuidFilename);
            log.info("解压完成，耗时：" + (System.currentTimeMillis() - start) +" ms");
        } finally {
            if(zipFile != null){
                try {
                    zipFile.close();
                } catch (IOException e) {
                    log.warn("close zipFile exception", e);
                }
            }
        }
    }

    public static void createDirIfNotExist(String path){
        File file = new File(path);
        createDirIfNotExist(file);
    }

    public static void createDirIfNotExist(File file){
        if(!file.exists()){
            file.mkdirs();
        }
    }

    public static void createFileIfNotExist(File file) throws IOException {
        createParentDirIfNotExist(file);
        file.createNewFile();
    }

//    public static void createParentDirIfNotExist(String filename){
//        File file = new File(filename);
//        createParentDirIfNotExist(file);
//    }

    public static void createParentDirIfNotExist(File file){
        createDirIfNotExist(file.getParentFile());
    }


    /**
     * 通过文件路径直接修改文件名
     *
     * @param filePath    需要修改的文件的完整路径
     * @param newFileName 需要修改的文件的名称
     * @return
     */
    public static String FixFileName(String filePath, String newFileName) {
        File f = new File(filePath);
        if (!f.exists()) { // 判断原文件是否存在（防止文件名冲突）
            return null;
        }
        newFileName = newFileName.trim();
        if ("".equals(newFileName) || newFileName == null) // 文件名不能为空
            return null;
        String newFilePath = null;
        if (f.isDirectory()) { // 判断是否为文件夹
            filePath = filePath.substring(0, filePath.lastIndexOf("/"));
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName;
        } else {
            newFilePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/" + newFileName
                    + filePath.substring(filePath.lastIndexOf("."));
        }
        File nf = new File(newFilePath);
        try {
            f.renameTo(nf); // 修改文件名
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }
        return newFilePath;
    }
}
