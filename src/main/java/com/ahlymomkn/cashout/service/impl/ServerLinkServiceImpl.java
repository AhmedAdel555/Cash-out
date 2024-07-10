package com.ahlymomkn.cashout.service.impl;

import com.ahlymomkn.cashout.model.entity.ServerLink;
import com.ahlymomkn.cashout.repository.ServerLinkRepository;
import com.ahlymomkn.cashout.service.ServerLinkService;
import org.springframework.stereotype.Service;

@Service
public class ServerLinkServiceImpl implements ServerLinkService {

    private final ServerLinkRepository serverLinkRepository;

    public ServerLinkServiceImpl(ServerLinkRepository serverLinkRepository) {
        this.serverLinkRepository = serverLinkRepository;
    }


    @Override
    public ServerLink updateServerLink(String id, String newLink) {
        ServerLink serverLink = serverLinkRepository.findById(id)
                .orElse(new ServerLink(id, newLink));
        serverLink.setLink(newLink);
        return serverLinkRepository.save(serverLink);    }

    @Override
    public String getServerLink(String id) {
        return serverLinkRepository.findById(id)
                .map(ServerLink::getLink)
                .orElse(null);
    }
}
