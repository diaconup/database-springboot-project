package net.javaguides.Project.service;

import net.javaguides.Project.model.Skills;
import org.springframework.stereotype.Service;

@Service
public interface SkillsService {
    void saveSkills(Skills skills);
    Skills getSkillsById(long id);
}
