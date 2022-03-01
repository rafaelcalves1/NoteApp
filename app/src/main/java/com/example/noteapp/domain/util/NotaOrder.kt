package com.example.noteapp.domain.util

sealed class NotaOrder(val orderType: OrderType){
    class Title(orderType: OrderType): NotaOrder(orderType)
    class Date(orderType: OrderType): NotaOrder(orderType)
    class Color(orderType: OrderType): NotaOrder(orderType)
}
