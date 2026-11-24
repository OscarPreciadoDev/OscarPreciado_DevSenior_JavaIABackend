package com.devsenior.atiende.ia.openai;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

final class OpenAiFormato {

    private OpenAiFormato() {
    }

    record Peticion(
            String model,
            List<Mensaje> messages,
            @JsonProperty("max_tokens") int maxTokens,
            double temperature
    ) {
    }

    record Mensaje(String role, String content) {
    }

    record PeticionConPartes(
            String model,
            List<MensajeConPartes> messages,
            @JsonProperty("max_tokens") int maxTokens,
            double temperature
    ) {
    }

    record MensajeConPartes(String role, List<Parte> content) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    record Parte(String type, String text, @JsonProperty("image_url") UrlDeArchivo imageUrl) {

        static Parte texto(String texto) {
            return new Parte("text", texto, null);
        }

        static Parte archivo(String urlDeDatos) {
            return new Parte("image_url", null, new UrlDeArchivo(urlDeDatos));
        }
    }

    record UrlDeArchivo(String url) {
    }

    record Respuesta(List<Opcion> choices, Uso usage) {
    }

    record Opcion(Mensaje message, @JsonProperty("finish_reason") String finishReason) {
    }

    record Uso(
            @JsonProperty("prompt_tokens") int promptTokens,
            @JsonProperty("completion_tokens") int completionTokens
    ) {
    }
}
