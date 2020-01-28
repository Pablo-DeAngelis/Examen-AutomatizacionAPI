import model.GetProductResponse;
import model.GetProductosResponse;
import org.testng.annotations.Test;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

public class ExamenAutomatizacionAPI {

    @Test
    public void TestAPI(){
        RestTemplate restTemplate = new RestTemplate();
        String VALOR_A_BUSCAR = "Stanley";
        String url = "https://api.mercadolibre.com/sites/MLA/search?q=";


        GetProductosResponse getProductosResponse = restTemplate.getForObject(url + VALOR_A_BUSCAR, GetProductosResponse.class);

        //Obtengo la cantidad total de productos
        System.out.println("Cantidad de productos obtenidos: " + getProductosResponse.getPaging().getTotal());
        //Verifico si la cantidad obtenida no rompe el paginado
        Assert.assertEquals(getProductosResponse.getResults().size(),getProductosResponse.getPaging().getLimit());
        System.out.println("Cantidad de productos permitido en el paginado: " + getProductosResponse.getPaging().getLimit());

        //Obtengo un numero random para ingresar a un producto
        int ProdRandom = (int) (Math.random() * getProductosResponse.getPaging().getLimit());

        String urlProduct = "https://api.mercadolibre.com/items/";

        //Obtengo el codigo de producto en la posicion random
        String ID_PRODUCTO = getProductosResponse.getResults().get(ProdRandom).getId();
        System.out.println("ID OBTENIDO: " + ID_PRODUCTO);

        GetProductResponse getProductResponse = restTemplate.getForObject(urlProduct + ID_PRODUCTO, GetProductResponse.class);


        System.out.println(getProductResponse.getTitle());
        //Verifico si los titulos sin iguales
        Assert.assertEquals(getProductosResponse.getResults().get(ProdRandom).getTitle(),getProductResponse.getTitle());

        //Verifico precio
        Assert.assertEquals(getProductResponse.getPrice(),getProductosResponse.getResults().get(ProdRandom).getPrice());
        System.out.println("El precio del producto es: $" + getProductResponse.getPrice() );

        //Verifico si acepta mercadopago
        Assert.assertEquals(getProductResponse.isAccepts_mercadopago(),getProductosResponse.getResults().get(ProdRandom).isAccepts_mercadopago());
        System.out.println("Acepta MercadoPago: " + getProductResponse.isAccepts_mercadopago() );

        //Verifico la moneda
        Assert.assertEquals(getProductResponse.getCurrency_id(),getProductosResponse.getResults().get(ProdRandom).getCurrency_id());
        System.out.println("Moneda: " + getProductResponse.getCurrency_id() );

        //Verifico si el envio es gratis
        Assert.assertEquals(getProductResponse.getShipping().isFree_shipping(),getProductosResponse.getResults().get(ProdRandom).getShipping().isFree_shipping());
        System.out.println("Envio gratis: " + getProductResponse.getShipping().isFree_shipping());
    }

}
