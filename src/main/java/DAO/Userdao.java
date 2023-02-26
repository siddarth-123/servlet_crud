package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.userinfo;

public class Userdao{

EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
EntityManager manager = factory.createEntityManager();
EntityTransaction transaction = manager.getTransaction();

public void save(userinfo info) {
transaction.begin();
manager.persist(info);
transaction.commit();
}
public userinfo fetch(long mobile){
List<userinfo> list=manager.createQuery("select x from userinfo x where mobile=?1").setParameter(1, mobile).getResultList();
if(list.isEmpty())
{
return null;
}else{
return list.get(0);
}
}
public userinfo fetch(String email){
List<userinfo> list=manager.createQuery("select x from userinfo x where email=?1").setParameter(1, email).getResultList();
if(list.isEmpty())
{
return null;
}else{
return list.get(0);
}
}

}