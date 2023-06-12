package proj.LanguageApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.LanguageApp.DTO.WordDTO;
import proj.LanguageApp.Entity.Word;
import proj.LanguageApp.Repository.WordRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<WordDTO> getWords () {

        List<WordDTO> wordsList = new ArrayList<>();

        for(Word word: wordRepository.findAll()){
            wordsList.add(new WordDTO(word));
        }

        return wordsList;
    }

    public void deleteWord (Long id){
        wordRepository.deleteWordById(id);
    }

    public WordDTO addWord(WordDTO wordDTO){
        return new WordDTO(wordRepository.save(wordDTO.toEntity()));
    }

    public WordDTO editWord(WordDTO wordDTO){
        WordDTO editWord = new WordDTO(wordRepository.findById(wordDTO.getId()).get());
        editWord.setName(wordDTO.getName());
        editWord.setCategory(wordDTO.getCategory());
        editWord.setSentance(wordDTO.getSentance());
        editWord.setSound(wordDTO.getSound());
        editWord.setTranslation(wordDTO.getTranslation());
        return new WordDTO(wordRepository.save(editWord.toEntity()));
    }
}
