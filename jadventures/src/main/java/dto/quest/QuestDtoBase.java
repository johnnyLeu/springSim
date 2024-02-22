package dto.quest;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class QuestDtoBase 
{
    
    private LocalDate date_created;
    private String status;
    private String rank;
    private int reward;
    private String area;
    private LocalDate date_completed;
    private String map_url;
    private String description;
    private String type;

}
