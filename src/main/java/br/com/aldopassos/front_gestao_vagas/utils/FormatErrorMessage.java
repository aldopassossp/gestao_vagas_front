package br.com.aldopassos.front_gestao_vagas.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatErrorMessage {
    
    public static String formatErrorMessage(String string){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(string);
            if(rootNode.isArray()){
                return formaArrayErrorMessage(rootNode);
            }
            return rootNode.asText();
        } catch (Exception e) {
            return string;
        }
    }

    public static String formaArrayErrorMessage(JsonNode arrayNode){
        StringBuilder formattedMessager = new StringBuilder();
        for(JsonNode node: arrayNode){
            formattedMessager.append("- ").append(node.get("message").asText()).append("\n");
        }
        return formattedMessager.toString();
    }
}
