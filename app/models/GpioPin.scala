package models

import com.pi4j.io.gpio.Pin
sealed abstract class GpioPin(desc: String, pin: Option[Pin])
abstract class ControllablePin(val gpioNum: Int, val desc: String, val pin: Pin) extends GpioPin(desc, Some(pin))
abstract class UncontrollablePin(desc: String) extends GpioPin(desc, None)

class Power3VPin() extends UncontrollablePin("3.3V DC Power")
class Power5VPin() extends UncontrollablePin("5.0V DC Power")
class GroundPin() extends UncontrollablePin("Ground")
class DncPin() extends UncontrollablePin("Do not connect")

class GeneralPin(gpioNum: Int, pin: Pin) extends ControllablePin(gpioNum, "", pin)
class PwmPin(gpioNum: Int, desc: String, pin: Pin) extends ControllablePin(gpioNum, desc, pin)
class Rs232Pin(gpioNum: Int, desc: String, pin: Pin) extends ControllablePin(gpioNum, desc, pin)
class SpiPin(gpioNum: Int, desc: String, pin: Pin) extends ControllablePin(gpioNum, desc, pin)
class I2cPin(gpioNum: Int, desc: String, pin: Pin) extends ControllablePin(gpioNum, desc, pin)
class I2cEepromPin(gpioNum: Int, desc: String, pin: Pin) extends ControllablePin(gpioNum, desc, pin)

object GpioPin {
  import com.pi4j.io.gpio.RaspiPin._
  case object Pin01 extends Power3VPin
  case object Pin02 extends Power5VPin
  case object Pin03 extends I2cPin(2, "SDA1(I2C)", GPIO_08)
  case object Pin04 extends Power5VPin
  case object Pin05 extends I2cPin(3, "SCL1(I2C)", GPIO_09)
  case object Pin06 extends GroundPin
  case object Pin07 extends GeneralPin(4, GPIO_07)
  case object Pin08 extends Rs232Pin(14, "TxD (RS232)", GPIO_15)
  case object Pin09 extends GroundPin
  case object Pin10 extends Rs232Pin(15, "RxD (RS232)", GPIO_16)
  case object Pin11 extends GeneralPin(17, GPIO_00)
  case object Pin12 extends PwmPin(18, "CPM_CLK/PWM0", GPIO_01)
  case object Pin13 extends GeneralPin(27, GPIO_02)
  case object Pin14 extends GroundPin
  case object Pin15 extends GeneralPin(22, GPIO_03)
  case object Pin16 extends GeneralPin(23, GPIO_04)
  case object Pin17 extends Power3VPin
  case object Pin18 extends GeneralPin(24, GPIO_05)
  case object Pin19 extends SpiPin(10, "SPI MOSI", GPIO_12)
  case object Pin20 extends GroundPin
  case object Pin21 extends SpiPin(9, "SPI MISO", GPIO_13)
  case object Pin22 extends GeneralPin(25, GPIO_06)
  case object Pin23 extends SpiPin(11, "SPI SCLK", GPIO_14)
  case object Pin24 extends SpiPin(8, "SPI CS0", GPIO_10)
  case object Pin25 extends GroundPin
  case object Pin26 extends SpiPin(7, "SPI CS1", GPIO_11)
  case object Pin27 extends DncPin
  case object Pin28 extends DncPin
  case object Pin29 extends GeneralPin(5, GPIO_21)
  case object Pin30 extends GroundPin
  case object Pin31 extends GeneralPin(6, GPIO_22)
  case object Pin32 extends GeneralPin(12, GPIO_26)
  case object Pin33 extends GeneralPin(13, GPIO_23)
  case object Pin34 extends GroundPin
  case object Pin35 extends GeneralPin(19, GPIO_24)
  case object Pin36 extends GeneralPin(16, GPIO_27)
  case object Pin37 extends GeneralPin(26, GPIO_25)
  case object Pin38 extends GeneralPin(20, GPIO_28)
  case object Pin39 extends GroundPin
  case object Pin40 extends GeneralPin(21, GPIO_29)

  val values: Seq[GpioPin] = Seq(
    Pin01, Pin02, Pin03, Pin04, Pin05, Pin06, Pin07, Pin08, Pin09, Pin10,
    Pin11, Pin12, Pin13, Pin14, Pin15, Pin16, Pin17, Pin18, Pin19, Pin20,
    Pin21, Pin22, Pin23, Pin24, Pin25, Pin26, Pin27, Pin28, Pin29, Pin30,
    Pin31, Pin32, Pin33, Pin34, Pin35, Pin36, Pin37, Pin38, Pin39, Pin40)

  val map: Map[Int, GpioPin] = values.zipWithIndex.map { case (p, i) => (i + 1, p) }.toMap
}