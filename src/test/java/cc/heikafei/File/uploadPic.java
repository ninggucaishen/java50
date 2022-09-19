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
        String path = null;// �ļ�·��

        if (file != null) {// �ж��ϴ����ļ��Ƿ�Ϊ��
            String type = null;// �ļ�����
            String fileName = file.getOriginalFilename();// �ļ�ԭ����
            System.out.println("�ϴ����ļ�ԭ����:" + fileName);

            // �ж��ļ�����
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// �ж��ļ������Ƿ�Ϊ��

                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                    String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    fileName = uuid + "."+type;
                    System.out.println("�ļ����ƣ�"+fileName);

                    // �������
                    String datePath = new DateTime().toString("yyyy/MM/dd");
                    path = "D:/Upload/"+datePath+"/";
                    File f = new File(path);
                    if (!f.exists()){
                        f.mkdirs();
                    }

                    String pathName = path + fileName;
                    System.out.println("���ͼƬ�ļ���·��:" + pathName);

                    // ת���ļ���ָ����·��
                    file.transferTo(new File(pathName));

                    System.out.println("�ļ��ɹ��ϴ���ָ��Ŀ¼��");
                    return datePath + "/" + fileName + "." + type;
                }

            } else {
                return "����������Ҫ���ļ�����,�밴Ҫ�������ϴ�";
            }
        } else {
            return "�ļ�����Ϊ��";
        }
        return "�Ѿ��ɹ��ϴ���ָ��Ŀ¼";

    }
}
