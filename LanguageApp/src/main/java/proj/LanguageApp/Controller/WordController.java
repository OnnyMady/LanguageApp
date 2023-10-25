package proj.LanguageApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import proj.LanguageApp.DTO.SentenceDTO;
import proj.LanguageApp.DTO.TranslationDTO;
import proj.LanguageApp.DTO.WordDTO;
import proj.LanguageApp.Service.FileService;
import proj.LanguageApp.Service.TranslationService;
import proj.LanguageApp.Service.WordService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/words")
public class WordController {

    private static final Logger logger = LoggerFactory.getLogger(WordController.class);

    @Autowired
    private WordService wordService;

    @Autowired
    private FileService fileService;

    @Autowired
    private TranslationService translationService;

    @GetMapping("all")
    public ResponseEntity<List<WordDTO>> getAllWords() {
        List<WordDTO> wordList = new ArrayList<>();
        try {
            wordList = wordService.getWords();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(wordList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteWord(@PathVariable("id") Long id) {
        try {

            WordDTO word = wordService.findWord(id);
            if(word.getTranslationDTOList() != null){
                for(TranslationDTO translationDTO: word.getTranslationDTOList()){
                    if(translationDTO.getSentenceDTOList() != null){
                        for(SentenceDTO sentenceDTO: translationDTO.getSentenceDTOList()){
                            translationService.deleteSentence(sentenceDTO.getId());
                        }
                    }
                    translationService.delete(translationDTO.getId());
                }
            }
            if(word.getSoundName() != null){
                fileService.deleteFile(word.getSoundName());
            }
            if(word.getPictureName() != null){
                fileService.deleteFile(word.getPictureName());
            }
            wordService.deleteWord(id);

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "edit")
    public ResponseEntity<WordDTO> editWord(@RequestPart("word") String name,
                                            @RequestPart("id") String id,
                                            @RequestPart("category") String category,
                                            @RequestPart(value = "fileSound", required = false) MultipartFile[] fileSound,
                                            @RequestPart(value = "filePicture", required = false) MultipartFile[] filePicture) {
        WordDTO response = null;

        try {

            WordDTO word = wordService.findWord(id);
            response = wordService.editWord(word, category, name);

            if (fileSound != null) {
                String extensionFileSound = fileService.getExtension(fileSound[0].getOriginalFilename());
                String fileName = id + extensionFileSound;

                if (word.getSoundName() != null) {
                    fileService.deleteFile(word.getSoundName());
                }
                fileService.uploadFile(fileSound[0], fileName);
                fileService.loadFileAsResource(fileName);
                response = wordService.updateFileSoundName(Math.toIntExact(response.getId()), extensionFileSound);
            }

            if (filePicture != null) {
                String extensionFilePicture = fileService.getExtension(filePicture[0].getOriginalFilename());
                String fileName = id + extensionFilePicture;

                if (word.getPictureName() != null) {
                    fileService.deleteFile(word.getPictureName());
                }
                fileService.uploadFile(filePicture[0], fileName);
                fileService.loadFileAsResource(fileName);
                response = wordService.updateFilePictureName(Math.toIntExact(response.getId()), extensionFilePicture);

            }


        } catch (Exception e) {
            System.out.println("Something went wrong.");
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<WordDTO> addWord(@RequestPart("name") String name,
                                           @RequestPart("category") String category,
                                           @RequestPart(value = "fileSound", required = false) MultipartFile[] fileSound,
                                           @RequestPart(value = "filePicture", required = false) MultipartFile[] filePicture) {

        WordDTO response = null;

        try {
            WordDTO wordDTO = new WordDTO(name, category);
            response = wordService.addWord(wordDTO);

            if (fileSound != null) {
                String extensionFileSound = fileService.getExtension(fileSound[0].getOriginalFilename());
                response = wordService.updateFileSoundName(Math.toIntExact(response.getId()), extensionFileSound);
                String fileName = response.getId() + extensionFileSound;
                fileService.uploadFile(fileSound[0], fileName);
                fileService.loadFileAsResource(fileName);
            }
            if (filePicture != null) {
                String extensionFilePicture = fileService.getExtension(filePicture[0].getOriginalFilename());
                response = wordService.updateFilePictureName(Math.toIntExact(response.getId()), extensionFilePicture);
                String pictureName = response.getId() + extensionFilePicture;
                fileService.uploadFile(filePicture[0], pictureName);
                fileService.loadFileAsResource(pictureName);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
