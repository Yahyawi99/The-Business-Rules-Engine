package engine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class InspectorTest {
  @Test
  public void inspectOneConditionEvaluatesTrue() {
    final Facts facts = new Facts();
    facts.addFacts("jobTitle", "CEO");

    final ConditionalAction conditionalAction = new JobTitleCondition();

    final Inspector inspector = new Inspector(conditionalAction);
    final List<Report> reportList = inspector.inspect(facts);

    assertEquals(1, reportList.size());
    assertEquals(true, reportList.get(0).isPositive());

  }

  private static class JobTitleCondition implements ConditionalAction {
    @Override
    public void perform(Facts facts) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean evaluate(Facts facts) {
      return "CEO".equals(facts.getFacts("jobTitle"));
    }

  }

}
