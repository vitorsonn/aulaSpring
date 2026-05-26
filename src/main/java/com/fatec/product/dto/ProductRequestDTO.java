package com.fatec.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

public record ProductRequestDTO(
                @NotBlank(message = "Campo obrigatório") @Size(min = 4, max = 30, message = "Nome deve ter no minimo 3 e no maximo 30") String name,

                @NotBlank(message = "Campo obrigatório") @Size(min = 4, max = 100, message = "Descrição deve ter no minimo 5 e no maximo 100") String description,

                @Min(value = 0, message = "Preço não pode ser menor que zero") Double price) {

}
