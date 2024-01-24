package net.openwebinars.springboot.restjwt;

import net.openwebinars.springboot.restjwt.dto.NotesGroupedByTagsDto;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.note.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    NoteRepository noteRepository;

    @InjectMocks
    NoteService noteService;

    @Test
    void notesGroupedByTagsDtoListSizeGreaterThan0Test(){
        List<Note> data = List.of(
                new Note(1L,"Title 1", "content1", "Author 1", false,List.of("tag1","tag2"), LocalDateTime.now()),
                new Note(2L,"Title 2", "content2", "Author 1", false,List.of("tag3","tag4"), LocalDateTime.now()),
                new Note(3L,"Title 3", "content3", "Author 1", false,List.of("tag5","tag1"), LocalDateTime.now()),
                new Note(4L,"Title 4", "content4", "Author 1", false,List.of("tag2","tag3"), LocalDateTime.now()),
                new Note(5L,"Title 5", "content5", "Author 1", false,List.of("tag4","tag5"), LocalDateTime.now())
        );

        when(noteRepository.findByAuthor("Author 1")).thenReturn(data);

        List<NotesGroupedByTagsDto> result = noteService.notesGroupedByTagsDtoList("Author 1");

        assertEquals(5, result.size());
    }
}
