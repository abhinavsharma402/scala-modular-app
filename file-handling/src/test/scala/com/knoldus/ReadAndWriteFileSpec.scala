package com.knoldus
import java.io.File
import com.implementation.ReadAndWriteFile

import com.objectCreation.CapitalizeContent
import org.scalatest._

class ReadAndWriteFileSpec extends FlatSpec with BeforeAndAfterAll {


  var obj: FilesHandling = CapitalizeContent.writeCapitalizeContentObj("capitalizecontent")

  override def beforeAll(): Unit = {
    obj = CapitalizeContent.writeCapitalizeContentObj("capitalizecontent")
  }

  override def afterAll(): Unit = {
    if (obj != null) {
      obj = null
    }
    "write file  content" should "write update content" in {
      val path = "/home/knoldus/Folder1/"
      val filesList = obj.readFiles(path)
      val content = obj.readFileContent(filesList)
      val capitalizeContent = obj.contentCapitalize(content)

      val actualResult = obj.writeFileContent(capitalizeContent)
      val expectedResult="write successfully"
      assert(expectedResult == actualResult)
    }

  }
}
