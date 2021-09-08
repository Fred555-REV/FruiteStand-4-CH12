package com.GroceryStore.konsole;

import com.GroceryStore.Store;

import java.util.List;

public class Spanish extends UI {

    public Spanish(Store store) {
        super(store);
        MENU = List.of(
                "1. agregar producto al inventario",
                "2. desechar un producto",
                "3. enumerar los productos disponibles",
                "4. vender un producto",
                "5. salir",
                "6. cambiar idioma"
        );
        PRODUCT_TYPES = List.of(
                "1. Bebida",
                "2. Fruta"
        );
        WELCOME = "Bienvenido a ";
        MENU_PROMPT = "¿Qué queres hacer?";
        SELECT_PROMPT = "Ingrese selección:";
        PRODUCT_PROMPT = "¿Qué tipo de producto?";
        CANCEL_PROMPT = "presione enter para cancelar";
        ERROR_MSGS = List.of(
                "OK",
                "Número invalido",
                "excepción general",
                "Debe ingresar algo",
                "404 - Producto no encontrado");
        ;
        PRODUCT_FIELDS = List.of("Nombre:", "precio:", "id:", "descripción:");
        FRUIT_SPEC_FIELDS = List.of(
                "Volumen:", "Código de unidad de volumen:"
        );
        BEVERAGE_SPEC_FIELDS = List.of(
                "Nivel de dureza:",
                "Es orgánico:");
        ENTER = "Ingrese ";
    }
}
