package com.GroceryStore.konsole;

import com.GroceryStore.Store;

import java.util.List;

public class Spanish extends UI {

    public Spanish(Store store) {
        super(store,
                List.of(
                        "1. agregar producto al inventario",
                        "2. desechar un producto",
                        "3. enumerar los productos disponibles",
                        "4. vender un producto",
                        "5. salir",
                        "6. cambiar idioma"
                ),
                List.of(
                        "1. Bebida",
                        "2. Fruta"
                ),
                "Bienvenido a ",
                "¿Qué queres hacer?",
                "Ingrese selección:",
                "¿Qué tipo de producto?",
                "presione enter para cancelar",
                List.of(
                        "OK",
                        "Número invalido",
                        "excepción general",
                        "Debe ingresar algo",
                        "404 - Producto no encontrado"),
                List.of("Nombre:", "precio:", "id:", "descripción:"),
                List.of(
                        "Volumen:", "Código de unidad de volumen:"
                ),
                List.of(
                        "Nivel de dureza:",
                        "Es orgánico:"),
                "Ingrese "
        );
    }
}
