import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class BillTest
{
    private static class BillBuilder
    {
        public static Bill buildBill(Map<String, Money> existingExtractFromBill)
        {
            Bill bill = new Bill();
            Class billClass = Bill.class;
            try
            {
                Field extractField = billClass.getDeclaredField("whoAndHowManyPaid");
                extractField.setAccessible(true);
                extractField.set(bill, existingExtractFromBill);
            }
            catch (ReflectiveOperationException e)
            {
                throw new RuntimeException("Check Accessible and name of Field", e);
            }
            return bill;
        }
    }

    @Test
    void addNullPersonToBill()
    {
        Bill bill = new Bill();
        Money money = new Money(12, 99);
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            bill.addPersonToBill(null, money);
        });
    }

    @Test
    void addPersonWithNullMoneyToBill()
    {
        Bill bill = new Bill();
        String person = "Krzysztof";
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            bill.addPersonToBill(person, null);
        });
    }

    @Test
    void addNullNullPersonWithNullMoneyToBill()
    {
        Bill bill = new Bill();
        Assertions.assertThrows(NullPointerException.class, () ->
        {
            bill.addPersonToBill(null, null);
        });
    }

    @Test
    void addPersonToEmptyBill()
    {
        Bill bill = new Bill();
        String person = "Krzysztof";
        Money money = new Money(12, 99);

        Map<String, Money> expected = new HashMap<>();
        expected.put(person, money);

        bill.addPersonToBill(person, money);
        Assertions.assertEquals(expected, bill.getExtractFromBill());
    }

    @Test
    void addPersonToNonEmptyBill()
    {
        Map<String, Money> existingExtractFromBill = new HashMap<>();
        existingExtractFromBill.put("Krzysztof", new Money(12,99));
        Bill bill = BillBuilder.buildBill(existingExtractFromBill);

        String person = "Pawel";
        Money money = new Money(1, 98);

        Map<String, Money> expected = new HashMap<>(existingExtractFromBill);
        expected.put(person, money);

        bill.addPersonToBill(person, money);
        Assertions.assertEquals(expected, bill.getExtractFromBill());
    }
}