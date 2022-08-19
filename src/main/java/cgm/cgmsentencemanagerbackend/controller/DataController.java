package cgm.cgmsentencemanagerbackend.controller;

import cgm.cgmsentencemanagerbackend.entities.Sentence;
import cgm.cgmsentencemanagerbackend.entities.dto.SentenceDto;
import cgm.cgmsentencemanagerbackend.services.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/data")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value="/getData", produces = {APPLICATION_JSON_VALUE})
    public List<Sentence> getData(){
        return dataService.getData();
    }

    @PutMapping(value = "/changeSentence")
    public HttpStatus saveSentence(@RequestBody SentenceDto sentence) {
        return dataService.changeSentence(sentence);
    }

}
