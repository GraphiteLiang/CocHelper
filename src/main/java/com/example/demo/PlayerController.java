package com.example.demo;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/kphelper")
	public String pc() {
		return "kphelper";
	}
	@RequestMapping("/plhelper")
	public String pl() {
		return "plhelper";
	}
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage message)throws Exception{
		Thread.sleep(300);
		return new WiselyResponse("welcome"+message.getName());
	}
	@MessageMapping("/roll")
	@SendTo("/topic/game")
	public Dice roll(DicePara dp)throws Exception{
		Thread.sleep(100);
		return Dice.roll(dp.getPara(), dp.getName());
	}
	@RequestMapping("/ws")
	public String ws() {
		return "ws";
	}
}
