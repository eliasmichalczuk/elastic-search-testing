package br.com.alura.forum.controller.product;

public class Queries {

	public static void minimumShouldMatch() {
//		GET /produtos_autocomplete/_search
//		{
//		  "query" : {
//		    "match": {
//		      "nome": {
//		        "query": "big data guia",
//		        "minimum_should_match": "50%"
//		      }
//		    }
//		  }
//		}
	}

	public static void mustMatch() {
//		GET /produtos_autocomplete/_search
//		{
//		  "query" : {
//		    "bool": {
//		      "must": [
//		        {"match": {"tags": "impresso" }},
//		        {"match": {"nome": "história" }}
//		      ]
//		    }
//		  }
//		}
	}

	public static void nomeAutocomplete() {
//		, null, null, new HighlightBuilder.Field()
//		{
//			  "query" : {
//			    "match" : {
//			      "nome.autocomplete": "data bi"
//			    }
//			  }
//			}
	}

	public static void byNomeCategoriaPreco() {
//		GET /produtos_autocomplete/_search
//		{
//		  "query" : {
//		   "bool": {
//		     "must": {
//		       "match": {"categoria": "livro"}
//		     },
//		     "filter": {
//		       "range":{"preco": {"gte" : 50}}
//		     }
//		   }
//		  }
//		}

	};

}
