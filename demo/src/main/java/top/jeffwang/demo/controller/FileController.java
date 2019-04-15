package top.jeffwang.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.jeffwang.demo.domain.JsonData;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {

    @RequestMapping(value = "api/v1/gopage")
    public Object index(){
        return "index";
    }

    @Value("${web.file.path}")
    private String filePath;

    @RequestMapping(value = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img")MultipartFile file, HttpServletRequest request){

        System.out.println("配置注入打印， 文件路径为："+filePath);

        String name = request.getParameter("name");
        System.out.println("用户名："+name);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为："+fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为："+suffixName);

        // 文件上传后的路径
        fileName = UUID.randomUUID()+suffixName;
        System.out.println("转化后的文件名:"+fileName);
        File dest = new File(filePath+fileName);

        try{
            file.transferTo(dest);
            return new JsonData(0, fileName);
        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return new JsonData(-1, "fail to save file");
    }
}
