package test.entity;

import by.bsu.game.entity.Composite;
import by.bsu.game.entity.Unit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompositeTest {
    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        Unit orc1 = new Unit("Uruk", 100, 20, 5);
        Unit orc2 = new Unit("Tarrok", 250, 30, 5);
        Unit human1 = new Unit("Alexandr", 50, 10, 0);
        Composite orcSquad = new Composite();
        orcSquad.add(orc1);
        orcSquad.add(orc2);
        Composite orcArmy = new Composite();
        orcArmy.add(orcSquad);
        Composite humanSquad = new Composite();
        humanSquad.add(human1);
        Composite expectedHumanSquad = new Composite();
        Composite expectedOrcSquad = new Composite();
        Composite expectedOrcArmy = new Composite();
        expectedOrcSquad.add(new Unit("Uruk", 95, 20, 5));
        expectedOrcSquad.add(orc2);
        expectedOrcArmy.add(expectedOrcSquad);
        return new Object[][]{{humanSquad, orcArmy, expectedOrcArmy},
                {orcArmy, humanSquad, expectedHumanSquad}};
    }
    @Test (dataProvider = "data-provider")
    public void battleTest(final Composite attacker, final Composite defender,
                           final Composite expectedDefenderResult) {
        attacker.attack(defender);
        Assert.assertEquals(defender, expectedDefenderResult);
    }

}
