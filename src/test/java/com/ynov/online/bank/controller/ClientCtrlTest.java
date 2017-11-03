package com.ynov.online.bank.controller;

import org.junit.Test;

import static org.junit.Assert.*;

// Created on 03/11/2017.
public class ClientCtrlTest {
    private ClientCtrl clientCtrl = new ClientCtrl();

    @Test
    public void checkPassword() throws Exception {

        // Check length
        assertEquals(clientCtrl.checkPassword("1A$a"), false);

        //Check different required elements
        assertEquals(clientCtrl.checkPassword("1Aaaaaaa"), false);
        assertEquals(clientCtrl.checkPassword("1$aaaaaa"), false);
        assertEquals(clientCtrl.checkPassword("A$aaaaaa"), false);

        //Valid pass
        assertEquals(clientCtrl.checkPassword("1A$aaaaa"), true);
    }
}