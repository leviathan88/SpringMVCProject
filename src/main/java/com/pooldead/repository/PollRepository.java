package com.pooldead.repository;

import org.springframework.data.repository.CrudRepository;
import com.pooldead.domain.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {

}
