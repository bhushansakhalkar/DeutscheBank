package com.example.DbTest.Pojo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Algo {

    public void doAlgo() {
        System.out.println("doAlgo");
        }
        public void cancelTrades() {
        System.out.println("cancelTrades");
        }
        public void reverse() {
        System.out.println("reverse");
        }
        public void submitToMarket() {
        System.out.println("submitToMarket");
        }
        public void performCalc() {
        System.out.println("performCalc");
        }
        public void setUp() {
        System.out.println("setUp");
        }
        public void setAlgoParam(int param, int value) {
        System.out.println("setAlgoParam " + param + "," + value);
        }
    
}
