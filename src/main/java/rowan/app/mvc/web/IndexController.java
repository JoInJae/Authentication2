package rowan.app.mvc.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
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
    private Response index(@RequestBody Param param){

        return Response.set(ResponseType.SUCCESS);

    }

    @Getter
    public static class Param{
        private String abc;
    }

    @RequestMapping(value = "/route/**", method = RequestMethod.POST)
    private ModelAndView route(HttpServletRequest request, @RequestAttribute(name = "service") Services service, RedirectAttributes redirectAttributes){

        String path = "https://api.super-brain.co.kr" + request.getServletPath().replaceFirst("route", service.getPath());

        return new ModelAndView("redirect:"+path);

    }



}
