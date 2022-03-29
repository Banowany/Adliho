import java.util.HashMap;

public class Bill
{
    HashMap<String, Money> whoAndHowManyPaid;

    public Bill()
    {
        this.whoAndHowManyPaid = new HashMap<>();
    }
}
