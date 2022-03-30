import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BillTest
{
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
}