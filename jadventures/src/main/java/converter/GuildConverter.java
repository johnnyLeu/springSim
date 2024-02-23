package converter;

import org.springframework.stereotype.Service;

import dto.guild.GuildDtoR;
import dto.guild.GuildDtoWFull;
import entities.Guild;

@Service
public class GuildConverter 
{
    public Guild dtoRtoGuild (GuildDtoR dto)
    {
        return Guild
                .builder()
                .name(dto.getName())
                .authentication_seal(dto.getAuthentication_seal())
                .build();
    }

    public GuildDtoWFull guildToDtoWFull (Guild g)
    {
        return GuildDtoWFull
                .builder()
                .id(g.getId())
                .name(g.getName())
                .authentication_seal(g.getAuthentication_seal())
                .seal_img_url(g.getSeal_img_url())
                .n_employees(g.getN_employees())
                .hq_address(g.getHq_address())
                .questions(g.getQuestions())
                .build();
    }

}

