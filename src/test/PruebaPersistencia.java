package test;

import java.time.LocalDate;
import modelo.*;

import jakarta.persistence.*;




public class PruebaPersistencia {
    public static void main(String[] args) {
     
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre_desk");
        EntityManager em = emf.createEntityManager();

        try {
          
            em.getTransaction().begin();

            Deportista d = new Deportista();
            d.setNombre("Pedro");
            d.setApellido("Quintana");
            d.setFechaNacimiento(LocalDate.now());
            d.setNickname("pquintana");
            d.setMail("q@q.com");
            d.setContrasena("1234");
            d.setEsProfesional(false);
            
            


       
            em.persist(d);

         
            em.getTransaction().commit();

           

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
