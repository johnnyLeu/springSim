package controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import converter.QuestConverter;
import dto.quest.QuestDtoR;
import dto.quest.QuestDtoWFull;
import entities.Quest;
import repository.QuestRepository;

@RestController
public class QuestController 
{
    @Autowired
    QuestRepository repo;
    @Autowired
    QuestConverter conv;

    
     @GetMapping("/quest")
    public List<QuestDtoWFull> getAllQuestFull() 
    {
        return  repo.findAll()
                .stream()
                .map(e -> conv.questToDtoWFull(e))
                .toList();
    }

    @PostMapping("/quest") 
    public Quest insertQuest(@RequestBody QuestDtoR dto) 
    {
        Quest quest = conv.dtoRtoQuest(dto);
        String rank = quest.getRank();
        String type = quest.getType();
        String status = quest.getStatus();
        LocalDate dateCompleted = quest.getDate_completed();

        if (isValidRank(rank)&& isValidType(type)&&isValidStatus(status)&&isValidDateCompleted(status, dateCompleted)) 
            return repo.save(quest);

        else 
            throw new IllegalArgumentException("Il valore della proprietà 'rank' deve essere 'S', 'A', 'B', 'C' o 'D'.");
        
    }
    
    private boolean isValidRank(String rank) 
    {
        return rank != null && (rank.equals("S") || rank.equals("A") || rank.equals("B") || rank.equals("C") || rank.equals("D"));
    }
    private boolean isValidType(String type) 
    {
        return type != null && (type.equals("dungeon") || type.equals("monster hunt") || type.equals("village defense") || type.equals("errand") || type.equals("bodyguard") || type.equals("patrol"));
    }
    private boolean isValidStatus(String status) 
    {
        return status != null && (status.equals("awaiting") || status.equals("pending") || status.equals("success") || status.equals("failed"));
    }
    private boolean isValidDateCompleted(String status, LocalDate dateCompleted) 
    {
    return !((status.equals("success") || status.equals("failed")) && dateCompleted == null);
    }

     @GetMapping("/quest/{id}")
    public QuestDtoWFull getMethodName(@PathVariable  @NonNull Integer id) 
    {
        return conv.questToDtoWFull(repo.findById(id).get());
    }

     @PutMapping("/quest/{id}")
    public QuestDtoWFull updateQuest(@RequestBody QuestDtoR dto,@PathVariable Integer id) 
    {
        Quest q = conv.dtoRtoQuest(dto);
        q.setId(id);
        if (isValidRank(q.getRank()) && isValidType(q.getType()) && isValidStatus(q.getStatus()) && isValidDateCompleted(q.getStatus(), q.getDate_completed())) {
            return conv.questToDtoWFull(repo.save(q));
        } else {
            throw new IllegalArgumentException("Il valore della proprietà 'rank' deve essere 'S', 'A', 'B', 'C' o 'D', il valore della proprietà 'type' deve essere 'dungeon', 'monster hunt', 'village defense', 'errand', 'bodyguard' o 'patrol', il valore della proprietà 'status' deve essere 'awaiting', 'pending', 'success' o 'failed', e la data di completamento deve essere impostata solo se lo status è 'success' o 'failed'.");
        }
    }

    @DeleteMapping("/quest/{id}")
    public void  deleteQuest(@PathVariable  @NonNull Integer id) 
    {
         repo.deleteById(id);
    }
}