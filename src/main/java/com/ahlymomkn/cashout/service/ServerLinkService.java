package com.ahlymomkn.cashout.service;

import com.ahlymomkn.cashout.model.entity.ServerLink;
import org.springframework.stereotype.Service;

@Service
public interface ServerLinkService {
    ServerLink updateServerLink(Integer id, String newLink);
    String getServerLink(Integer id);

}
