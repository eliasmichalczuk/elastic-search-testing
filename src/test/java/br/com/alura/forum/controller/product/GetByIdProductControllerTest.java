//package br.com.alura.forum.controller.product;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.com.alura.forum.controller.dto.Product;
//import br.com.alura.forum.repository.ProductRepository;
//
////@RunWith(SpringRunner.class)
////@DataJpaTest -> para testar repositories
//@ActiveProfiles(profiles = "test")
//@SpringBootTest
//@AutoConfigureMockMvc
//@Transactional
//public class GetByIdProductControllerTest {
//
//	static String PATH = "/product";
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@BeforeEach
//	void beforeEach() {
//		productRepository.save(new Product("produto 1", 1L));
//	}
//
//	@Test
//	void shouldReturnProduct1() throws Exception {
//
//		mockMvc.perform(get(PATH + "/1").contentType(APPLICATION_JSON_VALUE))
//		       .andExpect(status().is2xxSuccessful())
//		       .andExpect(jsonPath("$.id", is(1)))
//		       .andExpect(jsonPath("$.name", is("produto 1")));
//	}
//
//}
