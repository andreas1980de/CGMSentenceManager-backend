package cgm.cgmsentencemanagerbackend.services;

import cgm.cgmsentencemanagerbackend.entities.Sentence;
import cgm.cgmsentencemanagerbackend.entities.dto.SentenceDto;
import cgm.cgmsentencemanagerbackend.repositories.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Sentence> getData(){
        return dataRepository.findAll();
    }

    public HttpStatus changeSentence(SentenceDto sentenceDto){
        try {
            Sentence sentence = dataRepository.findById(sentenceDto.getId()).orElseThrow();
            dataRepository.save(sentence);
            return HttpStatus.OK;
        } catch (NoSuchElementException e) {
            log.error("No entry was found in the table SENTENCE for the id {} : ", sentenceDto.getId(), e);
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
