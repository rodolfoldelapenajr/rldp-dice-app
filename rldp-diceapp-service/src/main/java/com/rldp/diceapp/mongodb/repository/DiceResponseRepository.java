package com.rldp.diceapp.mongodb.repository;

import org.springframework.stereotype.Repository;

import com.rldp.diceapp.model.DiceResponse;

@Repository
public class DiceResponseRepository extends CommonRepository<DiceResponse, String> {

    private static final String ID = "_id";

    public DiceResponseRepository() {
        super(DiceResponse.class, ID);
    }
    
}
