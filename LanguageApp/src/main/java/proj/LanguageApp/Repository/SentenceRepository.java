package proj.LanguageApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.LanguageApp.Entity.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {
}
