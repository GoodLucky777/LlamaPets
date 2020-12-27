package net.lldv.llamapets.components.provider.data.connection;

import net.lldv.llamapets.components.provider.data.Collection;
import net.lldv.llamapets.components.provider.data.CollectionFields;
import net.lldv.llamapets.components.provider.data.UDocument;
import net.lldv.llamapets.components.provider.data.UDocumentSet;
import net.lldv.llamapets.components.provider.data.clientdetails.ClientDetails;

/**
 * @author LlamaDevelopment
 * @project UniversalClient
 * @website http://llamadevelopment.net/
 */
public class Connection {

    public void connect(final ClientDetails details) throws Exception {
    }

    public void disconnect() {
    }

    public void createCollection(String name, CollectionFields columns) {
    }

    public void createCollection(String collection, String primaryKey, CollectionFields fields) {
    }

    public void update(String collection, UDocument search, UDocument updates) {
    }

    public void update(String collection, String searchKey, final Object searchValue, UDocument updates) {
    }

    public void insert(String collection, UDocument values) {
    }

    public void delete(String collection, UDocument search) {
    }

    public void delete(String collection, String key, Object value) {
    }

    public UDocumentSet find(String collection, UDocument search) {
        return null;
    }

    public UDocumentSet find(String collection, String key, Object value) {
        return null;
    }

    public UDocumentSet find(final String collection) {
        return null;
    }

    public Collection getCollection(String collection) {
        return new Collection(this, collection);
    }

}
