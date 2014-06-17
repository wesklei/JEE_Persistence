package com.br.me.model.persistence;

import com.br.me.model.Contato;
import com.br.me.model.factory.Factory;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wes
 */
public class ContatoDAOTest {

    public ContatoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class Dao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Contato contato = new Contato();
        contato.setCelular("123");
        contato.setEmail("email@mail.com");
        contato.setNome("nome contato");
        contato.setTelefone("555");
        contato.setEndereco("Rua dos testes");

        Dao contatoDao = Factory.getDaoInstace(HibernateUtil.getEntityManager(), Contato.class);

        Contato contatoInserted = (Contato) contatoDao.insert(contato);

        contatoDao.delete(contatoInserted);

        assertEquals(contato.getEmail(), contatoInserted.getEmail());
    }

    /**
     * Test of delete method, of class Dao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Dao contatoDao = Factory.getDaoInstace(HibernateUtil.getEntityManager(), Contato.class);

        Contato contato = new Contato();
        contato.setCelular("123");
        contato.setEmail("email@mail.com");
        contato.setNome("nome contato");
        contato.setTelefone("555");
        contato.setEndereco("Rua dos testes");

        Contato contatoInserted = (Contato) contatoDao.insert(contato);

        contatoDao.delete(contatoInserted);

        Contato contatoMustBeNull = (Contato) contatoDao.getObjectByID(contatoInserted.getId());

        assertEquals(contatoMustBeNull, null);

    }

    /**
     * Test of update method, of class Dao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");

        Dao contatoDao = Factory.getDaoInstace(HibernateUtil.getEntityManager(), Contato.class);

        Contato contato = new Contato();
        contato.setCelular("123");
        contato.setEmail("email@mail.com");
        contato.setNome("nome contato");
        contato.setTelefone("555");
        contato.setEndereco("Rua dos testes");

        contato = (Contato) contatoDao.insert(contato);

        String newName = "novo nome";
        contato.setNome(newName);

        contatoDao.update(contato);

        contatoDao.delete(contato);

        assertEquals(contato.getNome(), newName);

    }

    /**
     * Test of getAllAsList method, of class Dao.
     */
    @Test
    public void testGetAllAsList() {
        System.out.println("getAllAsList");
        Dao contatoDao = Factory.getDaoInstace(HibernateUtil.getEntityManager(), Contato.class);
        List<Contato> resultContato = contatoDao.getAllAsList();

        for (Contato contato : resultContato) {
            System.out.println("id: " + contato.getId() + "contato email=> " + contato.getEmail() + " nome: " + contato.getNome());
        }
    }

    /**
     * Test of getObjectByID method, of class Dao.
     */
    @Test
    public void testGetObjectByID() {
        System.out.println("getObjectByID");

        Dao contatoDao = Factory.getDaoInstace(HibernateUtil.getEntityManager(), Contato.class);

        Contato contato = new Contato();
        contato.setCelular("123");
        contato.setEmail("email@mail.com");
        contato.setNome("nome contato");
        contato.setTelefone("555");
        contato.setEndereco("Rua dos testes");

        contato = (Contato) contatoDao.insert(contato);

        Contato contatoById = (Contato) contatoDao.getObjectByID(contato.getId());

        contatoDao.delete(contatoById);
        assertEquals(contato, contatoById);
    }

    /**
     * Test of deleteAll method, of class Dao.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");

        Dao contatoDao = Factory.getDaoInstace(HibernateUtil.getEntityManager(), Contato.class);
        List<Contato> contatoToDelete = new ArrayList<Contato>();

        for (int i = 0; i < 5; i++) {
            Contato contato = new Contato();
            contato.setCelular("123");
            contato.setEmail("email@mail.com");
            contato.setNome("nome contato");
            contato.setTelefone("555");
            contato.setEndereco("Rua dos testes");

            contato = (Contato) contatoDao.insert(contato);

            contatoToDelete.add(contato);
        }

        contatoDao.deleteAll(contatoToDelete);

        //check if they are all deleted
        boolean allDeleted = true;
        for (Contato c : contatoToDelete) {
            Contato contato = (Contato) contatoDao.getObjectByID(c.getId());

            if (contato != null) {
                System.out.println("contato not deleted! " + contato.getId());
                allDeleted = false;
            }
        }
        
        if(!allDeleted){
            fail("Has contatos wich still in database");
        }
    }

}
