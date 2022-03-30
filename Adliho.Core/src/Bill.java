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

    public void addPersonToBill(String who, Money howManyPaid)
    {
        if(who==null)
            throw new NullPointerException("Peson can not be null");
        if(howManyPaid==null)
            throw new NullPointerException("Money can not be null");
        if(whoAndHowManyPaid.containsKey(who))
            throw new IllegalStateException("This person is already exist in Bill");

        whoAndHowManyPaid.put(who, howManyPaid);
    }

    public Map getExtractFromBill()
    {
        return Collections.unmodifiableMap(whoAndHowManyPaid);
    }
}
