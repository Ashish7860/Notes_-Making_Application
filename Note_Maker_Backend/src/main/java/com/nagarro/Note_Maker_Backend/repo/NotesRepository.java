package com.nagarro.Note_Maker_Backend.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.Note_Maker_Backend.entity.Notes;
import com.nagarro.Note_Maker_Backend.entity.User;


public interface NotesRepository extends JpaRepository<Notes, Integer> {
	List<Notes> findByUser(User user);
	 List<Notes> findTop10ByUserOrderByCreatedDtDesc(User user);
	 
	 @Query("SELECT n.id FROM Notes n WHERE n.user.id = :userId ORDER BY n.createdDt DESC") 
	 
	    List<Long> findLastTenNoteIds(@Param("userId") Long userId, PageRequest pageRequest); 
	 
	  
	 //Delete notes for a user that are not in the last ten notes. 
	 @Transactional 
	 @Modifying 
	 @Query(value = "DELETE FROM notes WHERE user_id = :userId AND id NOT IN :lastTenNoteIds", nativeQuery = true) 
	 
	 void deleteUsers(@Param("userId") Long userId, @Param("lastTenNoteIds") List<Long> lastTenNoteIds);


}
