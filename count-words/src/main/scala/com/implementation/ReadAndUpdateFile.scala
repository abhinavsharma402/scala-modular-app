package com.implementation

import java.io.{File, PrintWriter}

import com.knoldus.CountWords

import scala.io.Source


class ReadAndUpdateFile extends CountWords {
  override def readFiles(path: String): List[File] = {

    val pathObj = new File(path)
    val filesList = pathObj.listFiles().toList
    filesList

  }

  override def readFileContent(files: List[File]): List[(String, String)] = {
    for (filesList <- files if filesList.isFile) yield (filesList.getName, Source.fromFile(filesList).mkString)

  }

  override def wordsCount(contentList: List[(String, String)]): List[(String, String)] = {
    contentList.map { capitalizeContent =>
      val wordsList = capitalizeContent._2.split(" ").toList
      val uniqueWords =wordsList.groupBy(identity)
      val countWords = uniqueWords.map(updateList => updateList._1 -> updateList._2.length).toString
      (capitalizeContent._1, countWords)

    }
  }

  override def writeFileContent(updateContentList: List[(String, String)]): String = {
    updateContentList.foreach { writeFiles =>
      val writer = new PrintWriter(new File("/home/knoldus/Desktop/Folder2/" + writeFiles._1))
      writer.write(writeFiles._2.split("HashMap")(1))
      writer.close()

    }
    "write successfully"
  }
}
