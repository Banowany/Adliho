import java.util.Map;

public interface CalculatorForSettlement
{
    JointSettlement calculateSettlement(Map<String, Money> extractFromBill);
}
