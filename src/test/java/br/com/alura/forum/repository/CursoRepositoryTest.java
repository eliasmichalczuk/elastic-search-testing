//package br.com.alura.forum.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import br.com.alura.forum.modelo.Curso;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//public class CursoRepositoryTest {
//
//	@Autowired
//	private CursoRepository repository;
//
//	@Before // org.junit.Before
//	public void beforeEach() {
//		repository.save(new Curso(null, "HTML 3", "memes"));
//	}
//
//	@Test
//	public void deveCarregarCurso() {
//		var curso = repository.findByNome("HTML 3");
//		assertNotNull(curso);
//		assertEquals("HTML 3", curso.getNome());
//
//	}
//}
