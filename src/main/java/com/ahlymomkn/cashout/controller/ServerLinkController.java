package com.ahlymomkn.cashout.controller;

import com.ahlymomkn.cashout.model.entity.ServerLink;
import com.ahlymomkn.cashout.service.ServerLinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serverlink")
public class ServerLinkController {

    private final ServerLinkService serverLinkService;

    public ServerLinkController(ServerLinkService serverLinkService) {
        this.serverLinkService = serverLinkService;
    }

    @PutMapping("/{id}")
    ResponseEntity<ServerLink> updateServerLink(@PathVariable Integer id, @RequestBody String serverLink){
   ServerLink updatedServerLink = serverLinkService.updateServerLink(id,serverLink);
    return ResponseEntity.ok(updatedServerLink);
}
    @GetMapping("/{id}")
    ResponseEntity<String> getServerLink(@PathVariable Integer id){
        String link = serverLinkService.getServerLink(id);
        return ResponseEntity.ok(link);
    }
}
