package br.com.posprodutos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductUnity {
    ONE_LITER("1L"), TWO_LITERS("2L"), FIVE_LITERS("5L"), ONE_UNITY("1UN");

    private final String unity;

    @Override
    public String toString() {
        return "" + unity;
    }
}
