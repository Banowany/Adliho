import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bill
{
    private final Map<String, Money> whoAndHowManyPaid;

    public Bill()
    {
        this.whoAndHowManyPaid = new HashMap<>();
    }

    public void addPersonToBill(String name, Money howManyPaid)
    {
        if(name==null)
            throw new NullPointerException("Peson can not be null");
        if(howManyPaid==null)
            throw new NullPointerException("Money can not be null");
        if(whoAndHowManyPaid.containsKey(name))
            throw new IllegalStateException("This person is already exist in Bill");

        whoAndHowManyPaid.put(name, howManyPaid);
    }

    public Map<String, Money> getExtractFromBill()
    {
        return Collections.unmodifiableMap(whoAndHowManyPaid);
    }
}
