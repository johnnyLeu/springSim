package dto.guild;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class GuildDtoBase 
{
    private String name;
    private String authentication_seal;
    private String seal_img_url;
    private int n_employees;
    private String hq_address;
}
