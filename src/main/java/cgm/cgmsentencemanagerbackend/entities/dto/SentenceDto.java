package cgm.cgmsentencemanagerbackend.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SentenceDto {
    long id;
    String n;
    String s;
    String v;
    String o;
}
