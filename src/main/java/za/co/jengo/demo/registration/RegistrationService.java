package za.co.jengo.demo.registration;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(final RegistrationRequest request) {
        return "It works";
    }
}
