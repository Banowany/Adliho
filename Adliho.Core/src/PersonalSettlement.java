import java.util.HashMap;
import java.util.Map;

public class PersonalSettlement
{
    String who;
    Map<String, Money> howManyBackedAndToWhom;
    Money howManyPaid;

    public PersonalSettlement(String who, Money howManyPaid)
    {
        this.who = who;
        this.howManyBackedAndToWhom = new HashMap<>();
        this.howManyPaid = howManyPaid;
    }
}
