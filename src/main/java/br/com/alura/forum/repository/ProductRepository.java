package br.com.alura.forum.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.alura.forum.controller.dto.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

	Optional<Product> findById(Long id);

	Product save(Product product);

	Page<Product> findAll(Pageable pageable);

//	default Product complexQueryFindIfProductExists(String name) {
//		final BoolQueryBuilder qb = QueryBuilders.boolQuery()
////		.must(QueryBuilders.scriptScoreQuery(QueryBuilders.matchAllQuery(), new Script("randomScore(1000, 'created_at'")))
//				.filter(QueryBuilders.termQuery("name", name)).mustNot(QueryBuilders.termQuery("id", 1));
//		Query query = new NativeSearchQuery(qb).setPageable(PageRequest.of(0, 1));
//		return elasticsearchRestTemplate.searchOne(query, Product.class);
//	}

//	@org.springframework.data.jpa.repository.Query(value = "SELECT new br.com.alura.forum.controller.dto.Product(id, name) "
//			+ "where Product prod where ?1 = prod.id");
//	Product findByIdJPQLQuery(Long id);
}
