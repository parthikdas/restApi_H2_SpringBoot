package com.dbWork.demo.repository_DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbWork.demo.entity.UserData;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserData, Integer>{

}
