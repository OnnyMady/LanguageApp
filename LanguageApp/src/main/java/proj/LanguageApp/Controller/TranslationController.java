package proj.LanguageApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.LanguageApp.DTO.SentenceDTO;
import proj.LanguageApp.DTO.TranslationDTO;
import proj.LanguageApp.DTO.WordDTO;
import proj.LanguageApp.Entity.Sentence;
import proj.LanguageApp.Entity.Translation;
import proj.LanguageApp.Service.TranslationService;
import proj.LanguageApp.Service.WordService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/translation")
public class TranslationController {

    private static final Logger logger = LoggerFactory.getLogger(TranslationController.class);

    @Autowired
    private TranslationService translationService;

    @Autowired
    private WordService wordService;

    @PostMapping(value = "addTranslation")
    public ResponseEntity<TranslationDTO> addTranslation(@RequestParam("wordId") Long id,
                                                  @RequestParam("translation") String translation,
                                                  @RequestParam("sentence") String sentence){

        TranslationDTO response = null;
        try{

            response = translationService.addTranslation(id, translation, sentence);


        } catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<WordDTO> deleteTranslation(@RequestParam("translationId") Long translationId){

        WordDTO response = null;

        try{
            translationService.delete(translationId);

        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "sentence/delete")
    public ResponseEntity<WordDTO> deleteSentence(@RequestParam("sentenceId") Long sentenceId){

        WordDTO response = null;

        try{
            translationService.deleteSentence(sentenceId);

        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "sentence/add")
    public ResponseEntity<SentenceDTO> addSentence(@RequestBody SentenceDTO sentenceDto){


        SentenceDTO response = null;

        try{

            response = translationService.addSentence(sentenceDto);

        } catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = "sentence/edit")
    public ResponseEntity<SentenceDTO> editSentence(@RequestBody SentenceDTO sentenceDto){


        SentenceDTO response = null;

        try{

            response = translationService.editSentence(sentenceDto);

        } catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = "/edit")
    public ResponseEntity<TranslationDTO> editTranslation(@RequestBody TranslationDTO translationDTO){


        TranslationDTO response = null;

        try{

            response = translationService.editTranslation(translationDTO);

        } catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
