package dto.quest;

import entities.Guild;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class QuestDtoWFull extends QuestDtoBase
{
    private Integer id;

    private Guild patron;
}
