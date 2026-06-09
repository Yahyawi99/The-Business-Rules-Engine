package engine;

interface Rule {
  void preform(Facts facts);
}

public class DefaultRule implements Rule {
  private final Condition condition;
  private final Action action;

  public DefaultRule(final Condition condition, final Action action) {
    this.condition = condition;
    this.action = action;
  }

  public void preform(Facts facts) {
    if (condition.evaluate(facts)) {
      action.execute(facts);
    }
  }
}
