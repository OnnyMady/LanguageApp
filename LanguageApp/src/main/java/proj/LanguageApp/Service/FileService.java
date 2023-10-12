package proj.LanguageApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

@Service
public class FileService {

    @Autowired
    private Environment env;

    public void deleteFile(String fileName) throws Exception {

        Path fileStorageLocation = Paths.get((env.getProperty("file.upload-dir"))).toAbsolutePath().normalize();
        Path targetLocation = fileStorageLocation.resolve(fileName);
        Files.delete(targetLocation);

    }

    public void uploadFile(MultipartFile file, String fileName) throws Exception {

            Path fileStorageLocation;

            if(fileName.contains(".mp3") || fileName.contains(".wav")){
                fileStorageLocation = Paths.get((env.getProperty("file.upload-dir-sound"))).toAbsolutePath().normalize();
            } else {
                fileStorageLocation = Paths.get((env.getProperty("file.upload-dir-picture"))).toAbsolutePath().normalize();
            }

            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);

    }

    public Resource loadFileAsResource(String fileName) throws MalformedURLException {

        Path fileStorageLocation;

        if(fileName.contains(".mp3") || fileName.contains(".wav")){
            fileStorageLocation = Paths.get((env.getProperty("file.upload-dir-sound"))).toAbsolutePath().normalize();
        } else {
            fileStorageLocation = Paths.get((env.getProperty("file.upload-dir-picture"))).toAbsolutePath().normalize();
        }

        Path filePath = fileStorageLocation.resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists()) {
            return resource;
        }
        return null;
    }

    public String getExtension(String name) throws Exception{
        int index = name.indexOf('.');
        return name.substring(index);

    }
}
