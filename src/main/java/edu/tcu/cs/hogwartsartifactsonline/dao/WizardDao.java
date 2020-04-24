package edu.tcu.cs.hogwartsartifactsonline.dao;

import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WizardDao extends JpaRepository<Wizard, Integer> {
}
