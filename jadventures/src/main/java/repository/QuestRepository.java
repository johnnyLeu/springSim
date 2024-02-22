package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Quest;

public interface QuestRepository extends JpaRepository<Quest,Integer>
{

}
