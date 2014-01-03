package com.tmg.fuse.poc;

import javax.jws.WebService;

@WebService
public interface CRMEndpoint {
    String account(String accountName, int id);
}
