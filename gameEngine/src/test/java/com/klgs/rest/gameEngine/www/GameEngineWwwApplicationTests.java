package com.klgs.rest.gameEngine.www;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.klgs.rest.gameEngine.dao.UserDAO;
import com.klgs.rest.gameEngine.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameEngineWwwApplicationTests {

	private MockMvc mockMvc;
	
	@Mock
	private UserDAO userDao;
	
	@InjectMocks
	private UserRest userRest;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Before
	public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(userRest).build();
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSampleUserShouldBeSavedInTheDatabase() throws Exception {
		User user = new User();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(user);
		user.setEmailId("pulgupta@gmail.com");
		mockMvc.perform(post("/user").
				content(requestJson)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
	}
}
