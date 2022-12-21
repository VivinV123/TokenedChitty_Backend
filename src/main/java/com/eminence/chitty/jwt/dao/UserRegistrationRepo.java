package com.eminence.chitty.jwt.dao;
import com.eminence.chitty.jwt.entity.UserRegistration;
//import com.experion.mainbackend.entity.UserRegistration;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "userprofile",path="user-details")
@DynamicUpdate
public interface UserRegistrationRepo extends JpaRepository<UserRegistration,Long>
{
}
