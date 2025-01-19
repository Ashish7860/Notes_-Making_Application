package com.nagarro.Note_Maker_Backend.scheduler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.nagarro.Note_Maker_Backend.entity.User;
import com.nagarro.Note_Maker_Backend.repo.NotesRepository;
import com.nagarro.Note_Maker_Backend.repo.UserRepository;

@Component
public class HourlyDeleteingNotes {

	
	@Autowired
	private NotesRepository noteRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Scheduled(cron = "0 * * * * *") //one hour
	
	//@Scheduled(cron = "*/10 * * * * * ") //ten sec
	
	public void noteDeleteHourly() {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			List<Long> lastTenNotesIds = noteRepository.findLastTenNoteIds(user.getId(), PageRequest.of(0,  10));
			noteRepository.deleteUsers(user.getId(), lastTenNotesIds);
		}
	}
}
