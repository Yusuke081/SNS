package com.example.demo;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDataRepository extends
JpaRepository<UserData, Long>{
//public List<UserData> findByIdIsNotNullOrderByIdDesc();
//public List<UserData> findById(long id);

//public void saveAndFlush(TweetData tweetData);

}
