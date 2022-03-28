package escudeler.example.apithirdpart.grpc;

import escudeler.example.apispeak.grpc.PersonRequest;
import escudeler.example.apithirdpart.grpc.ThirdPartGrpcServiceGrpc.ThirdPartGrpcServiceImplBase;
import escudeler.example.apithirdpart.service.AuthorizeService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@Log4j2
@RequiredArgsConstructor
@GrpcService
public class ThirdPartGrpcService extends ThirdPartGrpcServiceImplBase {

	private final AuthorizeService authorizeService;

	@Override
	public void authorize(PersonRequest request, StreamObserver<AuthorizeResponse> responseObserver) {
		try {
			AuthorizeResponse response = authorizeService.validateGrpc(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
		} catch (Exception e) {
			log.warn("Error on Third Part Authorization. ", e);
			responseObserver.onError(e);
		}
	}
}
