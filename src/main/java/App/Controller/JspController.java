package App.Controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@Slf4j
public class JspController {
    //转向Suuu页面
    @RequestMapping("/login")
    public String aaa(String name,String age){
        System.out.println("Turn to Suuu.jsp");
        return "login";
    }

    //全局错误测试
    @RequestMapping("/errortest")
    public String bbb(){
        int i;
        i=5/0;
        return "Suuu";
    }

    @PostMapping("/file/upload")
    public String upload(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "/static/img";
        File dest = new File(path + "/" + fileName);
        try {
            file.transferTo(dest); //保存文件
            return path + "/"+ fileName;
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
}
