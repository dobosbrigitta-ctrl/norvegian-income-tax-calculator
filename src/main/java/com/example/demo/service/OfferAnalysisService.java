
package com.example.demo.service;

import com.example.demo.NorwegianJobOfferAgentService;
import org.springframework.stereotype.Service;

@Service
public class OfferAnalysisService {

    private final NorwegianJobOfferAgentService agentService;

    public OfferAnalysisService(
            NorwegianJobOfferAgentService agentService) {
        this.agentService = agentService;
    }

    public String analyzeOffers(
            long grossSalaryA,
            long monthlyNetA,
            long remainingA,
            long grossSalaryB,
            long monthlyNetB,
            long remainingB) {

        String prompt = """
                You are an assistant comparing two Norwegian job offers.

                The following figures were calculated by a Java application.
                Treat them as supplied data. Do not recalculate taxes or invent
                missing benefits or expenses.

                Offer A:
                Annual gross salary: %d NOK
                Estimated monthly net salary: %d NOK
                Monthly money remaining after stated costs: %d NOK

                Offer B:
                Annual gross salary: %d NOK
                Estimated monthly net salary: %d NOK
                Monthly money remaining after stated costs: %d NOK

                Explain in clear, concise English:
                1. Which offer leaves more money each month after the
                   stated costs, and by how much.
                2. Why the higher gross salary does not necessarily mean
                   a better financial outcome.
                3. What missing information could affect the comparison.

                Do not claim that either offer is universally better.
                State that the net figures are estimates.
                """.formatted(
                grossSalaryA, monthlyNetA, remainingA,
                grossSalaryB, monthlyNetB, remainingB
        );

        return agentService.askAgent(prompt);
    }
}
