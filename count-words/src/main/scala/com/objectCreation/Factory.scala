package com.objectCreation

import com.implementation.ReadAndUpdateFile

import com.knoldus.CountWords


object Factory{
  def writeCapitalizeContentObj(str:String):CountWords={
    if(str=="countwords") {
      new ReadAndUpdateFile
    } else{
      throw new Exception("invalid")


    }
  }


}

