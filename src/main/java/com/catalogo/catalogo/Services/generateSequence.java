/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.DatabaseSequence;
import static com.mongodb.client.model.Filters.where;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.query.BasicQuery;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author figue
 */
@Service
public class generateSequence {
    @Autowired
    private MongoOperations mongo;
    
    public int generateSequence(String seqName) {
        String query="{_id : '"+ seqName +"'}";
        BasicQuery query1 = new BasicQuery(query);

    DatabaseSequence counter;
        counter = mongo.findAndModify(query1,
                new Update().inc("count",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
    return !Objects.isNull(counter) ? counter.getCount():1;
}
}
