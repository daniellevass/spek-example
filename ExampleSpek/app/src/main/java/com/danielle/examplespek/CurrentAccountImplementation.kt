package com.danielle.examplespek

import java.lang.Exception

object CurrentAccountImplementation : CurrentAccount {

    var balance = 0
    var isConnected = false

    override fun connect() {
        isConnected = true
        balance = 0
    }

    override fun disconnect() {
       isConnected = false
    }

    override fun getCurrentBalance(): Int {
        if (!isConnected) throw Exception("need to be connected first")
        return balance
    }

    override fun addMoney(money: Int): Int {
        if (!isConnected) throw Exception("need to be connected first")
        balance += money
        return balance
    }

    override fun takeMoney(money: Int): Int {
        if (!isConnected) throw Exception("need to be connected first")
        if (balance < money) throw Exception("insufficient funds")
        balance -= money
        return balance
    }
}