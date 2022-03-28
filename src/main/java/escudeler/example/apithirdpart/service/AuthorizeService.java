package escudeler.example.apithirdpart.service;

import org.springframework.stereotype.Service;

import escudeler.example.apispeak.grpc.PersonRequest;
import escudeler.example.apithirdpart.grpc.AuthorizeResponse;
import escudeler.example.apithirdpart.request.HelloRequest;
import escudeler.example.apithirdpart.response.AuthResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AuthorizeService {

	private static final String AUTH_NAME = "edivandro,pedro,pablo,maria,joana";

	public AuthorizeResponse validateGrpc(PersonRequest request) {
		boolean auth = AUTH_NAME.contains(request.getPersonName().toLowerCase());
		log.info("Return gRPC validation to person " + request.getPersonName() + "...");
		return AuthorizeResponse.newBuilder()
				.setAuthorized(auth)
				.build();
	}

	public AuthResponse validateHttp(HelloRequest request) {
		boolean auth = AUTH_NAME.contains(request.getPersonName().toLowerCase());
		log.info("Return http validation to person " + request.getPersonName() + "...");
		return AuthResponse.builder()
				.authorized(auth)
				.build();
	}

}
