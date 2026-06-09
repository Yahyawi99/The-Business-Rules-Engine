package engine;

public class Application {

  public Application() {
    final Facts mockfacts = new Facts();
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockfacts);

    businessRuleEngine.addRule(facts -> {
      var dealStage = Stage.valueOf(facts.getFacts("stage"));
      var amount = Double.parseDouble(facts.getFacts("amount"));

      var forecastedAmount = amount * switch (dealStage) {
        case LEAD -> 0.2;
        case EVALUATING -> 0.5;
        case INTERESTED -> 0.8;
        case CLOSED -> 1;
      };

      facts.addFacts("forecastedAmount", String.valueOf(forecastedAmount));
    });

    // Builder pattern
    mockfacts.addFacts("jobTitle", "CEO");
    mockfacts.addFacts("name", "YY");

    final Rule ruleSendEmailToSalesWhenCEO = RuleBuilder
        .when(facts -> "CEO".equals(mockfacts.getFacts("jobTitle")))
        .then(facts -> {
          facts.getFacts("name");
          // send mail using the name
        });

  }

}
