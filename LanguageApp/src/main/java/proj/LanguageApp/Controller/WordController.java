package proj.LanguageApp.Controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import proj.LanguageApp.DTO.WordDTO;
import proj.LanguageApp.Service.FileService;
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

    @GetMapping("all")
    public ResponseEntity<List<WordDTO>> getAllWords(){
        List<WordDTO> wordList = new ArrayList<>();
        try{
            wordList= wordService.getWords();
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(wordList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteWord(@PathVariable("id") Long id){
        try{
            wordService.deleteWord(id);

        } catch (Exception e){
            System.out.println("Something went wrong.");
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "edit")
    public ResponseEntity<WordDTO> editWord(@RequestPart("word") String name,
                                            @RequestPart("id") String id,
                                            @RequestPart("category") String category,
                                            @RequestPart("sentence") String sentence,
                                            @RequestPart( "lesson" ) String lesson,
                                            @RequestPart("translation") String translation,
                                            @RequestPart(value = "fileSound", required = false) MultipartFile[] fileSound,
                                            @RequestPart(value = "filePicture", required = false) MultipartFile[] filePicture)
    {
        WordDTO response = null;
        try {
            String extensionFileSound = fileService.getExtension(fileSound[0].getOriginalFilename());

            WordDTO wordDTO = new WordDTO(name, category, sentence, translation,lesson);
            fileService.deleteFile(wordDTO.getId() + extensionFileSound);

            String fileName = StringUtils.cleanPath(fileSound[0].getOriginalFilename());
            fileService.uploadFile(fileSound[0], fileName);
            fileService.loadFileAsResource(fileName);

            response= wordService.editWord(wordDTO, extensionFileSound, id);

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<WordDTO> addWord(@RequestPart("name") String name,
                                           @RequestPart("category") String category,
                                           @RequestPart("sentence") String sentence,
                                           @RequestPart("lesson") String lesson,
                                           @RequestPart("translation") String translation,
                                           @RequestPart(value = "fileSound", required = false) MultipartFile[] fileSound,
                                           @RequestPart(value = "filePicture", required = false) MultipartFile[] filePicture) {

        WordDTO response = null;

        try {
            String extensionFileSound = fileService.getExtension(fileSound[0].getOriginalFilename());
            String extensionFilePicture = fileService.getExtension(filePicture[0].getOriginalFilename());

            WordDTO wordDTO = new WordDTO(name, category, sentence, translation, lesson);
            response = wordService.addWord(wordDTO);
            response = wordService.updateFileName(response, extensionFileSound);
            response = wordService.updateFilePictureName(response, extensionFilePicture);

            String fileName = response.getId() + extensionFileSound;
            String pictureName = response.getId() + extensionFilePicture;

            fileService.uploadFile(fileSound[0], fileName);
            fileService.loadFileAsResource(fileName);
            fileService.uploadFile(filePicture[0], pictureName);
            fileService.loadFileAsResource(pictureName);

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
