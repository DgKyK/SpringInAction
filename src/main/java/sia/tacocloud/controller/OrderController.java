package sia.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.domain.Oreder;
import sia.tacocloud.domain.User;
import sia.tacocloud.repository.OrderRepository;
import sia.tacocloud.repository.UserRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Oreder());
        return "orderForm";
    }


    @PostMapping
    public String processOrder(@Valid Oreder order, Errors errors, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);

        orderRepository.save(order);
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
