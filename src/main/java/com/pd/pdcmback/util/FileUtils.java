package com.pd.pdcmback.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author pengdong
 * @date 2020/2/24 11:25
 * @function
 * @describe
 */
public class FileUtils {

    public static void getFile(byte[] bfile, String fileName) {    //创建文件
        File file=new File(fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void responseTo(File file, HttpServletResponse res) {  //将文件发送到前端
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }



    /**
     * 判断指定的文件或文件夹删除是否成功
     * @param FileName 文件或文件夹的路径
     * @return true or false 成功返回true，失败返回false
     */
    public static boolean deleteAnyone(String FileName){

        File file = new File(FileName);//根据指定的文件名创建File对象


        if ( !file.exists() ){  //要删除的文件不存在
            System.out.println("文件"+FileName+"不存在，删除失败！" );
            return false;
        }else{ //要删除的文件存在

            if ( file.isFile() ){ //如果目标文件是文件

                return deleteFile(FileName);

            }else{  //如果目标文件是目录
                return deleteDir(FileName);
            }
        }
    }

    /**
     * 判断指定的文件删除是否成功
     * @param fileName 文件路径
     * @return true or false 成功返回true，失败返回false
     */
    public static boolean deleteFile(String fileName){

        File file = new File(fileName);//根据指定的文件名创建File对象

        if (  file.exists() && file.isFile() ){ //要删除的文件存在且是文件

            if ( file.delete()){
                System.out.println("文件"+fileName+"删除成功！");
                return true;
            }else{
                System.out.println("文件"+fileName+"删除失败！");
                return false;
            }
        }else{

            System.out.println("文件"+fileName+"不存在，删除失败！" );
            return false;
        }


    }


    /**
     * 删除指定的目录以及目录下的所有子文件
     * @param dirName is 目录路径
     * @return true or false 成功返回true，失败返回false
     */
    public static boolean deleteDir(String dirName){

        if ( dirName.endsWith(File.separator) )//dirName不以分隔符结尾则自动添加分隔符
            dirName = dirName + File.separator;

        File file = new File(dirName);//根据指定的文件名创建File对象

        if ( !file.exists() || ( !file.isDirectory() ) ){ //目录不存在或者
            System.out.println("目录删除失败"+dirName+"目录不存在！" );
            return false;
        }

        File[] fileArrays = file.listFiles();//列出源文件下所有文件，包括子目录

        for ( int i = 0 ; i < fileArrays.length ; i++ ){//将源文件下的所有文件逐个删除

            deleteAnyone(fileArrays[i].getAbsolutePath());

        }

        if ( file.delete() )//删除当前目录
            System.out.println("目录"+dirName+"删除成功！" );

        return true;
    }
}
