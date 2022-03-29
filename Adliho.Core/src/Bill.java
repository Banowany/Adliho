import java.util.HashMap;

public class Bill
{
    private final HashMap<String, Money> whoAndHowManyPaid;

    public Bill()
    {
        this.whoAndHowManyPaid = new HashMap<>();
    }
}
