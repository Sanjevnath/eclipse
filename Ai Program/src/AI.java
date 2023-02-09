import java.util.Scanner;

public class AI {

	private String command;
    private String answer;
    private String action;
    
    static String[] maths= {"add","plus","+","sum","minus","-","subtract","divide","/","multiply","multiple","x","*"};  
    String[] minus= {"minus","subtract","-"};
	String[] add= {"add","+","plus"};
	String[] divide= {"divide","/"};
	String[] multiply= {"multiply","multiple","x","*"};
    
    AI(){
    	System.out.println("Your Commands are limited add important key such as add,+,minus,- ,divide,/,multiply,x or * and add spaces in between to calculate");
		System.out.println("Enter Your Command");
		Scanner	readCommand= new Scanner(System.in);
		command=readCommand.nextLine().toLowerCase();
		checkCommand();
		readCommand.close();
	    }
    public String checkCommand() {

		String a = null;
		String b = null;
		
		String arrCommand[]=command.split(" ");// Storing all the words into arrays to search through array for users keyword/command
		
			action=search(arrCommand);
			if(action=="not Found") {
				answer="You have Entered incorrect input. Please add your input with spaces in between";
			}
			
			for(int i=0;i<arrCommand.length;i++) {
				
				if(arrCommand[i].matches(".*[0-9]+.*")) {
					//System.out.println(arrCommand[i]);
					if(a==null) {
						
						a=arrCommand[i];
					}
					else if(b==null) {
						b=arrCommand[i];
					    break;
					}
					
				}
		}
			
			if(action.equals("Not Found")) {
				answer="You have Entered incorrect input. Please add your input with spaces in between or try again with different input";
			}else {
			answer ="The answer is "+ Integer.toString(calculate(Integer.parseInt(a),Integer.parseInt(b)));}
		return answer;
		
	}
    
public static String search(String[] arrCommand) {
		
		for(String x:arrCommand) {
		for(int i=0;i<maths.length;i++) {
			if(maths[i].equals(x)) {
				return maths[i];
				
			}
		}
		}
		return "Not Found";
	}
    
	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	 

	
	private int calculate(int a , int b) {
		int calc=0;
		//Searches Minus array
			for(int i=0;i<minus.length;i++) {
				if(minus[i].equals(action)) {
					action="minus";
					break;
				}
			}
			//Searching Add array
			for(int j=0;j<add.length;j++) {
				if(add[j].equals(action)) {
					action="add";
					break;
				}
			}
			//Searching divide Array
			for(int k=0;k<divide.length;k++) {
				if(divide[k].equals(action)) {
					action="divide";
					break;
				}
			}
			//Searching multiply
			for(int l=0;l<multiply.length;l++) {
				if(multiply[l].equals(action)) {
					action="multiply";
					break;
				}
			}
			
			
		
		switch(action) {
		case "minus" :calc= a-b;
		break;
		case "add" : calc= a+b;
		break;
		case "multiply":calc=a*b;
		break;
		case "divide":calc=a/b;
		break;
		default: return 0;
		}
		return calc;
	}
	

}