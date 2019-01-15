package net.ddns.ziehlke.eletopo.controller;

import net.ddns.ziehlke.eletopo.entity.Grade;
import net.ddns.ziehlke.eletopo.entity.Route;
import net.ddns.ziehlke.eletopo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@RequestMapping("/route")
public class RouteController {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewRoute(
            @RequestParam String name,
            @RequestParam Grade grade,
            @RequestParam int lineNo,
            @RequestParam LocalDate dateOfCreation) {

        Route route = new Route();
        route.setName(name);
        route.setGrade(grade);
        route.setLineNo(lineNo);
        route.setDateOfCreation(null == dateOfCreation ? LocalDate.now() : dateOfCreation);

        routeRepository.save(route);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

}
