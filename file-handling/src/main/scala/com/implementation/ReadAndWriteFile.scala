package com.implementation

import java.io.{File, PrintWriter}

import com.knoldus.FilesHandling

import scala.io.Source

class ReadAndWriteFile extends FilesHandling {
  override def readFiles(path: String): List[File] = {

    val pathObj = new File(path)
    val filesList = pathObj.listFiles().toList
    filesList

  }

  override def readFileContent(files: List[File]): List[(String, String)] = {
    for (filesList <- files if filesList.isFile) yield (filesList.getName, Source.fromFile(filesList).mkString)

  }

  override def contentCapitalize(contentList: List[(String, String)]): List[(String, String)] = {
    contentList.map { capitalizeContent => (capitalizeContent._1, capitalizeContent._2.toUpperCase)


    }
  }

  override def writeFileContent(updateContentList: List[(String, String)]): String = {
    updateContentList.foreach { writeFiles =>
      val writer = new PrintWriter(new File("/home/knoldus/Desktop/Folder1/" + writeFiles._1))
      writer.write(writeFiles._2)
      writer.close()

    }
    "write successfully"
  }
}
