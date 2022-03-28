public class Money
{
    int buck;
    int pennis;

    public Money(int buck, int pennis)
    {
        this.buck = buck;
        this.pennis = pennis;
    }

    @Override
    public String toString()
    {
        return String.format("%d.%d",buck, pennis);
    }
}
