package com.example.PokemonBackEndProject.Service;

public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;
    @Transactional
    //PUT MAPPING
      /* Find the pokemon you want to update by id. If you cannot find it, display message that it does not exist.
    If the name/type of that pokemon is not null and is not equal to the name/type value you are trying to input, set
    them to the new values that you have input.
     */
    public void updatePokemon(Long pokemonId, String name, String type){
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new IllegalStateException("Pokemon with " +pokemonId + " Does not exist!"));
        if (pokemon.getName() != null  && !Objects.equals(pokemon.getName(), name)) {
            pokemon.setName(name);
        }
        if (pokemon.getType() != null && !Objects.equals(pokemon.getType(), type)) {
            pokemon.setType(type);
        }
    }

    // DELETE MAPPING
    public void deletePokemon(Long pokemonId) {
        boolean exists = pokemonRepository.existsById(pokemonId);
        if (!exists) {
            throw new IllegalStateException(
                    "pokemon with id " + pokemonId + "does not exist");
        }
        pokemonRepository.deleteById(pokemonId);
    }
    
}
