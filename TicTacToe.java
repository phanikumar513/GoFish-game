//go fish
import java.util.*;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		Random r=new Random();
		int t=10,i,r1,r2,temp=0,z=52,j,cc=7,uc=7,k,cs=0,us=0,ask=0,text=1,text1=0;
		char[]a={'A','2','3','4','5','6','7','8','9','T','K','Q','J','A','2','3','4','5','6','7','8','9','T','K','Q','J','A','2','3','4','5','6','7','8','9','T','K','Q','J','A','2','3','4','5','6','7','8','9','T','K','Q','J'};
//shuffle the cards
		for(i=0;i<=52;i++)
		{
			r1=r.nextInt(52);
			temp=a[r1];
			r2=r.nextInt(52);
			a[r1]=a[r2];
			a[r2]=(char)temp;
		}
		
//computer cards
		char[]com=new char[cc];
		for(i=0;i<7;i++)
		{
			r1=r.nextInt(z);
			com[i]=a[r1];
			for(j=r1;j<z-1;j++)
			{
				a[j]=a[j+1];
			}
			z--;
		}
		System.out.println("computer cards");
		for(i=0;i<cc;i++)
		{
			System.out.print(com[i]);
		}
		
// user cards
		char[]user=new char[uc];
		for(i=0;i<7;i++)
		{
			r2=r.nextInt(z);
			user[i]=a[r2];
			for(j=r2;j<z-1;j++)
			{
				a[j]=a[j+1];
			}
			z--;
		}
		System.out.println();
		System.out.println("user cards");
		for(i=0;i<uc;i++)
		{
			System.out.print(user[i]);
		}
//check for pair cards
//computer cards
		for(i=0;i<cc;i++)
		{
			for(j=i+1;j<cc;j++)
			{
				if(com[i]==com[j])
				{
					for(k=i;k<cc-1;k++)
					{
						com[k]=com[k+1];
					}
					cc--;					
					for(k=j-1;k<cc-1;k++)
					{
						com[k]=com[k+1];
					}
					cc--;
					cs++;
				}
			}
		}
		System.out.println();
		System.out.println("After pairing the computer cards");
		for(i=0;i<cc;i++)
		{
			System.out.print(com[i]);
			
		}
		System.out.println();
		System.out.print("score="+cs);
		
//user cards
		for(i=0;i<uc;i++)
		{
			for(j=i+1;j<uc;j++)
			{
				if(user[i]==user[j])
				{
					for(k=i;k<uc-1;k++)
					{
						user[k]=user[k+1];
					}
					uc--;
					for(k=j-1;k<uc-1;k++)
					{
						user[k]=user[k+1];
					}
					uc--;
					us++;
				}
			}
		}
		System.out.println();
		System.out.println("After pairing user cards");
		for(i=0;i<uc;i++)
		{
			System.out.print(user[i]);
			
		}
		System.out.println();
		System.out.print("score="+us);
		
		System.out.println();
		System.out.println("z="+z);
		
//playing each other
		while(z!=-1)
		{
			while(text==1)
			{
				System.out.println("Your chance(Ask one card to computer) :");
				for(i=0;i<uc;i++)
				{
					System.out.print(user[i]+" ");
				}
				System.out.println();
				System.out.print("Select the card position :");
				ask=obj.nextInt();
				System.out.println("User is asking for "+user[ask-1]+" card!!");
				for(i=0;i<cc;i++)
				{
					if(com[i]==user[ask-1])
					{
						text=0;
						temp=com[i];
						System.out.println("Card is found in computer cards!!");
//decreasing computer cards by 1
						for(j=i;j<cc-1;j++)
						{
							com[j]=com[j+1];
						}
						cc--;
//adding the card from computer to user
						uc++;
						user[uc-1]=(char)temp;
//checking for paring the cards
						for(j=ask-1;j<uc-1;j++)
						{
							user[j]=user[j+1];
						}
						uc=uc-2;	
						us++;
						text++;
						text1++;
						break;
					}
					
				}
				if(text1!=0)
				{
					text1=0;
					System.out.println("Card is not found in computer cards !!");
					System.out.println("GO FISH!!");
					text++;
				}
				break;
			}
//picking a card
			while(text==2)
			{
				uc++;
				System.out.println("Then your card is :"+a[z]);
				user[uc-1]=a[z];
				z--;
				for(i=0;i<uc;i++)
				{
					System.out.print(user[i]+" ");
				}
				
			}
		}
		
	}

}
