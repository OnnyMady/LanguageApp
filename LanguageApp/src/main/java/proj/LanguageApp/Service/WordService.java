package proj.LanguageApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.LanguageApp.DTO.WordDTO;
import proj.LanguageApp.Entity.Word;
import proj.LanguageApp.Repository.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<WordDTO> getWords () throws Exception{

        List<WordDTO> wordsList = new ArrayList<>();

        for(Word word: wordRepository.findAll()){
            wordsList.add(new WordDTO(word));
        }

        return wordsList;
    }

    public void deleteWord (Long id) throws Exception{
        wordRepository.deleteWordById(id);
    }

    public WordDTO addWord(WordDTO wordDTO) throws Exception{
        return new WordDTO(wordRepository.save(wordDTO.toEntity()));
    }

    public WordDTO updateFileName (WordDTO wordDTO, String extension) throws Exception{
        WordDTO editWord = new WordDTO(wordRepository.findById(wordDTO.getId()).get());
        editWord.setSoundName( wordDTO.getId() +extension );
        return new WordDTO(wordRepository.save(editWord.toEntity()));
    }

    public WordDTO updateFilePictureName(WordDTO wordDTO, String extension) throws Exception{
        WordDTO editWord = new WordDTO(wordRepository.findById(wordDTO.getId()).get());
        editWord.setPictureName( wordDTO.getId() +extension );
        return new WordDTO(wordRepository.save(editWord.toEntity()));
    }

    public WordDTO editWord(WordDTO wordDTO, String extension, String id) throws Exception{
        WordDTO editWord = new WordDTO(wordRepository.findById(wordDTO.getId()).get());
        editWord.setName(wordDTO.getName());
        editWord.setCategory(wordDTO.getCategory());
        editWord.setSentence(wordDTO.getSentence());
        editWord.setSoundName(id + extension);
        editWord.setTranslation(wordDTO.getTranslation());
        return new WordDTO(wordRepository.save(editWord.toEntity()));
    }
}
