package com.example.demo;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TweetDataRepository extends
JpaRepository<TweetData, Long>{
	
public List<TweetData> findByIdIsNotNullOrderByIdDesc();
public List<TweetData> findByIdNot(long id);

}


