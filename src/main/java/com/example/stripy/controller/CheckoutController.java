package com.example.stripy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {
    @Value("${STRIPE_PUBLIC_KEY}")
    public String stripePublicKey;
    @GetMapping("/checkout")
    public String checkout (Model model, @RequestParam(required = true) String sysUserId,
                            @RequestParam(required = true) String amount)
    {
        Integer amountint = Integer.valueOf(amount);
        model.addAttribute("amount",amountint);
        model.addAttribute("stripePublicKey",stripePublicKey);
        model.addAttribute("currency","USD");
        model.addAttribute("systemUserId",sysUserId);
        return "checkout";
    }

}
