package edu.bo.ucb.express_app.Models;

import java.util.ArrayList;

/**
 * Created by Alfred Garcia on 08/12/22.
 * Copyright © 2016 comadreja.hitler. All rights reserved.
 */

public class PokemonRespuesta {

    private ArrayList<Pokemon> results;
    public ArrayList<Pokemon> getResults() {
        return results;
    }
    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
