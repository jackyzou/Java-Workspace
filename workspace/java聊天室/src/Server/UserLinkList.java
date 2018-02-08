package Server;
/*用户链表*/
public class UserLinkList {
	Node root;
	Node pointer;
	int count;
	/*构造用户链表*/
	public UserLinkList(){
		root = new Node();
		root.next = null;
		pointer = null;
		count = 0;
	}
	
	/*添加用户*/
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
	/*删除用户*/
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
	/*返回用户数*/
	public int getCount(){
		return count;
	}
	/*根据用户名查找*/
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
	
	//根据索引查找用户
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
