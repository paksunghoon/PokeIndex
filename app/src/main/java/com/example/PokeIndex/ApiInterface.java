package com.example.PokeIndex;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon/?limit=808&offset=0")
    Call<Data> getPokemonName();
}