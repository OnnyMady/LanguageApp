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

    public WordDTO updateFileSoundName (Integer id, String extension) throws Exception{
        WordDTO editWord = new WordDTO(wordRepository.findById(id).get());
        editWord.setSoundName( id + extension );
        return new WordDTO(wordRepository.save(editWord.toEntity()));
    }

    public WordDTO updateFilePictureName(Integer id, String extension) throws Exception{
        WordDTO editWord = new WordDTO(wordRepository.findById(id).get());
        editWord.setPictureName( id + extension );
        return new WordDTO(wordRepository.save(editWord.toEntity()));
    }

    public WordDTO findWord(String id) throws Exception{
         return new WordDTO(wordRepository.findById(Integer.parseInt(id)).get());
    }

    public WordDTO editWord(WordDTO wordDTO, String category, String name) throws Exception{
        wordDTO.setName(name);
        wordDTO.setCategory(category);
        wordRepository.save(wordDTO.toEntity());

        return wordDTO;
    }
}
