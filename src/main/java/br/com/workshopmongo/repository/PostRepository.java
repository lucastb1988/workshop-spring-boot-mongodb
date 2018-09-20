package br.com.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //<Post, tipo do id da classe User(String)>

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//title = campo do POST como parametro
	//$regex = chave do mongo para trazer uma parte de uma string / ?0 = primeiro parametro encontrado
	//$options = chave do mongo opcional que traz opçoes para regex - 'i' = case insensitive
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
}
