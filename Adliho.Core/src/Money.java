public class Money
{
    private final int buck;
    private final int pennis;

    public Money(int buck, int pennis)
    {
        //TODO: check correction of arguments in constructor
        this.buck = buck;
        this.pennis = pennis;
    }

    public int getMoneyInPennis()
    {
        return buck*100+pennis;
    }

    @Override
    public String toString()
    {
        return String.format("%d.%d",buck, pennis);
    }
}
