package com.cdilansrod.apirestlansrod.services;

import com.cdilansrod.apirestlansrod.dto.EntrepriseDTO;
import com.cdilansrod.apirestlansrod.entities.Entreprise;
import com.cdilansrod.apirestlansrod.repositories.EntrepriseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Entreprise}.
 */
@Service
@Transactional
public class EntrepriseService {

    private final Logger log = LoggerFactory.getLogger(EntrepriseService.class);
    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    /**
     * Enregistrer une entreprise.
     * @param entrepriseDTO l'entité à enregistrer.
     * @return L'entité persisté.
     */
    public Entreprise save(EntrepriseDTO entrepriseDTO) {
        log.debug("Requête pour enregistrer une Entreprise : {}", entrepriseDTO);
        Entreprise newEntreprise = new Entreprise();
        newEntreprise.setSiren(entrepriseDTO.getSiren());
        newEntreprise.setSiret(entrepriseDTO.getSiret());
        newEntreprise.setAdresse(entrepriseDTO.getAdresse());
        newEntreprise.setRaisonSociale(entrepriseDTO.getRaisonSociale());
        entrepriseRepository.save(newEntreprise);
        return newEntreprise;
    }

    /**
     * Modifier une entreprise.
     * @param entrepriseDTO l'entité à modifier.
     * @return l'entité persisté.
     */
    public Optional<EntrepriseDTO> updateEntreprise(EntrepriseDTO entrepriseDTO) {
        return Optional.of(entrepriseRepository
                .findById(entrepriseDTO.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(entreprise -> {
                    entreprise.setRaisonSociale(entrepriseDTO.getRaisonSociale());
                    entreprise.setAdresse(entrepriseDTO.getAdresse());
                    entreprise.setSiret(entrepriseDTO.getSiret());
                    entreprise.setSiren(entrepriseDTO.getSiren());
                    log.debug("Les informations modifiées de l'entreprise: {}", entreprise);
                    return entreprise;
                })
                .map(EntrepriseDTO::new);
    }

    /**
     * Get one entreprise by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Entreprise> findOne(Long id) {
        log.debug("Request to get Entreprise : {}", id);
        return entrepriseRepository.findById(id);
    }

    /**
     * Get all the entreprises.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Entreprise> findAll(Pageable pageable) {
        log.debug("Request to get all Entreprises");
        return entrepriseRepository.findAll(pageable);
    }



    /**
     * Delete the entreprise by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Entreprise : {}", id);
        entrepriseRepository.deleteById(id);
    }
}
