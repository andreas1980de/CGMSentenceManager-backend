package cgm.cgmsentencemanagerbackend.services;

import cgm.cgmsentencemanagerbackend.entities.Sentence;
import cgm.cgmsentencemanagerbackend.entities.dto.SentenceDto;
import cgm.cgmsentencemanagerbackend.repositories.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Sentence sentence = new Sentence(sentenceDto.getId(), sentenceDto.getN(), sentenceDto.getS(), sentenceDto.getV(), sentenceDto.getO());
        dataRepository.save(sentence);
        return HttpStatus.OK;
    }
}
