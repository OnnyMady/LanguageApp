package proj.LanguageApp.Controller;

import ch.qos.logback.core.model.Model;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.LanguageApp.DTO.WordDTO;
import proj.LanguageApp.Entity.Word;
import proj.LanguageApp.Repository.WordRepository;
import proj.LanguageApp.Service.WordService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/words")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("all")
    public ResponseEntity<List<WordDTO>> getAllWords(){
        List<WordDTO> wordList= wordService.getWords();
        return new ResponseEntity<>(wordList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteWord(@PathVariable("id") Long id){
        wordService.deleteWord(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("edit")
    public ResponseEntity<WordDTO> editWord(@RequestBody WordDTO wordDTO){
        WordDTO response= wordService.editWord(wordDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<WordDTO> addWord(@RequestBody WordDTO wordDTO){
        WordDTO response = wordService.addWord(wordDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
