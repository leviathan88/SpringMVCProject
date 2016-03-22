package com.pooldead.repository;

import org.springframework.data.repository.CrudRepository;

import com.pooldead.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

}
