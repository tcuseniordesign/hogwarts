package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WizardService {
    private WizardDao wizardDao;
    private ArtifactDao artifactDao;

    public WizardService(WizardDao wizardDao, ArtifactDao artifactDao) {
        this.wizardDao = wizardDao;
        this.artifactDao = artifactDao;
    }

    public List<Wizard> findAll() {
        return wizardDao.findAll();
    }

    public Wizard findById(Integer id) {
        return wizardDao.findById(id).get();
    }

    public void save(Wizard wizard) {
        wizardDao.save(wizard);
    }

    public void update(Integer id, Wizard wizard) {
        wizard.setId(id);
        wizardDao.save(wizard);
    }

    public void deleteById(Integer id) {
        wizardDao.deleteById(id);
    }

    public void assignArtifact(Integer wizardId, String artifactId) {
        // find this artifact by id from DB
        Artifact artifactToBeAssigned = artifactDao.findById(artifactId).get();
        Wizard wizard = wizardDao.findById(wizardId).get();

        if(artifactToBeAssigned.getOwner() != null){
            artifactToBeAssigned.getOwner().removeArtifact(artifactToBeAssigned);
        }
        wizard.addArtifact(artifactToBeAssigned);
    }
}
