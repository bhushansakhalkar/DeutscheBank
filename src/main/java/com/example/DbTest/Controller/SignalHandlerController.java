package com.example.DbTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DbTest.Service.Signalhandler;

@Controller
public class SignalHandlerController {
    @Autowired
    private Signalhandler signalhandler;
    
    @RequestMapping("/send-signal/{number}")
    public void sendSignal(@PathVariable int number){
            signalhandler.handleSignal(number);
    }
}
