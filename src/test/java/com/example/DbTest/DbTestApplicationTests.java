package com.example.DbTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DbTest.Service.Signalhandler;

@SpringBootTest
class DbTestApplicationTests {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
	@Test
	public void testSignalHandlerForCorrectInput() {
        Signalhandler signalhandler = new Signalhandler();
        signalhandler.handleSignal(2);
        assertEquals("reverse\r\n" + //
                "setAlgoParam 1,80\r\n" + //
                "submitToMarket\r\n" + //
                "doAlgo\r\n" + //
                        "",outContent.toString());
	
    }

}
