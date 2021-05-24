package escudeler.example.apithirdpart.service;

import org.springframework.stereotype.Service;

import escudeler.example.apispeak.grpc.SpeakRequest;
import escudeler.example.apithirdpart.grpc.AuthorizeResponse;
import escudeler.example.apithirdpart.request.HelloRequest;
import escudeler.example.apithirdpart.response.AuthResponse;

@Service
public class AuthorizeService {

	private static final String AUTH_NAME = "edivandro,pedro,pablo,maria,joana";

	public AuthorizeResponse validate(SpeakRequest request) {
		boolean auth = AUTH_NAME.contains(request.getPeopleName().toLowerCase());
		return AuthorizeResponse.newBuilder()
				.setAuthorized(auth)
				.build();
	}

	public AuthResponse validate(HelloRequest request) {
		boolean auth = AUTH_NAME.contains(request.getPeopleName().toLowerCase());
		return AuthResponse.builder()
				.authorized(auth)
				.build();
	}

}
