package com.objectCreation

import com.implementation.ReadAndWriteFile
import com.knoldus.FilesHandling


object CapitalizeContent {
  def writeCapitalizeContentObj(str: String): FilesHandling = {
    if (str == "capitalizecontent") {
      new ReadAndWriteFile
    } else {
      throw new Exception("invalid")


    }
  }


}

