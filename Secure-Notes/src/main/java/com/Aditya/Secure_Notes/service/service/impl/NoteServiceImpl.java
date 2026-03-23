package com.Aditya.Secure_Notes.service.service.impl;

import com.Aditya.Secure_Notes.models.Note;
import com.Aditya.Secure_Notes.repo.NoteRepository;
import com.Aditya.Secure_Notes.service.NoteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Override

    public Note createNoteForUser(String username, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(()
                -> new RuntimeException("Note Not Found"));
        note.setContent(content);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(Long userId, String username) {
        noteRepository.deleteById(userId);
    }

    @Override
    public List<Note> getNoteForUser(String username) {
         return noteRepository.findByOwnerUsername(username);

    }
}
