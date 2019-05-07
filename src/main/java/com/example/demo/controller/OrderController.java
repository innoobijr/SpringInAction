package com.example.demo.controller;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        // The benefit of AuthenticaionPrincipal is that is deosnt require a cast and limit the secuity specific code to the annotation itself
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    /*
    * In OrderController, the processOrder() method is responsible for saving an order. It will need ot me modified to
    * determine who the authenticated user is and to call setUser() ont eh order object to connect the order with the User.
    * There are several ways to determine who the user is.Therese are a few of the most common ways:
    *   Inject a Prinicipal object into the controller method
    *   Inject an Authentication object into the controller method
    *   User SecurityContextholder to get at the security context
    *   User an @AuthenticationPrincipal annotated method
     */
}