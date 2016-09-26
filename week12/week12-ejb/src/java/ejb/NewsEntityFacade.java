/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author najus
 */

@Stateless
public class NewsEntityFacade extends AbstractFacade<NewsEntity> {
    @PersistenceContext(unitName = "week12-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsEntityFacade() {
        super(NewsEntity.class);
    }
    
}
