/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.semanticweb_1.jena;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;;

/**
 *
 * @author Gradoboev
 */
public class ModelNewResource {
    
    public static void create(String givenName, String familyName){
    String personURI = "https://somewhere/"+givenName+familyName;
    String fullName = givenName+" "+familyName;
            
    Resource KarlMarx = RDF.model.createResource(personURI);

        // add the property
        KarlMarx.addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N,
                        RDF.model.createResource()
                                .addProperty(VCARD.Given, givenName)
                                .addProperty(VCARD.Family, familyName));
    }
    
}
