/**
 * 
 */
package software.jsj.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import software.jsj.petclinic.model.Specialty;
import software.jsj.petclinic.repositories.SpecialtyRepository;
import software.jsj.petclinic.services.SpecialtyService;

/**
 * @author jsjackson
 *
 */
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

  private final SpecialtyRepository specialtyRepository;
  
  public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
    this.specialtyRepository = specialtyRepository;
  }

  @Override
  public Set<Specialty> findAll() {
    
    Set<Specialty> specialties = new HashSet<>();
    specialtyRepository.findAll().forEach(specialties::add);
    return specialties;
  }

  @Override
  public Specialty findById(Long id) {
    return specialtyRepository.findById(id).orElse(null);
  }

  @Override
  public Specialty save(Specialty object) {
    return specialtyRepository.save(object);
  }

  @Override
  public void delete(Specialty object) {
    specialtyRepository.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    specialtyRepository.deleteById(id);
  }

}
