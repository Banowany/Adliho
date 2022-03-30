import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class PersonalSettlementTest
{
    private static class PersonalSettlementBuilder
    {
        public static PersonalSettlement buildPersonalSettlement(String personName,
                                                                 Map<String, Money> existingCollectors,
                                                                 Money howManyPaid)
        {
            PersonalSettlement personalSettlement = new PersonalSettlement(personName, howManyPaid);
            Class personalSettlementClass = PersonalSettlement.class;
            try
            {
                Field extractField = personalSettlementClass.getDeclaredField("howManyToBackAndToWhom");
                extractField.setAccessible(true);
                extractField.set(personalSettlement, existingCollectors);
            }
            catch (ReflectiveOperationException e)
            {
                throw new RuntimeException("Check Accessible and name of Field", e);
            }
            return personalSettlement;
        }
    }

    @Test
    void addNullCollectorToPersonalSettlement()
    {
        PersonalSettlement personalSettlement = new PersonalSettlement("Krzysztof", new Money(12,99));
        Money moneyToBack = new Money(1, 99);
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            personalSettlement.addCollector(null, moneyToBack);
        });
    }

    @Test
    void addCollectorWithNullMoneyToPersonalSettlement()
    {
        PersonalSettlement personalSettlement = new PersonalSettlement("Krzysztof", new Money(12,99));
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            personalSettlement.addCollector("Pawel", null);
        });
    }

    @Test
    void addNullNullCollectorWithNullMoneyToPersonalSettlement()
    {
        PersonalSettlement personalSettlement = new PersonalSettlement("Krzysztof", new Money(12,99));
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            personalSettlement.addCollector(null, null);
        });
    }

    @Test
    void addCollectorToEmptyPersonalSettlement()
    {
        PersonalSettlement personalSettlement = new PersonalSettlement("Krzysztof", new Money(12,99));
        String collector = "Pawel";
        Money money = new Money(1, 99);

        Map<String, Money> expected = new HashMap<>();
        expected.put(collector, money);

        personalSettlement.addCollector(collector, money);
        Assertions.assertEquals(expected, personalSettlement.getExtract());
    }

    @Test
    void addCollectorToNonEmptyPersonalSettlement()
    {
        Map<String, Money> existingCollectors = new HashMap<>();
        existingCollectors.put("Pawel", new Money(1,99));
        PersonalSettlement personalSettlement = PersonalSettlementBuilder.buildPersonalSettlement
                ("Krzysztof", existingCollectors, new Money(12, 99));

        String collector = "Izabela";
        Money money = new Money(2, 98);

        Map<String, Money> expected = new HashMap<>(existingCollectors);
        expected.put(collector, money);

        personalSettlement.addCollector(collector, money);
        Assertions.assertEquals(expected, personalSettlement.getExtract());
    }
}