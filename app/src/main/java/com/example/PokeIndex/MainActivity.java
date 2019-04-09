package com.example.PokeIndex;

import androidx.appcompat.app.AppCompatActivity;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //UI
        final Button testButton = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText numBox = (EditText) findViewById(R.id.editText);
        final ApiInterface pokeapi = ApiClient.getClient().create(ApiInterface.class);
        Call<Data> call = pokeapi.getPokemonName();
        //Call to API
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data data = response.body();
                //Get Pokemon names into array and changes first letter to be capitalized
                final String[] pokemonNames = new String[data.getResults().size()];
                for (int i = 0; i < data.getResults().size(); i++) {
                    pokemonNames[i] = data.getResults().get(i).getName();
                    pokemonNames[i] = pokemonNames[i].substring(0,1).toUpperCase() + pokemonNames[i].substring(1).toLowerCase();
                }
                //Click Go button
                testButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Value from number input
                        String numBoxVal = numBox.getText().toString();
                        int pokeVal = Integer.parseInt(numBoxVal);
                        //Stay within Pokemon database
                        if (pokeVal < 808) {
                            textView.setText(pokemonNames[pokeVal-1]);
                        }
                        if (pokeVal >= 808) {
                            numBox.setText("");
                        }
                    }
                });
            }
            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

