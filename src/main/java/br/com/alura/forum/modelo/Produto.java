package br.com.alura.forum.modelo;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(indexName = "produtos_autocomplete", shards = 1) // createIndex = false
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	@Field(type = FieldType.Text)
	public String nome;
	@Field(type = FieldType.Text)
	@Id
	public String id;
	@Field(type = FieldType.Text)
	public String categoria;
	@Field(type = FieldType.Text)
	public String subcategoria;
	public List<String> tags;
	@Field(type = FieldType.Text)
	public String fornecedor;
	@Field(type = FieldType.Float)
	public float preco;
}
