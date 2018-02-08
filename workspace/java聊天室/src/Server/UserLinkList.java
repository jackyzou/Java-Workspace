package Server;
/*�û�����*/
public class UserLinkList {
	Node root;
	Node pointer;
	int count;
	/*�����û�����*/
	public UserLinkList(){
		root = new Node();
		root.next = null;
		pointer = null;
		count = 0;
	}
	
	/*����û�*/
	public void addUser(Node node){
		pointer = root;
		
		while(pointer.next != null)
		{
			pointer = pointer.next;
		}
		
		pointer.next = node;
		node.next = null;
		count++;
	}
	/*ɾ���û�*/
	public void delUser(Node node){
		pointer = root;
		Node delNode = pointer.next;
		
		while(delNode != node){
			pointer = delNode;
			delNode = delNode.next;
		}
		pointer.next = delNode.next;
		count--;
	}
	/*�����û���*/
	public int getCount(){
		return count;
	}
	/*�����û�������*/
	public Node findUser(String name){
		if(count == 0) return null;
		pointer = root;
		
		while(pointer.next != null){
			pointer = pointer.next;
			if(pointer.userName.equalsIgnoreCase(name)){
				return pointer;
			}
		}
		return null;
		
	}
	
	//�������������û�
	public Node findUser(int index){
		if(count == 0)
		{
			return null;
		}
		if(index < 0){
			return null;
		}
		pointer = root;
		
		int i = 0;
		while(i < index+1 ){
			if( pointer.next != null){
				pointer = pointer.next;
			}else{
				return null;
			}
			i++;
		}
			return pointer;
		
	}
}
