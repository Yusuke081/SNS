package com.example.demo;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDataRepository extends
JpaRepository<UserData, Long>{

	
//public List<UserData> findByIdIsNotNullOrderByIdDesc();

//public UserData findOne(String user);


//public void saveAndFlush(TweetData tweetData);

}
