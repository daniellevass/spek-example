package com.danielle.examplespek

interface CurrentAccount {

    fun connect()
    fun disconnect()
    fun getCurrentBalance() : Int
    fun addMoney(money: Int) : Int
    fun takeMoney(money: Int) : Int
}