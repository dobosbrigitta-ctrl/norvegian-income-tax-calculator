
package com.example.demo;

import com.azure.ai.agents.AgentsClientBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.openai.client.OpenAIClient;
import com.openai.models.conversations.Conversation;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.services.blocking.ConversationService;
import org.springframework.stereotype.Service;

@Service
public class NorwegianJobOfferAgentService {

    private static final String ENDPOINT =
            "https://gwen-inventory-openai.services.ai.azure.com/api/projects/inventory-mgmt";

    private static final String AGENT_NAME =
            "norwegian-job-offer-analyst";

    private final OpenAIClient openAIClient;

    public NorwegianJobOfferAgentService() {
        this.openAIClient = new AgentsClientBuilder()
                .credential(new DefaultAzureCredentialBuilder().build())
                .endpoint(ENDPOINT)
                .buildAgentScopedOpenAIClient(AGENT_NAME);
    }

    public String askAgent(String userMessage) {
        ConversationService conversationService = openAIClient.conversations();
        Conversation conversation = conversationService.create();

        Response response = openAIClient.responses().create(
                ResponseCreateParams.builder()
                        .conversation(conversation.id())
                        .input(userMessage)
                        .build()
        );

        return response.output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .map(outputText -> outputText.text())
                .reduce("", (first, second) -> first + second);
    }
}
