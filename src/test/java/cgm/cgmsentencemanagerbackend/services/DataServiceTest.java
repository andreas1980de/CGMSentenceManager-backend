package cgm.cgmsentencemanagerbackend.services;

import cgm.cgmsentencemanagerbackend.entities.Sentence;
import cgm.cgmsentencemanagerbackend.entities.dto.SentenceDto;
import cgm.cgmsentencemanagerbackend.repositories.DataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

    @Mock
    DataRepository dataRepository;
    @InjectMocks
    DataService dataService;

    @Test
    void getData_shouldReturnData(){
        //given
        List<Sentence> sentenceList = new ArrayList<>();

        //when
        when(dataRepository.findAll()).thenReturn(sentenceList);
        var rueckgabe = dataService.getData();

        //then
        assertEquals(sentenceList, rueckgabe);
    }

    @Test
    void changeSentence_shouldReturnOK() {
        //given
        SentenceDto sentenceDto = new SentenceDto();
        Sentence sentence = new Sentence();

        //when
        when(dataRepository.findById(anyLong())).thenReturn(Optional.of(sentence));
        when(dataRepository.save(sentence)).thenReturn(sentence);
//        doNothing().when(dataRepository).save(sentence);
        var rueckgabe= dataService.changeSentence(sentenceDto);

        //then
        assertEquals(HttpStatus.OK, rueckgabe);
    }

    @Test
    void changeSentence_shouldReturnError() {
        //given
        SentenceDto sentenceDto = new SentenceDto();
        Sentence sentence = new Sentence();

        //when
        var rueckgabe= dataService.changeSentence(sentenceDto);

        //then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, rueckgabe);
    }
}
