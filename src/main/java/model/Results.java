package model;

public class Results {


    private String id;
    private String site_id;
    private String title;
    private int price;
    private String currency_id;
    private boolean accepts_mercadopago;
    private Shipping shipping;

    public int getPrice() {
        return price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public boolean isAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public String getId() {
        return id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTitle() {
        return title;
    }

}
