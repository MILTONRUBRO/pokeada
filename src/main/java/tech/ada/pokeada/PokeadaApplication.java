package tech.ada.pokeada;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PokeadaApplication implements CommandLineRunner {

	private final PokemonRepository repository;

	public PokeadaApplication(PokemonRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PokeadaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/* Teste seu método aqui
			repository.find... */
		List<Pokemon> pokemonsDefenses = repository.findByDefenseIsGreaterThan(45);
		System.out.println(pokemonsDefenses);
		
		List<Pokemon> pokemonsPsychic= repository.findByFirstTypeIn(List.of("psychic"));
		System.out.println(pokemonsPsychic);
		
		List<Pokemon> pokemonsAttacks = repository.findBySpecialAttackBetween(60, 100);
		System.out.println(pokemonsAttacks);
		
		List<Pokemon> pokemonsSpecials = repository.findBySpecialAttackIsGreaterThanEqual(33);
		System.out.println(pokemonsSpecials);
		
		Optional<Pokemon> possiblePokemon = repository.findByName("mew");
		if(possiblePokemon.isPresent()) {
			System.out.println(possiblePokemon.get());
		}

	}
}
