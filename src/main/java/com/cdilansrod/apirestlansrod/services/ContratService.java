package com.cdilansrod.apirestlansrod.services;

import com.cdilansrod.apirestlansrod.dto.ContratDTO;
import com.cdilansrod.apirestlansrod.entities.Contrat;
import com.cdilansrod.apirestlansrod.entities.Salarie;
import com.cdilansrod.apirestlansrod.repositories.ContratRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Salarie}.
 */
@Service
@Transactional
public class ContratService {

    private final Logger log = LoggerFactory.getLogger(ContratService.class);
    private final ContratRepository contratRepository;

    public ContratService(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    /**
     * Enregistrer un employé.
     * @param contratDTO l'entité à enregistre.
     * @return l'entité persisté.
     */
    public Contrat save(ContratDTO contratDTO) {
        log.debug("Requête pour enregistere un Salarié : {}", contratDTO);
        Contrat newContrat= new Contrat();
        newContrat.setNom(contratDTO.getNom());
        newContrat.setDescription(contratDTO.getDescription());
        contratRepository.save(newContrat);
        return newContrat;
    }

    /**
     * Modifier un employé.
     * @param contratDTO l'entité à modifier.
     * @return l'entité persisté.
     */
    public Optional<ContratDTO> updateContrat(ContratDTO contratDTO) {
        return Optional.of(contratRepository
                .findById(contratDTO.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(contrat -> {
                    contrat.setDescription(contratDTO.getDescription());
                    contrat.setNom(contratDTO.getNom());
                    log.debug("Les informations modifiées du salarié: {}", contrat);
                    return contrat;
                })
                .map(ContratDTO::new);
    }

    /**
     * Get one salarie by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Contrat> findOne(Long id) {
        log.debug("Request to get Salarie : {}", id);
        return contratRepository.findById(id);
    }


    /**
     * Get all the salaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Contrat> findAll(Pageable pageable) {
        log.debug("Request to get all Salaries");
        return contratRepository.findAll(pageable);
    }




    /**
     * Delete the salarie by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Salarie : {}", id);
        contratRepository.deleteById(id);
    }

}
