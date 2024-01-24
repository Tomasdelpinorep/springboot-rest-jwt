package net.openwebinars.springboot.restjwt;

import net.openwebinars.springboot.restjwt.note.controller.NoteController;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.note.service.NoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    NoteRepository noteRepository;

    @MockBean
    NoteService noteService;

    @Test
    void getByAuthorTest() throws Exception{
        Note note1 = Note.builder()
                .id(1L)
                .author("Tomas")
                .build();

        when(noteRepository.findByAuthor("Tomas")).thenReturn(List.of(note1));

        mvc.perform(get("/note/author/Tomas").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.author", is("Tomas")));
    }
}
