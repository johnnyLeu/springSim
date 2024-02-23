package controller;

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

import converter.GuildConverter;
import dto.guild.GuildDtoR;
import dto.guild.GuildDtoWFull;
import dto.guild.logInDtoR;
import entities.Guild;
import repository.GuildRepository;

@RestController
public class GuildController 
{
    @Autowired
    GuildRepository repo;
    @Autowired
    GuildConverter conv;

@GetMapping("/guild/full")
public List<GuildDtoWFull> getAllGuildFull() {
    return  repo.findAll()
                .stream()
                .map(e -> conv.guildToDtoWFull(e))
                .toList();
}

@PostMapping("/patronlogin")
public Guild logIn(@RequestBody logInDtoR LogDto)
{
    
}

@PostMapping("/guild")
public Guild insertGuild(@RequestBody GuildDtoR dto) {
        Guild guild = conv.dtoRtoGuild(dto);

        if (isValidAuthenticationSeal(guild.getAuthentication_seal())) 
            return repo.save(guild);
    
        else 
            throw new IllegalArgumentException("La proprietà 'authentication_seal' deve essere lunga almeno 8 caratteri e deve contenere almeno una minuscola, una maiuscola, un numero e un carattere speciale.");
    
}

private boolean isValidAuthenticationSeal(String authenticationSeal){
   
    if (authenticationSeal == null || authenticationSeal.length() < 8) 
        return false;
    
    boolean hasLowerCase = false;
    boolean hasUpperCase = false;
    boolean hasNumber = false;
    boolean hasSpecialChar = false;

    for (char c : authenticationSeal.toCharArray()) {
        if (Character.isLowerCase(c)) 
            hasLowerCase = true;

        else 
            if (Character.isUpperCase(c)) 
                hasUpperCase = true;

        else 
            if (Character.isDigit(c)) 
                hasNumber = true;

        else 
            if (
                !Character.isLowerCase(c)  && 
                !Character.isUpperCase(c)  && 
                !Character.isDigit(c)      && 
                !Character.isWhitespace(c) && 
                !Character.isAlphabetic(c) 
            )
                hasSpecialChar = true;
        
    }
    return hasLowerCase && hasUpperCase && hasNumber && hasSpecialChar;
}

@PutMapping ("/guild/{id}")
public Guild updateGuild(@RequestBody GuildDtoR dto, @PathVariable Integer id) {
    Guild guild = conv.dtoRtoGuild(dto);
    guild.setId(id);

    // Aggiungi controllo per la proprietà authentication_seal
    if (isValidAuthenticationSeal(guild.getAuthentication_seal())) {
        return repo.save(guild);
    } else {
        throw new IllegalArgumentException("La proprietà 'authentication_seal' deve essere lunga almeno 8 caratteri e deve contenere almeno una minuscola, una maiuscola, un numero e un carattere speciale.");
    }
}

@DeleteMapping("/guild/{id}")
public void  deleteGuild(@PathVariable  @NonNull Integer id) {
        repo.deleteById(id);
    }

}
 