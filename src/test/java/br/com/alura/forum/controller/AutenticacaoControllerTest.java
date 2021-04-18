//package br.com.alura.forum.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.net.URI;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("test")
//@AutoConfigureMockMvc
//public class AutenticacaoControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void deveRetornarErro() throws Exception {
//		var path = new URI("/auth");
//		var body = "{\"email\": \"e@e.com\", \"senha\": \"s\"";
//
//		mockMvc.perform(post(path).content(body).contentType(MediaType.APPLICATION_JSON))
//		       .andExpect(status().isBadRequest());
//	}
//}
