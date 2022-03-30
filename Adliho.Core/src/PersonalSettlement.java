import java.util.HashMap;
import java.util.Map;

public class PersonalSettlement
{
    String who;
    Map<String, Money> howManyToBackAndToWhom;
    Money howManyPaid;

    public PersonalSettlement(String who, Money howManyPaid)
    {
        this.who = who;
        this.howManyToBackAndToWhom = new HashMap<>();
        this.howManyPaid = howManyPaid;
    }

    public void addCollector(String name, Money howManyToBack)
    {
        if(name==null)
            throw new NullPointerException("Collector can not be null");
        if(howManyToBack==null)
            throw new NullPointerException("Money can not be null");
        if(howManyToBackAndToWhom.containsKey(name))
            throw new IllegalStateException("This collector is already exist in PersonalSettlement.");

        howManyToBackAndToWhom.put(name, howManyToBack);
    }
}
