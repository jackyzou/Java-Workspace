package Server;
import java.net.*;
import java.io.*;

/*用户链表的节点类*/
public class Node {
	String userName;
	Socket socket = null;
	ObjectOutputStream output = null;
	ObjectInputStream input = null;
	Node next = null;
	
}
