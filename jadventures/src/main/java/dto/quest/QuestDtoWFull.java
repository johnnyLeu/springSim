package dto.quest;

import java.time.LocalDate;

import entities.Guild;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class QuestDtoWFull extends QuestDtoBase
{

    private Integer id;
    private LocalDate date_created;    
    private LocalDate date_completed;
    private String area;
    private String type;
    private String map_url;
    private Guild patron;
    
}