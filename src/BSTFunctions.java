import java.util.ArrayList;

public class BSTFunctions
    {
        BSTNode ROOT;
        ArrayList<BSTNode> listNode = new ArrayList<BSTNode>();
        public BSTFunctions()
        {
            this.ROOT = null;
        }
        /**
        This function which insert the data into the tree
        */
        void insertNode(BSTNode node, Student std)
        {
            if (node == null)
            {
                node = new BSTNode(std);
                ROOT = node;
            }
            else if (Integer.parseInt(std.getStd_id()) < Integer.parseInt(node.std.getStd_id()) && node.left == null)
            {
                node.left = new BSTNode(std);
                node.left.parent = node;
            }
            else if (Integer.parseInt(std.getStd_id()) >= Integer.parseInt(node.std.getStd_id()) && node.right == null)
            {
                node.right = new BSTNode(std);
                node.right.parent = node;
            }
            else
            {
                if (Integer.parseInt(std.getStd_id()) < Integer.parseInt(node.std.getStd_id()))
                {
                    insertNode(node.left, std);
                }
                else
                {
                    insertNode(node.right, std);
                }
            }
        }


        /**
        This method will search using the Id o the student
        */
        
        public BSTNode searchByID(BSTNode node, String key)
        {
            if (node == null)
            {
                return null;
            }
            else if (Integer.parseInt(node.std.getStd_id()) == Integer.parseInt(key))
            {
                return node;
            }
            else
            {
                if (Integer.parseInt(key) < Integer.parseInt(node.std.getStd_id()))
                {
                    return searchByID(node.left, key);
                }
                else
                {
                    return searchByID(node.right, key);
                }
            }
        }

        
        
        public BSTNode searchByName(BSTNode node, Student std) {
           try{
            if (node == null) {
                return null;
            }

            //Checking Last Name by .equals

            else if (node.std.getLast_name().equalsIgnoreCase(std.getLast_name())) {
                return node;
            } else {
                if (Integer.parseInt(std.getStd_id()) < Integer.parseInt(node.std.getStd_id())) {
                    return searchByName(node.left, std);
                } else {
                    return searchByName(node.right, std);
                }
            }
            }catch (NullPointerException e){}
            return null;
        }


        public ArrayList<BSTNode> printInOrder(BSTNode node)
        {
            if (node != null)
            {
                printInOrder(node.left);
                listNode.add(node);
                printInOrder(node.right);
            }
            return listNode;
        }

        public void printPostOrder(BSTNode node)
        {
            if (node != null)
            {
                printPostOrder(node.left);
                printPostOrder(node.right);
                System.out.print(node.std.getStd_id() + " - ");
            }
        }

        public void printPreOrder(BSTNode node)
        {
            if (node != null)
            {
                System.out.print(node.std.getStd_id() + " - ");
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
        }
    }
