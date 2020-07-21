package com.example.demo;

import java.util.*;

public class Dice {
	public String result;
	private Dice(String arg) {
		result = arg;
	}
	public static Dice roll(String parament, String player) {
		String paras[] = parament.split(" ");
		if(paras.length==1) {
			String rarray = calculate(parament);
			String result = player + "[" + parament + "]，投掷结果为" + rarray;
			return new Dice(result);
		}else {
			int target = Integer.parseInt(paras[1]);
			List<Integer> rarray = roll(1,100);
			int rint = rarray.get(0);
			String success = check(rint, target);
			String result = player + "，投掷 [" + parament +
					"] 结果为" + rarray.toString() + "," + success;
			return new Dice(result);
		}
	}
	public static String calculate(String arg) {
		Stack<Integer> numStack = new Stack<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int ans = 0;
        char lastOp = '+';
        char[] args = arg.toCharArray();
        for(int i = 0; i < args.length; i ++){
            if(Character.isDigit(args[i])){
                int tempNum = args[i] - '0';
                while(++i < args.length && Character.isDigit(args[i])){
                    tempNum = tempNum * 10 + (args[i] - '0');
                } i--;

                if(lastOp == '+') numStack.push(tempNum);
                else if(lastOp == '-') numStack.push(-tempNum);
                else {
                	List<Integer> tmp = roll(numStack.pop(), tempNum);
                    res.add(tmp);
                    int tmpres = 0;
                    for(int j:tmp) {
                    	tmpres += j;
                    }
                	numStack.push(tmpres);
                }
            } else lastOp = args[i];
        }
        for(int num : numStack) ans += num;
        return res.toString() + "合计为 " +ans;
	}
	public static List<Integer> roll(int x, int y) {
		List<Integer> tmp= new ArrayList<Integer>();
		for(int i=0;i<x;i++) {
			 tmp.add((int)((y) * Math.random())+1);
		}
		return tmp;
	}
	public static String check(int res, int target) {
		if(res == 1)return "大成功";
		if(res <= target/5)return "极难成功";
		if(res <= target/2)return "困难成功";
		if(res <= target)return "成功";
		if(res == 100)return "大失败";
		if(res > 95) {
			if(target < 50)return "大失败";
			else return "失败";
		}
		return "失败";
		
	}
}
