package converter;

import org.springframework.stereotype.Service;

import dto.quest.QuestDtoR;
import dto.quest.QuestDtoWFull;

import entities.Quest;

@Service
public class QuestConverter 
{
    public Quest dtoRtoQuest (QuestDtoR dto)
    {
        return Quest
                .builder()
                .status(dto.getStatus())
                .rank(dto.getRank())
                .reward(dto.getReward())
                .description(dto.getDescription())
                .build();
    }

    public QuestDtoWFull questToDtoWFull (Quest q)
    {
    
        return QuestDtoWFull
                .builder()
                .date_created(q.getDate_created())
                .status(q.getStatus())
                .rank(q.getRank())
                .reward(q.getReward())
                .area(q.getArea())
                .date_completed(q.getDate_completed())
                .map_url(q.getMap_url())
                .description(q.getDescription())
                .type(q.getType())
                .patron(q.getPatron())
                .id(q.getId())
                .build();
 
    }
}
