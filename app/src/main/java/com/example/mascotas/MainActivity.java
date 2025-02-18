package com.example.mascotas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategorias;
    private ListView listViewRazas;
    private List<Categoria> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        listViewRazas = findViewById(R.id.listViewRazas);

        // Crear las categorías y razas
        categorias = new ArrayList<>();
        categorias.add(new Categoria("Pastores", Arrays.asList("Pastor Catalán", "Pastor Alemán", "Komodor", "Pastor Australiano")));
        categorias.add(new Categoria("Pinscher", Arrays.asList("Dobermann", "Pinscher Alemán", "Pinscher Miniatura", "Schnauzer")));

        // Llenar el Spinner con los nombres de las categorías
        List<String> nombresCategorias = new ArrayList<>();
        for (Categoria categoria : categorias) {
            nombresCategorias.add(categoria.getNombre());
        }

        ArrayAdapter<String> categoriasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresCategorias);
        categoriasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(categoriasAdapter);

        // Configurar el listener para el Spinner
        spinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener la categoría seleccionada
                Categoria categoriaSeleccionada = categorias.get(position);

                // Mostrar las razas correspondientes en el ListView
                ArrayAdapter<String> razasAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, categoriaSeleccionada.getRazas());
                listViewRazas.setAdapter(razasAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No hacer nada
            }
        });
    }
}

