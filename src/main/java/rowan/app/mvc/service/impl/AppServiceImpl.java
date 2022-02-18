package rowan.app.mvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rowan.app.mvc.repo.impl.ServicesRepository;
import rowan.app.mvc.service.AppService;

@RequiredArgsConstructor
@Service
public class AppServiceImpl implements AppService {

    private final ServicesRepository servicesRepository;


    @Override
    public boolean checkService() {

        return false;
    }
}
