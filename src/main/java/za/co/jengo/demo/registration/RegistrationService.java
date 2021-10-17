package za.co.jengo.demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.jengo.demo.appuser.AppUser;
import za.co.jengo.demo.appuser.AppUserRoleEnum;
import za.co.jengo.demo.appuser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(final RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalArgumentException("Invalid email");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                request.getPassword(),
                AppUserRoleEnum.USER
        ));
    }
}
