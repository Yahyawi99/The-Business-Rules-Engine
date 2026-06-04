package engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BusinessRuleEngineTest {

  @Test
  void shouldHaveNoRulesInitially() {
    final Facts mockFacts = mock(Facts.class);

    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    assertEquals(0, businessRuleEngine.count());
  }

  @Test
  void shouldAddTwoActions() {
    final Facts mockFacts = mock(Facts.class);
    final Action mockAction = mock(Action.class);

    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    businessRuleEngine.addAction(mockAction);
    businessRuleEngine.addAction(mockAction);

    assertEquals(2, businessRuleEngine.count());
  }

  @Test
  void shouldExecuteAnActionWithFacts() {
    final Action mockAction = mock(Action.class);
    final Facts mockFacts = mock(Facts.class);

    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    // When
    businessRuleEngine.addAction(mockAction);
    businessRuleEngine.run();

    // Then
    verify(mockAction).execute(mockFacts);

  }
}