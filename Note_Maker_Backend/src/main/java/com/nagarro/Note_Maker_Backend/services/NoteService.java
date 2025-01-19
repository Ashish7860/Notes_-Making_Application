package com.nagarro.Note_Maker_Backend.services;
import java.util.List;
import java.util.Optional;
import java.nio.file.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.Note_Maker_Backend.entity.Notes;
import com.nagarro.Note_Maker_Backend.entity.User;
import com.nagarro.Note_Maker_Backend.repo.NotesRepository;

@Service
public class NoteService {
    @Autowired
    private NotesRepository noteRepository;

    public List<Notes> getAllNotesByUser(User user) {
        return noteRepository.findByUser(user);
    }

    public Notes createNote(User user, Notes note) {
        note.setUser(user);
        return noteRepository.save(note);
    }

    public void deleteNoteById(User user, Integer id) throws AccessDeniedException {
        Optional<Notes> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent() && optionalNote.get().getUser().equals(user)) {
            noteRepository.deleteById(id);
        } else {
            throw new AccessDeniedException("Access denied");
        }
    }
      
    public List<Notes> getLatestNotesForUser(User user) {
        // Implement logic to fetch the latest notes for the given user
        // You can use the NoteRepository to query the database for the latest notes
        return noteRepository.findTop10ByUserOrderByCreatedDtDesc(user);
    }

    
    

}

