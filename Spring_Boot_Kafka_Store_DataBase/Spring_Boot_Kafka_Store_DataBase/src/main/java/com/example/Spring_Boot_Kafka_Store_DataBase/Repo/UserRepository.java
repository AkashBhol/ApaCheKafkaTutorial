package com.example.Spring_Boot_Kafka_Store_DataBase.Repo;

import com.example.Spring_Boot_Kafka_Store_DataBase.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
