package com.Aditya.Secure_Notes.service;

import com.Aditya.Secure_Notes.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    Note createNoteForUser(String username, String content);
    Note updateNoteForUser(Long noteId, String content,  String username);
    void  deleteNoteForUser(Long userId, String username);
    List<Note> getNoteForUser(String username);
}
