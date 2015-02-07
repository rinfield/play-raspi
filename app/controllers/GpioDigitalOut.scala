package controllers

import play.api._
import play.api.mvc._
import models.GpioPin
import models.ControllablePin
import com.pi4j.io.gpio.GpioFactory
import com.pi4j.io.gpio.GpioPinDigitalOutput
import com.pi4j.io.gpio.PinState

object GpioDigitalOut extends Controller {

  val gpio = GpioFactory.getInstance

  val pins: Map[Int, Option[GpioPinDigitalOutput]] = GpioPin.map.collect {
    case (i, p: ControllablePin) =>
      val out = gpio.provisionDigitalOutputPin(p.pin, p.toString, PinState.LOW)
      (i, Some(out))
    case (i, _) => (i, None)
  }

  def digitalOut(pin: Int, value: Boolean) = Action {
    (pins(pin), value) match {
      case (None, _) => BadRequest("not a controllable pin!")
      case (Some(out), true) =>
        out.high()
        Ok("on")
      case (Some(out), false) =>
        out.low()
        Ok("off")
    }
  }
}