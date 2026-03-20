package vn.hoidanit.laptopshop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {

    private final ServletContext servletContext;

    public UploadService(ServletContext servletContext) {

        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        //validate
        if (file.isEmpty()) {
            return "";
        }

        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        try {
            byte[] bytes = file.getBytes();

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalName;
    }

    public String handleUpdateFile(MultipartFile file, String targetFolder, String nameAvatarOld) {
        // Xóa file cũ nếu tồn tại
        if (nameAvatarOld != null && !nameAvatarOld.isEmpty()) {// check name khác null or khác rỗng
            String rootPath = this.servletContext.getRealPath("/resources/images");
            String oldFilePath = rootPath + File.separator + targetFolder + File.separator + nameAvatarOld;
            File oldFile = new File(oldFilePath);
            if (oldFile.exists()) {//nếu đường dẫn này tồn tại file thì xóa
                oldFile.delete();
            }
        }

        // Upload file mới
        String finalName = this.handleSaveUploadFile(file, targetFolder);
        return finalName;
    }

}
