package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Guild;


public interface GuildRepository extends JpaRepository<Guild,Integer>
{

}
