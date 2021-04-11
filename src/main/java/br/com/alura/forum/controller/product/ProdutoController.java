package br.com.alura.forum.controller.product;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	@GetMapping("/nameWithAutoComplete")
	public List<Produto> getAll(@RequestBody final String q, final Model model) {
		var queryBuilder = QueryBuilders.matchPhrasePrefixQuery("nome.autocomplete", q);
		return search(new NativeSearchQuery(queryBuilder));
	}

	@GetMapping("/mustMatch")
	public List<Produto> mustMatch() {
		Queries.mustMatch();
		var queryBuilder = QueryBuilders.boolQuery()
		                                .must(QueryBuilders.matchQuery("nome", "história"))
		                                .must(QueryBuilders.matchQuery("tags", "impresso"));
		return search(new NativeSearchQuery(queryBuilder));
	}

	@GetMapping("/nomeAutocomplete/{query}")
	public List<Produto> nomeAutocomplete(@PathVariable final String query) {
		Queries.nomeAutocomplete();
		var queryBuilder = QueryBuilders.matchQuery("nome.autocomplete", query);
		var highlight = new HighlightBuilder().field("nome.autocomplete").fields().toArray();
		return search(new NativeSearchQuery(queryBuilder));
	}

	@GetMapping("/minimumShouldMatch/{query}")
	public List<Produto> minimumShouldMatch(@PathVariable final String query) {
		Queries.minimumShouldMatch();
		var queryBuilder = QueryBuilders.matchQuery("nome", query).minimumShouldMatch("50%");
		return search(new NativeSearchQuery(queryBuilder));
	}

	@GetMapping("/byNomeCategoriaPreco")
	public List<Produto> byCategoriaPrecoGreaterThan(@RequestParam(required = false) final String nome,
	                                                 @RequestParam final String categoria,
	                                                 @RequestParam final String preco) {
		Queries.byNomeCategoriaPreco();
		var queryBuilder = QueryBuilders.boolQuery()
		                                .must(QueryBuilders.matchQuery("categoria", categoria))
		                                .filter(QueryBuilders.rangeQuery("preco").gte(preco));
		return search(new NativeSearchQuery(queryBuilder));
	}

	private List<Produto> search(Query query) {
		final SearchHits<Produto> result = elasticsearchOperations.search(query, Produto.class);
		if (result.isEmpty()) {
			return Collections.emptyList();
		}
		final List<Produto> produtos = result.getSearchHits()
		                                     .stream()
		                                     .map(SearchHit::getContent)
		                                     .collect(Collectors.toList());
		return produtos;
	}

}