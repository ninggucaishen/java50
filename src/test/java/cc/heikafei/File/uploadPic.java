package cc.heikafei.File;

import cn.hutool.core.date.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName uploadPic
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/22 9:19
 * @Version 1.0
 */
public class uploadPic {

    /*public static String uploadFile(MultipartFile file) {

        String filePath = System.getProperty("user.dir") + File.separator + "upload";

        String fileName = file.getOriginalFilename();

        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        fileName = UUID.randomUUID() + suffixName;

        File fileDir = new File(filePath);

        if (!fileDir.exists()) {
            fileDir.mkdir();
        }

        File dest = new File(fileDir.getAbsoluteFile() + File.separator + fileName);

        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileName = "/upload/" + fileName;

        return fileName;
    }*/

    public String add(MultipartFile file) throws IOException {
        String path = null;// 文件路径

        if (file != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:" + fileName);

            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空

                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                    String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    fileName = uuid + "."+type;
                    System.out.println("文件名称："+fileName);

                    // 添加日期
                    String datePath = new DateTime().toString("yyyy/MM/dd");
                    path = "D:/Upload/"+datePath+"/";
                    File f = new File(path);
                    if (!f.exists()){
                        f.mkdirs();
                    }

                    String pathName = path + fileName;
                    System.out.println("存放图片文件的路径:" + pathName);

                    // 转存文件到指定的路径
                    file.transferTo(new File(pathName));

                    System.out.println("文件成功上传到指定目录下");
                    return datePath + "/" + fileName + "." + type;
                }

            } else {
                return "不是我们想要的文件类型,请按要求重新上传";
            }
        } else {
            return "文件类型为空";
        }
        return "已经成功上传到指定目录";

    }
}
