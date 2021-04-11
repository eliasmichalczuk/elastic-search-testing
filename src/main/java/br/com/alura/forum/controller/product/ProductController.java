package br.com.alura.forum.controller.product;

import static java.util.Objects.nonNull;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.Product;
import br.com.alura.forum.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	@Autowired
	private ProductRepository productRepository;

//	@PostMapping("")
//	public String save(@RequestBody Product product) {
//		IndexQuery indexQuery = new IndexQueryBuilder().withId(product.id.toString()).withObject(product).build();
//		String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of("memes"));
//		return documentId;
//	}

	@PostMapping("")
	public long save(@RequestBody Product product) throws IOException {
		return productRepository.save(product).id;
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) throws IOException {
		return productRepository.findById(id).orElseThrow();
//		return elasticsearchOperations.searchOne(new NativeSearchQuery(new query), ProductDto.class);
//		return elasticsearchOperations.queryForObject(GetQuery.getById(id.toString()), ProductDto.class);
	}

	@GetMapping("/getAll")
	public Page<Product> getAll(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size) {
		return productRepository.findAll(PageRequest.of(nonNull(page) ? page : 0, nonNull(size) ? size : 10));
	}

//	@PostMapping
//	public void bulkInsert(@RequestBody(required = true) List<Product> products) {
//		  public List<String> createProductIndexBulk
//		            (final List<Product> products) {
//
//		      List<IndexQuery> queries = products.stream()
//		      .map(product->
//		        new IndexQueryBuilder()
//		        .withId(product.getId().toString())
//		        .withObject(product).build())
//		      .collect(Collectors.toList());;
//		    
//		      return elasticsearchOperations
//		      .bulkIndex(queries,IndexCoordinates.of(PRODUCT_INDEX));
//		  }
//	}
}
