/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.garage48.client.service.AddExpenseService;
import com.garage48.server.domain.Expense;
import com.garage48.server.domain.PMF;
import com.garage48.shared.ExpensesDTO;
import javax.jdo.PersistenceManager;

/**
 *
 * @author Administrator
 */
public class AddExpenseServiceImpl extends RemoteServiceServlet implements AddExpenseService {
    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }

    @Override
    public Boolean createNewExpense(ExpensesDTO expensesdto){
        Expense expenses = new Expense();
        expenses.setItem(expensesdto.getItem());
        expenses.setDescription(expensesdto.getDescription());
        expenses.setPrice(expensesdto.getPrice());
        expenses.setAddress(expensesdto.getAddress());

        /*Entity[] entities = blobstoredaoimpl.getBlobstoreEntity();
        log.info("createNewListing(), Entity is " + entities);

        for (int i=0; i < entities.length; i++) {
          long id = entities[i].getKey().getId();
          key = entities[i].getKey();
          contentType = (String) entities[i].getProperty("content_type");
          fileName = (String) entities[i].getProperty("filename");
          size = (Long) entities[i].getProperty("size");
          creation = (Date) entities[i].getProperty("creation");
        }*/
        /*listingfile.setKeyString(listingsentity.getkey().toString());
        listingfile.setContentType(contentType);
        listingfile.setFilename(fileName);
        listingfile.setSize(size);
        listingfile.setCreation(creation);*/

        //listingsentity.setListingfile(listingfile);

        //listingsentity.setBlobKeyString(key.toString());

        boolean added = false;
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(expenses);
            added = true;
        }
        finally {
            pm.close();
        }
        return added;
    }
}
