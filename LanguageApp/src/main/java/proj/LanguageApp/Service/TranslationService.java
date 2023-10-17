package proj.LanguageApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.LanguageApp.DTO.SentenceDTO;
import proj.LanguageApp.DTO.TranslationDTO;
import proj.LanguageApp.Entity.Sentence;
import proj.LanguageApp.Entity.Translation;
import proj.LanguageApp.Repository.SentenceRepository;
import proj.LanguageApp.Repository.TranslationRepository;
import proj.LanguageApp.Repository.WordRepository;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private WordRepository wordRepository;

    public void addTranslation(Long wordId, String translationName, String sentenceName) {
        Sentence sentence = new Sentence();
        Translation translation = new Translation();

        translation.setWord(wordRepository.findById(wordId).get());
        translation.setName(translationName);
        translationRepository.save(translation);

        sentence.setSentence(sentenceName);
        sentence.setTranslation(translation);
        sentenceRepository.save(sentence);

    }


}
