package rowan.app.mvc.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rowan.app.data.dto.response.Response;
import rowan.app.data.type.ResponseType;
import rowan.app.data.vo.Services;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class IndexController {

    @RequestMapping(value = "/auth", method = {RequestMethod.GET, RequestMethod.POST})
    private Response index(){

        return Response.set(ResponseType.SUCCESS);


    }

    @RequestMapping(value = "/route/**", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    private ModelAndView route(HttpServletRequest request, @RequestAttribute(name = "service") Services service, RedirectAttributes redirectAttributes){

        String path = "https://api.super-brain.co.kr" + request.getServletPath().replaceFirst("route", service.getPath());

        ModelAndView mav = new ModelAndView("redirect:"+path);

        mav.addObject("userId", "userID");

        return mav;

    }


}
