package edu.tcu.cs.hogwartsartifactsonline.service;

import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WizardService {
    private WizardDao wizardDao;

    public WizardService(WizardDao wizardDao) {
        this.wizardDao = wizardDao;
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

}
