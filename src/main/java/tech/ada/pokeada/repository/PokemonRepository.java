package tech.ada.pokeada.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

 /*
 * Escreva as seguintes buscas utilizando query methods na interface PokemonRepository:

        * Listar Pokémons que a defense maior que o valor informado.
        * Listar Pokémons que o firstType entre uma lista de tipos informados.
        * Listar Pokémons que o specialAttack está entre dois valores informados.
        * Listar Pokémons que o specialAttack é maior ou igual que o valor informado.

    * Escreva também buscas utilizando query nativa na interface PokemonRepository:

    * Obter Pokémon pelo nome.
    * 
 * */
    
	 List<Pokemon> findByDefenseIsGreaterThan(Integer defense);
	 List<Pokemon> findByFirstTypeIn(List<String> types);
	 List<Pokemon> findBySpecialAttackIsGreaterThanEqual(Integer specialAttack);
	 List<Pokemon> findBySpecialAttackBetween(Integer first, Integer second);
	 
	 @Query(value = "SELECT p FROM Pokemon p where p.name = :name")
	 Optional<Pokemon> findByName(String name);
	 
}
