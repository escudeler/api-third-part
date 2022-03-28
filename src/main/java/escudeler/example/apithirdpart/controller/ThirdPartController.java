package escudeler.example.apithirdpart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import escudeler.example.apithirdpart.request.HelloRequest;
import escudeler.example.apithirdpart.response.AuthResponse;
import escudeler.example.apithirdpart.service.AuthorizeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ThirdPartController {
	private final AuthorizeService authorizeService;
	
	@PostMapping("/authorize")
	public ResponseEntity<AuthResponse> authorize(@RequestBody HelloRequest speakRequest) {
		AuthResponse authResponse = authorizeService.validateHttp(speakRequest);
		return ResponseEntity.ok(authResponse);	
	}
}
