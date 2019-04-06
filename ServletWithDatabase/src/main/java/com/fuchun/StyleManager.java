package com.fuchun;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

//style manager for different methods

@Stateless
public class StyleManager {

    private EntityManager manager;
    private static final String PERSISTENCE_UNIT_NAME = "clothItem_pu";
    public static int ID_COUNT = 0;

    public StyleManager() {
        manager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    //add a new cloth
    public void addClothesItem(ClothesItem clothesItem) {
        manager.getTransaction().begin();
        manager.persist(clothesItem);
        manager.getTransaction().commit();
    }

    //delete a cloth
    public void deleteClothesItem(int id) {
        manager.getTransaction().begin();
        manager.remove(getClothesItem(id));
        manager.getTransaction().commit();
    }

    //update an exist cloth
    public void updateClothesItem(ClothesItem clothesItem) {
        manager.getTransaction().begin();
        manager.merge(clothesItem);
        manager.getTransaction().commit();
    }

    //get one specific item
    public ClothesItem getClothesItem(int id) {
        ClothesItem clothesItem = manager.find(ClothesItem.class, id);
        if (clothesItem == null) {
            throw new EntityNotFoundException("Can't find Knight for ID ");
        }
        return clothesItem;
    }

    //get all clothes
    public List<ClothesItem> getClothesItemList() {
        Query query = manager.createQuery("SELECT clothesItems from ClothesItem clothesItems");
        return query.getResultList();
    }
}
