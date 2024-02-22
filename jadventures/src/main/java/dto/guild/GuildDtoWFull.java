package dto.guild;

import java.util.List;

import entities.Quest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GuildDtoWFull extends GuildDtoBase
{
    private Integer id;
    private List<Quest> questions;

}
