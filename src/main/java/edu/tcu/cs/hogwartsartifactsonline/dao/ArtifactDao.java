package edu.tcu.cs.hogwartsartifactsonline.dao;

import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactDao extends JpaRepository<Artifact, String> {
}
