//package tn.esprit.formation.Service;

//import org.springframework.stereotype.Service;
//import tn.esprit.formation.Repository.StoredFileRepository;
//import tn.esprit.formation.entity.StoredFile;
//
//import java.util.Base64;
//
//@Service
//public class FileStorageService {
//    @Autowired
//    private StoredFileRepository fileRepository;
//
//
//    public void storeFile(String fileName, String fileType, byte[] content) {
//        StoredFile file = new StoredFile();
//        file.setFileName(fileName);
//        file.setFileType(fileType);
//        file.setContent(content);
//        fileRepository.save(file);
//    }
//
//    public byte[] decodeBase64(String base64Data) {
//        return Base64.getDecoder().decode(base64Data);
//    }
//}
//
//