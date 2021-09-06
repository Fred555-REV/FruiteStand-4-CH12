package com.GroceryStore.console;

import java.util.List;

public class Spanish implements Language {
    @Override
    public List<String> MENU() {
        return List.of(
                "1. agregar producto al inventario",
                "2. desechar un producto",
                "3. enumerar los productos disponibles",
                "4. vender un producto",
                "5. salir",
                "6. cambiar idioma"
        );
    }

    @Override
    public List<String> PRODUCT_TYPES() {
        return List.of(
                "1. Bebida",
                "2. Fruta"
        );
    }

    @Override
    public String WELCOME() {
        return "Bienvenido a ";
    }

    @Override
    public String MENU_PROMPT() {
        return "¿Qué queres hacer?";
    }

    @Override
    public String SELECT_PROMPT() {
        return "Ingrese selección:";
    }

    @Override
    public String PRODUCT_PROMPT() {
        return "¿Qué tipo de producto?";
    }

    @Override
    public String CANCEL_PROMPT() {
        return "presione enter para cancelar";
    }

    @Override
    public List<String> ERROR_MSGS() {
        return List.of(
                "OK",
                "Número invalido",
                "excepción general",
                "Debe ingresar algo",
                "404 - Producto no encontrado");
    }

    @Override
    public List<String> PRODUCT_FIELDS() {
        return List.of("Nombre:", "precio:", "id:", "descripción:");
    }

    @Override
    public List<String> FRUIT_SPEC_FIELDS() {
        return List.of(
                "Volumen:", "Código de unidad de volumen:"
        );
    }

    @Override
    public List<String> BEVERAGE_SPEC_FIELDS() {
        return List.of(
                "Nivel de dureza:",
                "Es orgánico:");
    }

    @Override
    public String ENTER() {
        return "Entre ";
    }
}
