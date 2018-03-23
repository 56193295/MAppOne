package mnls.com.mappone;

public class Bean {

    /*数据对应字段*/

    private String price;
    private String number;

    public Bean(String price, String number) {
        this.price = price;
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
