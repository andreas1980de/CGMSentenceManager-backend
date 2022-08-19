package cgm.cgmsentencemanagerbackend.repositories;

import cgm.cgmsentencemanagerbackend.entities.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Sentence, Long> {
}
