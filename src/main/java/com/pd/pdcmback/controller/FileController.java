package com.pd.pdcmback.controller;

import com.pd.pdcmback.exception.AjaxResponse;
import com.pd.pdcmback.service.ComponentService;
import com.pd.pdcmback.util.FileUtils;
import com.pd.pdcmback.util.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author pengdong
 * @date 2020/2/23 21:51
 * @function
 * @describe
 */
@CrossOrigin(origins = "http://127.0.0.1:8088",allowCredentials = "true")
@RestController
public class FileController {

    @Value("${component.pictureUrl}")
    private String pictureUrl;

    @Autowired
    private ComponentService componentService;

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/import")
    public AjaxResponse importData(MultipartFile file, HttpServletRequest req, String componentId) throws IOException {
        System.out.println("upload ing ing");
        String format = sdf.format(new Date());
        //String realPath = req.getServletContext().getRealPath("/upload") + format;
        //改为tomcat下的地址
        String realPath = "D:\\SoftWare\\Tomcat\\tomcat8.5\\apache-tomcat-8.5.49\\webapps\\uploadComponents" + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        System.out.println("oldName"+oldName);
        String uuidFilename = UUID.randomUUID().toString();
        String newName = uuidFilename + oldName.substring(oldName.lastIndexOf("."));
        file.transferTo(new File(folder,newName));
        //以下.getScheme()获取协议名称如:http、https;.getServerName()获取请求网站的域名；.getSerberPort()获取请求网站的端口
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload" + format + newName;
        System.out.println(url);
        String serverPictureUrl = pictureUrl + format + newName;
        Map map = new HashMap();
        map.put("componentUuid",uuidFilename);
        map.put("pictureUrl",serverPictureUrl);
        map.put("componentId",componentId);
        if(oldName.substring(oldName.lastIndexOf(".")).equals(".zip")){
            String componentExhibitionAddress = pictureUrl + format +uuidFilename;
            String componentDownloadAddress = realPath + newName;
            map.put("componentExhibitionAddress",componentExhibitionAddress);
            map.put("componentDownloadAddress",componentDownloadAddress);
            //zip文件解压
            ZipUtil.unZip(realPath + "\\" + newName, realPath, uuidFilename);
            componentService.insertComponentExhibitionAndDownloadAddress(map);
            return AjaxResponse.uploadCompomentFileSuccess();
        }
        componentService.insertComponentPictureAndUuid(map);
        return AjaxResponse.uploadComponentPictureSuccess(map);
    }



    @RequestMapping(value = "/downloadComponent", method = RequestMethod.GET)
    public String downloadData(@RequestParam("componentDownloadAddress") String componentDownloadAddress, HttpServletResponse res) {
        String data="这是一个下载文件";   //传入数据
        //File file=new File("文件.txt");
        System.out.println("componentDownloadAddress= "+ componentDownloadAddress);
        //File file=new File("D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\组件压缩文件\\jQuery鼠标移入方向感知.zip");
        File file=new File(componentDownloadAddress);
        //File file=new File("D:\\Document\\学生征途\\作业任务\\毕设\\组件示例下载\\css3hover");
        //FileUtils.getFile(data.getBytes(),file.getName());
        FileUtils.responseTo(file,res);
        //file.delete();
        System.out.println("success");
        return "success";
    }


}
