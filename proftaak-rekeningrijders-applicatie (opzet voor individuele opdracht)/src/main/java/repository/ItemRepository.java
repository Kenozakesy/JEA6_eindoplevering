package repository;

import domain.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Stateless
public class ItemRepository {

   @PersistenceContext(unitName = "overheidPU")
   private EntityManager em;

   @Transactional(REQUIRED)
   public Item create(Item item) {
       em.persist(item);
       return item;
   }

   public List<Item> findAll() {
       return em.createQuery("SELECT i FROM Item i", Item.class)
                      .getResultList();
   }

   public Item find(Long id) {
       return em.find(Item.class, id);
   }

}