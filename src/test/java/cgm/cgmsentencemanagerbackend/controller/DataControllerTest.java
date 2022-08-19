package cgm.cgmsentencemanagerbackend.controller;

import cgm.cgmsentencemanagerbackend.entities.Sentence;
import cgm.cgmsentencemanagerbackend.entities.dto.SentenceDto;
import cgm.cgmsentencemanagerbackend.services.DataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataControllerTest {

    @Mock
    DataService dataService;

    @InjectMocks
    DataController dataController;

    @Test
    void getData_shouldReturnData(){
        //given
        List<Sentence> sentenceList = new ArrayList<>();

        //when
        when(dataService.getData()).thenReturn(sentenceList);
        var rueckgabe = dataController.getData();

        //then
        assertEquals(sentenceList, rueckgabe);
    }

    @Test
    void changeSentence_shouldReturnOK() {
        //given
        SentenceDto sentenceDto = new SentenceDto();

        //when
        when(dataService.changeSentence(sentenceDto)).thenReturn(HttpStatus.OK);
        var rueckgabe= dataController.saveSentence(sentenceDto);

        //then
        assertEquals(HttpStatus.OK, rueckgabe);
    }

}
