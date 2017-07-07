package com.klgs.rest.gameEngine.www;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.klgs.rest.gameEngine.util.InMemoryStore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameEngineWwwApplicationTests {

	private MockMvc mockMvc;
	
	@Mock
	private InMemoryStore inMemoryStore;
	
	@InjectMocks
	private QuestionRest questionRest;
	
	@Before
	public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(questionRest).build();
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetQuestionShouldThrow404WhenResourceNotFound() throws Exception {
		mockMvc.perform(get("/question/1234")).andExpect(status().is4xxClientError());
		
	}
	

}
