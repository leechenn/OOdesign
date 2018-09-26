package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import LinkedList.DList.Node;

class DListTest {

	@Test
	void testDListConstructor() {
		DList<Integer> dl = new DList<Integer>();
		assertEquals("[]",dl.toString());
		assertEquals("[]",dl.toStringRev());
		assertEquals(0,dl.size());
		assertEquals(null,dl.head());
		assertEquals(null,dl.tail());
		
		
		
	}
	@Test
	void testAppend() {
		DList<String> dl = new DList<String>();
		dl.append("Chen");
		assertEquals("[Chen]",dl.toString());
		assertEquals("[Chen]",dl.toStringRev());
		assertEquals(1,dl.size());
		dl.append("Lee");
		assertEquals("[Chen, Lee]",dl.toString());
		assertEquals("[Lee, Chen]",dl.toStringRev());
		assertEquals(2,dl.size());
		DList<String> dl2 = new DList<String>();
		dl2.append("");
		assertEquals("[]",dl2.toString());
		assertEquals("[]",dl2.toStringRev());
		assertEquals(1,dl2.size());
		dl2.append("");
		assertEquals("[, ]",dl2.toString());
		assertEquals("[, ]",dl2.toStringRev());
		assertEquals(2,dl2.size());
	}
	@Test
	void testPrepend() {
		DList<String> dl = new DList<String>();
		dl.prepend("Chen");
		assertEquals("[Chen]",dl.toString());
		assertEquals("[Chen]",dl.toStringRev());
		assertEquals(1,dl.size());
		dl.prepend("Lee");
		assertEquals("[Lee, Chen]",dl.toString());
		assertEquals("[Chen, Lee]",dl.toStringRev());
		assertEquals(2,dl.size());
		DList<String> dl2 = new DList<String>();
		dl2.prepend("");
		assertEquals("[]",dl2.toString());
		assertEquals("[]",dl2.toStringRev());
		assertEquals(1,dl2.size());
		dl2.prepend("");
		assertEquals("[, ]",dl2.toString());
		assertEquals("[, ]",dl2.toStringRev());
		assertEquals(2,dl2.size());
	}
	@Test
	void getNode() {
		DList<String> dl = new DList<String>();
		dl.append("Chen");
		dl.append("Lee");
		dl.append("Cornell");
		dl.append("University");
		DList.Node node1 = dl.getNode(0);
		assertEquals("Chen",dl.value(node1));
		DList.Node node2 = dl.getNode(1);
		assertEquals("Lee",dl.value(node2));
		DList.Node node3 = dl.getNode(2);
		assertEquals("Cornell",dl.value(node3));
		DList<String> dl2 = new DList<String>();
		
	}
	@Test
	void deleteNode() {
		DList<String> dl = new DList<String>();
		DList.Node nodeToBeDeleted = null;
		dl.append("Chen");
		dl.append("Lee");
		dl.append("Cornell");
		dl.append("University");
		nodeToBeDeleted = dl.getNode(0);
		dl.delete(nodeToBeDeleted);
		assertEquals("[Lee, Cornell, University]",dl.toString());
		assertEquals("[University, Cornell, Lee]",dl.toStringRev());
		assertEquals(3,dl.size());
		nodeToBeDeleted = dl.getNode(1);
		dl.delete(nodeToBeDeleted);
		assertEquals("[Lee, University]",dl.toString());
		assertEquals("[University, Lee]",dl.toStringRev());
		assertEquals(2,dl.size());
		nodeToBeDeleted = dl.getNode(1);
		dl.delete(nodeToBeDeleted);
		assertEquals("[Lee]",dl.toString());
		assertEquals("[Lee]",dl.toStringRev());
		assertEquals(1,dl.size());
		nodeToBeDeleted = dl.getNode(0);
		dl.delete(nodeToBeDeleted);
		assertEquals("[]",dl.toString());
		assertEquals("[]",dl.toStringRev());
		assertEquals(0,dl.size());
		
	}
	@Test
	void insertNode() {
		DList<String> dl = new DList<String>();
		DList.Node nodeToBeInserted = null;
		dl.append("Chen");
		dl.append("Lee");
		dl.append("Cornell");
		dl.append("University");
		nodeToBeInserted = dl.getNode(0);
		dl.insertAfter("Xiao", nodeToBeInserted);
		assertEquals("[Chen, Xiao, Lee, Cornell, University]",dl.toString());
		assertEquals("[University, Cornell, Lee, Xiao, Chen]",dl.toStringRev());
		assertEquals(5,dl.size());
		nodeToBeInserted = dl.getNode(1);
		dl.insertAfter("Morning", nodeToBeInserted);
		assertEquals("[Chen, Xiao, Morning, Lee, Cornell, University]",dl.toString());
		assertEquals("[University, Cornell, Lee, Morning, Xiao, Chen]",dl.toStringRev());
		assertEquals(6,dl.size());
		nodeToBeInserted = dl.getNode(5);
		dl.insertAfter("Student", nodeToBeInserted);
		assertEquals("[Chen, Xiao, Morning, Lee, Cornell, University, Student]",dl.toString());
		assertEquals("[Student, University, Cornell, Lee, Morning, Xiao, Chen]",dl.toStringRev());
		assertEquals(7,dl.size());

		
	}
	@Test
	void nodeAttribute() {
		DList<String> dl = new DList<String>();
		dl.append("Chen");
		dl.append("Lee");
		dl.append("Cornell");
		dl.append("University");
		DList<String>.Node node = dl.getNode(0);
		assertEquals(null,node.pred());
		assertEquals(dl.getNode(1),node.succ());
		assertEquals("Chen",node.value());
	}
	@Test
	void assertStatements(){
		DList<String> dl = new DList<String>();
		dl.append("Chen");
		dl.append("Lee");
		dl.append("Cornell");
		dl.append("University");
		DList.Node node = dl.new Node(null,"inserted",null);
		assertThrows(AssertionError.class,()->{dl.insertAfter("insert", node);});
		assertThrows(AssertionError.class,()->{dl.insertAfter("insert", null);});
		assertThrows(AssertionError.class,()->{dl.delete(node);});
		assertThrows(AssertionError.class,()->{dl.delete(null);});
		assertThrows(AssertionError.class,()->{dl.value(null);});
		assertThrows(AssertionError.class,()->{dl.getNode(5);});
		
		
	}
	
	

}
