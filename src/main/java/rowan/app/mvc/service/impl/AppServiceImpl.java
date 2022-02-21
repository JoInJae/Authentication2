package rowan.app.mvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rowan.app.conf.exception.client.UnknownServiceTypeException;
import rowan.app.conf.exception.client.WrongParameterException;
import rowan.app.data.vo.Services;
import rowan.app.mvc.repo.impl.ServicesRepository;
import rowan.app.mvc.service.AppService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppServiceImpl<T> implements AppService {

    private final ServicesRepository servicesRepository;

    @Override
    public Services getService(String type) {

        return servicesRepository.findByType(type).orElseThrow(UnknownServiceTypeException::new);

    }

}
