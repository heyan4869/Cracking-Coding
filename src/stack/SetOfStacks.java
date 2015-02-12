package stack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class SetOfStacks{
	//store several stacks in the list
	ArrayList<Stack<Integer>> stackContainer;
	
	public SetOfStacks(){
		stackContainer=new ArrayList<Stack<Integer>>();
		stackContainer.add(new Stack<Integer>());
	}
	
	public void push(int value){
		int n = 100; //assume that each stack store 100 items
		Stack<Integer> lastStack=getLastStack();
		if(lastStack!=null && lastStack.size()<=n){
			lastStack.push(value);
		}
		
		else{
			Stack<Integer> stack=new Stack<Integer>();
			stack.push(value);
			stackContainer.add(stack);
		}
	}
	
	public int pop(){
		Stack<Integer> lastStack=getLastStack();
		int val=lastStack.pop();
		if(lastStack.size()==0 && !stackContainer.isEmpty()){
			stackContainer.remove(stackContainer.size()-1);
		}
		return val;
	}
	
	public Stack<Integer> getLastStack(){
		//return the last stack in the list
		return stackContainer.get(stackContainer.size()-1);
	}
	
	public Stack<Integer> getSpecStack(int index){
		//return one specified stack in the list
		return stackContainer.get(index);
	}
	
	public int popAt(int index) {
		// check if the index is out of bound
		if(index>stackContainer.size()-1)
			return Integer.MAX_VALUE;
		Stack<Integer> specStack = getSpecStack(index);
		int valAt = specStack.pop();
		if(specStack.size()==0 && !stackContainer.isEmpty()){
			stackContainer.remove(index);
		}
		return valAt;
	}
	
	
	
	public static void main(String[] args) {
		SetOfStacks setOfStcaks=new SetOfStacks();
		for(int i=0;i<10;i++){
			Random random=new Random();
			int value=random.nextInt()%100;
			setOfStcaks.push(value);
			System.out.print(value+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++){
			int n=setOfStcaks.pop();
			System.out.print(n+" ");
		}
		System.out.println();
	}

}
