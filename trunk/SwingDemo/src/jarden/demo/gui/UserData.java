package jarden.demo.gui;

/**
 * A ValueObject class to pass data between the GUI and the Agent
 * @author GBEVVH8
 *
 */
public class UserData {

    private String name;
    private String address;
    private String yearsOfJava;
    private String stockCode;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStockCode() {
        return stockCode;
    }
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
    public String getYearsOfJava() {
        return yearsOfJava;
    }
    public void setYearsOfJava(String yearsOfJava) {
        this.yearsOfJava = yearsOfJava;
    }
    @Override
    public String toString() {
        return name+": "+address+" : ("+yearsOfJava+" years of Java) : stock ticker symbol <"+stockCode+">";
     
    }
    
}
