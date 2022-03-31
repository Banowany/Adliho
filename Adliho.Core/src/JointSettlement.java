import java.util.ArrayList;
import java.util.List;

public class JointSettlement
{
    List<PersonalSettlement> debtors;

    public JointSettlement()
    {
        this.debtors = new ArrayList<>();
    }

    private boolean isDebtorIncludeInJointSettlement(String name)
    {
        for(PersonalSettlement ps : debtors)
        {
            if(ps.getWho().equals(name))
                return true;
        }
        return false;
    }

    public void addPersonalSettlement(PersonalSettlement personalSettlement)
    {
        if(personalSettlement==null)
        {
            throw new NullPointerException("personalSettlement can not be null");
        }
        if(isDebtorIncludeInJointSettlement(personalSettlement.getWho()))
        {
            throw new IllegalStateException("This person already have personal settlement in joint settlement");
        }

        debtors.add(personalSettlement);
    }
}
