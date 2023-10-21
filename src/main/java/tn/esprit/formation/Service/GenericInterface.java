package tn.esprit.formation.Service;

import java.util.List;

public interface GenericInterface <T>{




    List<T> lister();




    void delete(Long id);



}
