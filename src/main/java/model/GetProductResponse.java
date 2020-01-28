package model;

public class GetProductResponse {

    private String title;
    private int price;
    private boolean accepts_mercadopago;
    private String currency_id;
    private Shipping shipping;

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }


    public boolean isAccepts_mercadopago() {
        return accepts_mercadopago;
    }


    public String getCurrency_id() {
        return currency_id;
    }

    public Shipping getShipping() {
        return shipping;
    }

}
