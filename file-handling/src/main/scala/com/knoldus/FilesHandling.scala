package com.knoldus

import java.io.File

import com.objectCreation.CapitalizeContent

trait FilesHandling {
  def readFiles(path: String): List[File]

  def readFileContent(files: List[File]): List[(String, String)]

  def contentCapitalize(contentList: List[(String, String)]): List[(String, String)]

  def writeFileContent(updateContentList: List[(String, String)]): String
}

object FilesHandlingDriver {
  def main(args: Array[String]): Unit = {
    try {
      val obj = CapitalizeContent.writeCapitalizeContentObj("capitalizecontent")
      val path = "/home/knoldus/Folder1/"
      val filesList = obj.readFiles(path)
      val content = obj.readFileContent(filesList)
      val capitalizeContent = obj.contentCapitalize(content)
      print(obj.writeFileContent(capitalizeContent))
    }
    catch {
      case ex: Exception => print(ex.getMessage)

    }

  }
}
