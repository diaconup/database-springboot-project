package net.javaguides.Project.service;

import net.javaguides.Project.model.Skills;
import net.javaguides.Project.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SkillsServiceImpl implements SkillsService{
    @Autowired
    private SkillsRepository skillsRepository;
    @Override
    public void saveSkills(Skills skills){
        this.skillsRepository.save(skills);
    }
    @Override
    public Skills getSkillsById(long id){
        Optional<Skills> optional = skillsRepository.findById(id);
        Skills skills = null;
        if(optional.isPresent()){
            skills = optional.get();
        }else {
            throw new RuntimeException("Animal not found for id :: " + id);
        }
        return skills;
    }
}
