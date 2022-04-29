package com.lms.app;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.app.controller.AuthorController;
import com.lms.app.entity.Author;
import com.lms.app.service.AuthorService;

@WebMvcTest(AuthorController.class)
public class AuthorControllerIntTest {

	@Autowired
	private AuthorController authorController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AuthorService authorService;
	
	@Test
	public void saveAuthorTest() throws Exception {
		// mocking author data that is to be saved
		Author author = new Author();
		author.setName("John");
		
		when(authorService.saveAuthor(any(Author.class))).thenReturn(author);
		
		// mock the post request to save author "/api/authors"
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/authors")
				.content(new ObjectMapper().writeValueAsString(author))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
				.andExpect(status().isCreated());
		
		
	}
	
	@Test
	public void getAuthorByIdTest() throws Exception {
		// mocking data send by author service
		Author author = new Author();
		author.setId(13);
		author.setName("John");

		when(authorService.getAuthorById(anyLong())).thenReturn(author);
		
		//creating mock HTTP to verify the expected result
	mockMvc.perform(MockMvcRequestBuilders.get("/api/authors/13")
			.content(new ObjectMapper().writeValueAsString(author)))
			.andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
			.andExpect(status().isOk());
		
		
	}
	
	
	
	
 	
}
