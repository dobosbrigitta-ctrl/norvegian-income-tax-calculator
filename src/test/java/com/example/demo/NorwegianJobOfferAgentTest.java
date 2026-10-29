
package com.example.demo;

public class NorwegianJobOfferAgentTest {

    public static void main(String[] args) {
        NorwegianJobOfferAgentService agent =
                new NorwegianJobOfferAgentService();

        String answer = agent.askAgent(
                "I am comparing two junior Java developer job offers in Norway. "
                        + "What information do you need to compare them responsibly? "
                        + "Do not invent salary or tax figures."
        );

        System.out.println("=== AGENT RESPONSE ===");
        System.out.println(answer);
    }
}
