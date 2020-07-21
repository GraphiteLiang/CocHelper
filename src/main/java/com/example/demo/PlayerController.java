package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ComponentScan("com.example.demo")
public class PlayerController {
	@Autowired
	PlCardRepository plcardrepository;
	@Autowired
	WeaponRepository weaponrepository;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping("/kphelper")
	public ModelAndView pc() {
		return new ModelAndView("kphelper");
	}
	@RequestMapping("/plhelper")
	public ModelAndView pl() {
		return new ModelAndView("plhelper");
	}
	@MessageMapping("/roll")
	@SendTo("/topic/game")
	public Dice roll(DicePara dp)throws Exception{
		// Thread.sleep(100);
		return Dice.roll(dp.getPara(), dp.getName());
	}
	@MessageMapping("/savecard")
	public String save(PlCardCache pc) throws Exception{
		PlCard plc = new PlCard(pc);
		plcardrepository.save(plc);
		String data = pc.getWeapondata();
		for(String i:data.split(";")) {
			weaponrepository.save(new Weapon(i, plc));
		}
		return "completed";
	}
	@RequestMapping("/listpc")
	public List<PlCard> listCard(){
		List<PlCard> res = plcardrepository.findAll();
		return res;
	}
	@RequestMapping("/listweapon")
	public List<Weapon> listWeapon(){
		List<Weapon> res = weaponrepository.findAll();
		return res;
	}
	@RequestMapping("/deleteall")
	public String delete() {
		plcardrepository.deleteAll();
		return "completed";
	}
}
