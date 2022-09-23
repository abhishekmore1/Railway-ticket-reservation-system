package com.example.springpaypalpaymentgateway;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class PayPalController {

    @Autowired
    PayPalService payPalService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    public static final String SUCCESS_URL="pay/success";
    public static final String CANCEL_URL="pay/cancel";



    //method to perform payment process
    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") Order order){

//        Bookings booking=restTemplate.getForObject("http://booking-service:8084/booking/viewTicket/"+email,Bookings.class);
//        order.setPrice(booking.getTotalPrice());
        try {
            Payment payment=payPalService.createPayment(order.getPrice(),order.getCurrency(),order.getMethod(),
                    order.getIntent(),order.getDescription(),"http://localhost:8090/"+CANCEL_URL,
                    "http://localhost:8090/"+SUCCESS_URL);

            //get the link to redirect to paypal
            for(Links link: payment.getLinks()){
                if(link.getRel().equals("approval_url")){
                    return "redirect:"+link.getHref();
                    //redirect to paypal payment processing url
                }
            }
        } catch (PayPalRESTException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    //cancel url
    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    //success url
    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}
