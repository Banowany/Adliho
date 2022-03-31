import java.util.*;

public class BillParameters
{
    private Money averageAmount;
    private Map<String, Money> lossyPeopleWithTheirLoss;
    private Map<String, Money> nonLossyPeopleWithTheirDept;

    private BillParameters(){}

    private void countAndSetAverageAmount(Map<String, Money> extractFromBill)
    {
        int averageInPennis=0;

        Set<String> people = extractFromBill.keySet();
        for(String per : people)
        {
            averageInPennis+=extractFromBill.get(per).getMoneyInPennis();
        }
        averageInPennis/=people.size();
        this.averageAmount = new Money(averageInPennis/100, averageInPennis%100);
    }

    private void findAndSetLossyPeopleWithTheirLoss(Map<String, Money> extractFromBill)
    {
        Map<String, Money> lossyPeopleWithTheirLoss = new HashMap<>();

        int lossInPennis;
        Set<String> people = extractFromBill.keySet();
        for(String per : people)
        {
            if(extractFromBill.get(per).getMoneyInPennis()>averageAmount.getMoneyInPennis())
            {
                lossInPennis=extractFromBill.get(per).getMoneyInPennis()-averageAmount.getMoneyInPennis();
                lossyPeopleWithTheirLoss.put(per, new Money(lossInPennis/100, lossInPennis%100));
            }
        }
        this.lossyPeopleWithTheirLoss=lossyPeopleWithTheirLoss;
    }

    private void findAndSetNonLossyPeopleWithTheirDept(Map<String, Money> extractFromBill)
    {
        Map<String, Money> nonLossyPeopleWithTheirDept = new HashMap<>();

        int deptInPennis;
        Set<String> people = extractFromBill.keySet();
        for(String per : people)
        {
            if(extractFromBill.get(per).getMoneyInPennis()<averageAmount.getMoneyInPennis())
            {
                deptInPennis=averageAmount.getMoneyInPennis()-extractFromBill.get(per).getMoneyInPennis();
                nonLossyPeopleWithTheirDept.put(per, new Money(deptInPennis/100, deptInPennis%100));
            }
        }
        this.nonLossyPeopleWithTheirDept=nonLossyPeopleWithTheirDept;
    }

    public static BillParameters getParameters(Bill bill)
    {
        BillParameters billParameters = new BillParameters();
        billParameters.countAndSetAverageAmount(bill.getExtractFromBill());
        billParameters.findAndSetLossyPeopleWithTheirLoss(bill.getExtractFromBill());
        billParameters.findAndSetNonLossyPeopleWithTheirDept(bill.getExtractFromBill());
        return billParameters;
    }
}
