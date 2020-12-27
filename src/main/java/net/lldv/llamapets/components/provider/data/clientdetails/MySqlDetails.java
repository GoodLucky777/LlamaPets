package net.lldv.llamapets.components.provider.data.clientdetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author LlamaDevelopment
 * @project UniversalClient
 * @website http://llamadevelopment.net/
 */
@Getter
@RequiredArgsConstructor
public class MySqlDetails extends ClientDetails {

    private final String host, port, user, password, database;

}
