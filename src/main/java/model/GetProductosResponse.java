package model;

import java.util.List;

public class GetProductosResponse {



    List<Results> results;
    Paging paging;

    public Paging getPaging() {
        return paging;
    }

    public List<Results> getResults() {
        return results;
    }

}
