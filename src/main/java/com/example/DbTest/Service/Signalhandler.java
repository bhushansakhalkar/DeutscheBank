package com.example.DbTest.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.DbTest.Pojo.Algo;
import com.example.DbTest.Pojo.SignalHandlerPojo;

interface SignalHandlerPattern{
    public void handleSignal(Algo algo);
}

class Signal1Handler implements SignalHandlerPattern{
    public void handleSignal(Algo algo){
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
        
    }
}

class Signal2Handler implements SignalHandlerPattern{
    public void handleSignal(Algo algo){
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
        
    }
}

class Signal3Handler implements SignalHandlerPattern{
    public void handleSignal(Algo algo){
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
        
    }
}

class DefaultHandler implements SignalHandlerPattern{
    public void handleSignal(Algo algo){
        algo.cancelTrades();
        
    }
}

class SignalHandlerController{
    private Map<Integer, SignalHandlerPattern> signals = new HashMap<>();
    private final SignalHandlerPattern defaultSignal;

    public SignalHandlerController(){
        defaultSignal = new DefaultHandler();

        signals.put(1, new Signal1Handler());
        signals.put(2, new Signal2Handler());
        signals.put(3, new Signal3Handler());
    }

    public void register(int signal, SignalHandlerPattern signalHandlerPattern){
        signals.put(signal, signalHandlerPattern);
    }

    public SignalHandlerPattern gPattern(int signal){
        return signals.getOrDefault(signal, defaultSignal);
    }
} 
@Service
public class Signalhandler implements SignalHandlerPojo{

    private SignalHandlerController signalHandlerController;    
    public Signalhandler(){
        this.signalHandlerController = new SignalHandlerController();
    }
    
    public void addSignals(int signal,SignalHandlerPattern signalHandlerPattern){
        signalHandlerController.register(signal, signalHandlerPattern);
    }
    public void handleSignal(int signal) {
            Algo algo = new Algo();
            SignalHandlerPattern signalHandler = signalHandlerController.gPattern(signal);
            signalHandler.handleSignal(algo);
            algo.doAlgo();
    }
        
        
        }
