package testing.fixtures.different

import org.scalatest._
import java.io._
import collection.mutable.Map

class CallingLoanFixtureMethods extends FlatSpec {

  def withFile(testCode: (File, FileWriter) => Any) {

    val file = new File("trash/loan-pattern.txt")
    val writer = new FileWriter(file)

    try
      testCode(file, writer)
    finally
      writer.close
  }

  def withDatabase(testCode: Map[String, Int] => Any) {

    val db = Map[String, Int]()

    try
      testCode(db)
    finally
      db.clear
  }

  "This test" should "do something with file" in
    withFile { (file, writer) =>
      writer write "operation on file #1\n"
      assert(2 + 2 === 4)
    }

  "This test" should "do something with database" in
    withDatabase { db =>
      db("one") = 1
      assert(2 + 2 === 4)
    }

  "This test" should "do something both with file and database" in
    withFile { (file, writer) =>
      withDatabase { db =>
        db("two") = 2
        writer write "operaton on file #2\n"
        assert(2 + 2 === 4)
      }
    }
}