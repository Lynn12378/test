
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Member
{
	protected Data data=new Data();
	protected ArrayList<String> member=new ArrayList<String>();
	private int accIndex;
	public Member(String account,String name,String password,String identity)
	{
		setAccount(account);
		setName(name);
		setPassword(password);
		setIdentity(identity);
	}
	public Member(String account,String password)
	{
		setAccount(account);
		setPassword(password);
	}

	public boolean sign_up()
	{
		if(accIndex==-1)
		{
			JOptionPane.showMessageDialog(null,"���U���\\n�w�� "+getName(),"�w��",1);
			data.addMember(this);
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"���b���w�Q���U!","���~",0);
			return false;
		}
	}

	public String log_in()
	{
		if(accIndex==-1)
		{
			JOptionPane.showMessageDialog(null,"���b�����s�b!","���~",0);
			return "2";
		}
		else if(data.readMembers().get(accIndex).getPassword().equals(getPassword()))
		{
			setName(data.readMembers().get(accIndex).getName());
			setIdentity(data.readMembers().get(accIndex).getIdentity());
			JOptionPane.showMessageDialog(null,"�n�J���\\n�w�� "+getName(),"�w��",1);
			return "3";
		}
		else
		{
			JOptionPane.showMessageDialog(null,"�K�X���~!","ĵ�i",3);
			return "2";
		}
	}

	public int findAccount()
	{
		accIndex=-1;
		for(int i=0;i<data.readMembers().size();i++)
		{
			if(data.readMembers().get(i).getAccount().equals(getAccount())){accIndex=i;}
		}
		return accIndex;
	}
	public String toString()
	{
		String output="";
		for(int i=0;i<member.size();i++)
		{
			output+=member.get(i)+((i==member.size()-1)?"\n":"\t");
		}
		return output;
	}
	public void setAccount(String account){member.add(0,account);}
	public String getAccount(){return member.get(0);}

	public void setName(String name){member.add(1,name);}
	public String getName(){return member.get(1);}

	public String getPassword(){return member.get(2);}
	public void setPassword(String password){member.add(2,password);}

	public void setIdentity(String identity){member.add(3,identity);}
	public String getIdentity(){return member.get(3);}
}