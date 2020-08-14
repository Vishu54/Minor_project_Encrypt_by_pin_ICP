import java.util.Scanner;
class EncryptByPin
{
	public static void main(String args[]) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter  the no digts  ");
		int n=in.nextInt();
		int num1,num2,num3,num4;
		int l,u;
		if(n==1)
		{
			l=0;
			u=(int)Math.pow(10, n);								
			num1=l+(int)(Math.random()*(u-l+1));				//random generation of single digit number
			num2=l+(int)(Math.random()*(u-l+1));
			num3=l+(int)(Math.random()*(u-l+1));
			num4=l+(int)(Math.random()*(u-l+1));
		}
		else
		{
			l=(int)Math.pow(10, (n-1));
			u=(int)Math.pow(10, n);
			num1=l+(int)(Math.random()*(u-l+1));				//random generation of single digit number
			num2=l+(int)(Math.random()*(u-l+1));
			num3=l+(int)(Math.random()*(u-l+1));
			num4=l+(int)(Math.random()*(u-l+1));
		}
		
		int rem1,rem2,rem3,rem4;
		int x,pin=0;
		for(x=0;x<n;x++)
		{
			rem1=num1%10;
			rem2=num2%10;
			rem3=num3%10;
			rem4=num4%10;
			//min
			int min=(int)Math.min(rem1, Math.min(rem2,Math.min(rem3, rem4)));			// min value generation
			num1=num1/10;
			num2=num2/10;
			num3=num3/10;
			num4=num4/10;		
			
			pin=pin+min*(int)Math.pow(10, x);
			
		}
			System.out.println(pin+" pin");
		    int pin1=0;
		while(pin!=0)
		{
			pin1=(pin1*10)+(pin%10);									//pin generation
			pin/=10;
			
		}
		System.out.println("Enter the message  ");						
		String msg=in.nextLine();										//message input
		msg=in.nextLine();								
		msg=msg.toLowerCase();											//Message processing
		msg=msg.replaceAll(" ","");
		int index=msg.length();
		int temp=pin1;
		int rem=0;
		char ch;
		x=0;
		int i;					
		while(x<index)										//encryption of pin  
		{		
			
			while(pin1!=0)
			{
				rem=pin1%10;
				ch=msg.charAt(x);			
				ch=(char)(ch+rem);
				if(ch>'z')
				{
					i=(int)(ch-'z');
					ch=(char)(96+i);
				}
				ch=Character.toUpperCase(ch);
				System.out.print(ch);
				pin1/=10;
				break;
			}
			
			if(pin1==0)
				pin1=temp;
			x++;	
		}		
							
	}
}