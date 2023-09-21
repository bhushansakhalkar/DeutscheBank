package com.example.DbTest.Service;

import org.springframework.stereotype.Service;

import com.example.DbTest.Pojo.Algo;
import com.example.DbTest.Pojo.SignalHandlerPojo;

@Service
public class Signalhandler implements SignalHandlerPojo{
    public void handleSignal(int signal) {
        Algo algo = new Algo();
            switch (signal) {
                case 1:
                    algo.setUp();
                    algo.setAlgoParam(1,60);
                    algo.performCalc();
                    algo.submitToMarket();
                    break;
                    case 2:
                    algo.reverse();
                    algo.setAlgoParam(1,80);
                    algo.submitToMarket();
                    break;
                    case 3:
                    algo.setAlgoParam(1,90);
                    algo.setAlgoParam(2,15);
                    algo.performCalc();
                    algo.submitToMarket();
                    break;
                    default:
                    algo.cancelTrades();
                    break;
            }
        algo.doAlgo();
        }
}
