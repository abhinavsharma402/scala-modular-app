package com.knoldus

import java.io.File

import com.objectCreation.Factory

trait CountWords {
  def readFiles(path: String): List[File]

  def readFileContent(files: List[File]): List[(String, String)]

  def wordsCount(contentList: List[(String, String)]): List[(String, String)]

  def writeFileContent(updateContentList: List[(String, String)]): String
}

object FilesHandlingDriver {
  def main(args: Array[String]): Unit = {
    try {
      val obj =
        Factory.writeCapitalizeContentObj("countwords")
      val path = "/home/knoldus/Folder1/"
      val filesList = obj.readFiles(path)
      val content = obj.readFileContent(filesList)
      val capitalizeContent = obj.wordsCount(content)
      print(obj.writeFileContent(capitalizeContent))
    }
    catch {
      case ex: Exception => print(ex.getMessage)

    }

  }
}

