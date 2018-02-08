import java.awt.BorderLayout;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * 处理节点选中事件 www.2cto.com
 *
 * @author HAN
 *
 */
public class JTree_2 extends JFrame {
 /**
  *
  */
 private static final long serialVersionUID = -4187076423981270641L;

 public JTree_2() {
  DefaultMutableTreeNode root = new DefaultMutableTreeNode("本地磁盘（D：）");
  DefaultMutableTreeNode nodePicture = new DefaultMutableTreeNode("图片");
  root.add(nodePicture);
  root.add(new DefaultMutableTreeNode("音乐"));
  nodePicture.add(new DefaultMutableTreeNode("千山——世博园旅游"));
  DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode(
    "凤凰山——大鹿岛旅游");
  nodePicture.add(nodeSecond);
  nodeSecond.add(new DefaultMutableTreeNode("大浪淘沙.gif", false));
  nodeSecond.add(new DefaultMutableTreeNode("辽阔的大海.jpg", false));

  DefaultTreeModel defaultTreeModel = new DefaultTreeModel(root, true);
  final JTree defaultTree = new JTree(defaultTreeModel);
  getContentPane().add(defaultTree, BorderLayout.WEST);

  // expand initially all nodes
  @SuppressWarnings("rawtypes")
  Enumeration enumeration = root.preorderEnumeration();
  while (enumeration.hasMoreElements()) {
   DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration
     .nextElement();
   defaultTree.expandPath(new TreePath(node.getPath()));
  }

  // add the tree selection listener, and print the selection path to
  // screen
  TreeSelectionModel treeSelectionModel = defaultTree.getSelectionModel(); // get
                     // the
                     // selection
                     // model
  treeSelectionModel
    .setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
  defaultTree.addTreeSelectionListener(new TreeSelectionListener() {
   @Override
   public void valueChanged(TreeSelectionEvent e) {
    if (!defaultTree.isSelectionEmpty()) {
     TreePath[] selectionPaths = defaultTree.getSelectionPaths();
     for (int i = 0; i < selectionPaths.length; i++) {
      TreePath treePath = selectionPaths[i];
      Object[] path = treePath.getPath();
      for (int j = 0; j < path.length; j++) {
       DefaultMutableTreeNode node = (DefaultMutableTreeNode) path[j];
       System.out.print(node.getUserObject()
         + ((j == path.length - 1) ? "" : "-->"));
      }
      System.out.println();
     }
     System.out.println();
    }
   }
  });
 }

 public static void main(String[] args) {
  JTree_2 instance = new JTree_2();
  instance.setVisible(true);
  instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  instance.pack();
 }
}

 