package proj.LanguageApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.LanguageApp.Entity.Word;

public interface WordRepository extends JpaRepository<Word, Integer> {

    @Modifying
    @Query("delete from Word where id = :id")
    void deleteWordById(@Param("id") Long id);
}