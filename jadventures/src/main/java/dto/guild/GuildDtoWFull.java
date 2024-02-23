package dto.guild;

import java.util.List;

import entities.Quest;
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
public class GuildDtoWFull extends GuildDtoBase
{
    
    private Integer id;    
    private String seal_img_url;
    private int n_employees;
    private String hq_address;
    private List<Quest> questions;

}
