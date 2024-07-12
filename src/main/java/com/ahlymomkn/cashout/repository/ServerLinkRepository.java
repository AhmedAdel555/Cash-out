package com.ahlymomkn.cashout.repository;


import com.ahlymomkn.cashout.model.entity.ServerLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerLinkRepository extends JpaRepository<ServerLink,Integer> {

}
