package br.com.alura.forum.controller.dto;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(indexName = "product", shards = 1) // createIndex = false
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Field(type = FieldType.Text)
	public String name;
	@Field(type = FieldType.Long)
	@Id
	public Long id;
}
