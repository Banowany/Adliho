import java.util.HashMap;
import java.util.Map;

public class Bill
{
    private final Map<String, Money> whoAndHowManyPaid;

    public Bill()
    {
        this.whoAndHowManyPaid = new HashMap<>();
    }
}
