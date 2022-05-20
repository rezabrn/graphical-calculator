package ir.ac.kntu.logic;

public class numberWraper {
    private int number;

    public numberWraper() {
        number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number + "";
    }
}
