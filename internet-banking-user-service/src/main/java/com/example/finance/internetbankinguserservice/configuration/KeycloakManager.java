package com.example.finance.internetbankinguserservice.configuration;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeycloakManager {
	 private  KeycloakProperties keycloakProperties;

	    public RealmResource getKeyCloakInstanceWithRealm() {
	        return keycloakProperties.getInstance().realm(keycloakProperties.getRealm());
	    }
}
