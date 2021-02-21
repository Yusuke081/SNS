package com.example.demo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TweetDataRepository extends
JpaRepository<TweetData, Long>{

//void saveAndFlush(UserData userData);
	
//public List<TweetData> findByIdIsNotNullOrderByIdDesc();
//public List<TweetData> findByIdNot(long id);

}


