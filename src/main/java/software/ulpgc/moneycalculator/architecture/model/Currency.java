package software.ulpgc.moneycalculator.architecture.model;

public class Currency {
    private final String name;
    private final String code;

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name +"-"+ code;
    }
}
