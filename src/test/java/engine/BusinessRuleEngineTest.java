package engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BusinessRuleEngineTest {

  @Test
  void shouldHaveNoRulesInitially() {
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

    assertEquals(0, businessRuleEngine.count());
  }

  @Test
  void shouldAddTwoActions() {
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

    businessRuleEngine.addAction(() -> {
    });
    businessRuleEngine.addAction(() -> {
    });

    assertEquals(2, businessRuleEngine.count());
  }

  @Test
  void shouldExecuteOneAction() {
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

    final Action mockAction = mock(Action.class);

    // When
    businessRuleEngine.addAction(mockAction);
    businessRuleEngine.run();

    // Then
    verify(mockAction).execute();

  }
}