package az.online.shop.dao;

import az.online.shop.entity.PersonalInfo;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalInfoRepository extends RepositoryBase<Integer, PersonalInfo> {

    public PersonalInfoRepository(EntityManager entityManager) {
        super(PersonalInfo.class, entityManager);
    }
}