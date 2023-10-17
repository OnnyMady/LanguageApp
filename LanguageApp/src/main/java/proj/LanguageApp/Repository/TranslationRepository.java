package proj.LanguageApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.LanguageApp.Entity.Translation;

public interface TranslationRepository extends JpaRepository<Translation, Long> {

}
