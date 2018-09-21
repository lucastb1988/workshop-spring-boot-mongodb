package br.com.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.workshopmongo.domain.Post;

//referencias
//https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
//https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
//https://docs.mongodb.com/manual/reference/operator/query/gte/#op._S_gte

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //<Post, tipo do id da classe User(String)>

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//title = campo do objeto Post como parametro
	//$regex = chave do mongo para trazer uma parte de uma string / ?0 = primeiro parametro encontrado
	//$options = chave do mongo opcional que traz opçoes para regex - 'i' = case insensitive
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	@Query("{ $and: " //inicia uma busca por data minima e maxima de um Post usando a chave $and ((2 parametros) pega query geral a partir da chave $and([])
			+ "[ { date: {$gte: ?1} }, { date: {$lte: ?2} }, " //utiliza a chave $gte = greater than or equal(minDate) e chave $lte = less than or equal(maxDate)
			+ "{ $or: " ////inicia uma busca por titulo ou body ou comments.text utilizando chave $or (1 parametro) pega query geral a partir da chave $or([]))
			+ "[ { 'title': { $regex: ?0, $options: 'i' } }, " //busca title dentro de Post 
			+ "{ 'body': { $regex: ?0, $options: 'i' } }, " //busca body dentro de Post
			+ "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }") //busca dentro de Post a lista de comments o text de cada comentario
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
