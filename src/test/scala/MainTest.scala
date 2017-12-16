import org.scalatest.FunSuite

class MainTest extends FunSuite {
  test("Invoke main in order to setup CI") {
    Main.main(null)
  }
}
